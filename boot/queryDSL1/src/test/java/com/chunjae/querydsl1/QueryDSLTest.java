package com.chunjae.querydsl1;

import com.chunjae.querydsl1.domain.MyBoard;
import static com.chunjae.querydsl1.domain.QMyBoard.myBoard;

import static com.chunjae.querydsl1.domain.QUserEmployees.userEmployees;

import com.chunjae.querydsl1.domain.UserDepartments;
import com.chunjae.querydsl1.domain.UserEmployees;
import com.chunjae.querydsl1.dto.EmpDTO;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static org.assertj.core.api.Assertions.*;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class QueryDSLTest {
    @PersistenceContext
    private EntityManager em;


    @Test
    public void before(){
        assertThat(em).isNotNull();
    }

    @Test
    public void selectAll(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        //QMyBoard myBoard = QMyBoard.myBoard;
        List<MyBoard> list = queryFactory.select(myBoard)
                .from(myBoard)
                .fetch();
        for(MyBoard b:list){
            System.out.printf("%d, %s, %s\n",b.getBoardId(),b.getTitle(),b.getContent());
        }

    }

    @Test
    public void where(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        MyBoard list = queryFactory.selectFrom(myBoard)  // select * from my_board 를 한 번에 쓸 수 있다.
                .where(myBoard.boardId.eq(100L))
                .fetchOne();
        assertThat(list.getTitle()).isEqualTo("Steven");
    }

    /* queryDSL where 절 메서드
      eq ==
      ne !=
      isNotNull
      Myboard.getTitle in(,)
      notIn
      Myboard1.getSalary between(,)
      goe >=
      gt >
      loe <=
      lt <
      like
      contains
    */

    @Test
    public void whereExam(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // where() 안에 , 로 조건 여러개 나열해도 되고 .where 을 계속 붙여도 동작한다.
        List<MyBoard> list = queryFactory.selectFrom(myBoard)
                .where(myBoard.title.like("%a%"),myBoard.boardId.between(150L,180L))
                //.where(myBoard.boardId.between(150L,180L))
                .fetch();
        for(MyBoard b:list){
            System.out.println(b.getBoardId()+","+b.getTitle());
        }
        //assertThat(list.get(0).getTitle()).isEqualTo("Peter");
    }

    @Test
    public void where2(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<MyBoard> list = queryFactory.selectFrom(myBoard)
                //.where(myBoard.boardId.in(100L,200L))
                .where(myBoard.boardId.between(100L,105L))
                .fetch();
        assertThat(list.size()).isEqualTo(6);
        for(MyBoard d:list){
            System.out.println(d.getBoardId());
        }

    }

    @Test
    public void orderby(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<UserEmployees> list = queryFactory.selectFrom(userEmployees)
                .where(userEmployees.hireDate.goe(LocalDate.of(1990,1,1)))
                .orderBy(userEmployees.salary.desc(), userEmployees.firstName.asc().nullsLast())
                .fetch();
        //assertThat(list.size()).isEqualTo(6);
        for(UserEmployees e:list){
            System.out.println(e.getFirstName()+","+e.getSalary()+","+e.getHireDate());
        }
    }


    @Test
    public void isNull(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<UserEmployees> list = queryFactory.selectFrom(userEmployees)
                .where(userEmployees.empDept.isNull())
                // empDept.dname.isNull() 과 같이 컬럼에 대해 사용도 가능하나, 이것의 의미는 joinColumn 의 null 여부를 확인 하는 것임
//                .orderBy(userEmployees.hireDate.desc())
//                .offset(0)
//                .limit(10)
                .fetch();
        for(UserEmployees e:list){
            System.out.println(e.getFirstName()+","+e.getSalary()+","+e.getHireDate());
        }
    }

    @Test
    public void aggregate(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // queryDSL 에서는 Object[] 로 받지 않고 Tuple 이라는 타입으로 받을 수 있다.
        List<Tuple> list = queryFactory.select(userEmployees.count(), userEmployees.salary.max(), userEmployees.salary.avg())
                .from(userEmployees)
                .fetch();
        for(Tuple t:list){
            // Tuple 의 요소는 idx 나, 설정한 컬럼 이름으로 받을 수 있다.
            System.out.println(t.get(0,Tuple.class));
            System.out.println(t.get(userEmployees.salary.avg()));
            System.out.println(t.size());
            // Tuple 을 Object[] 로 바꾸는 것도 가능하다.
            Object[] os = t.toArray();
            System.out.println(os[0]);
        }

    }

    @Test
    public void returnWithDTO(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // DTO 로 받기 위해서 Projections.bean() 을 사용하면, DTO 생성자를 이용함.
        List<EmpDTO> list = queryFactory
                .select(Projections.bean(EmpDTO.class
                        ,userEmployees.eid
                        ,userEmployees.firstName
                        ,userEmployees.hireDate
                        ,userEmployees.salary))  // AllArgs 로 생성한 것과 같다.
                .from(userEmployees)
                .where(userEmployees.hireDate.year().eq(2024))
                .fetch();
        for(EmpDTO t:list){
            System.out.printf("%d, %s, %s, %.1f\n",t.getEid(),t.getFirstName(),t.getHireDate(),t.getSalary());
        }

    }

    @Test
    public void returnWithDTO2(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // Projections.fields() 을 사용하면 생성자나 setter 없이도 만들어 줄 수 있다.
        List<EmpDTO> list = queryFactory
                .select(Projections.fields(EmpDTO.class
                        ,userEmployees.eid        // dto 필드 이름과 entity 필드 이름이 다른 경우에 .as("dto 필드명")
                        ,userEmployees.firstName  // 여기서의 as 는 DB 에서 컬럼이나 테이블에 alias 붙이는 것과 다른 의미이다.
                        ,userEmployees.hireDate
                        ,userEmployees.salary))
                .from(userEmployees)
                .where(userEmployees.hireDate.year().eq(2024))
                .fetch();
        for(EmpDTO t:list){
            System.out.printf("%d, %s, %s, %.1f\n",t.getEid(),t.getFirstName(),t.getHireDate(),t.getSalary());
        }

    }



}
