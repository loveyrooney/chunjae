package com.chunjae.querydsl1;

import com.chunjae.querydsl1.domain.UserEmployees;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.chunjae.querydsl1.domain.QUserEmployees.*;
import static com.chunjae.querydsl1.domain.QUserDepartments.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QueryDSL3 {
    @PersistenceContext
    private EntityManager em;
    private Logger logger = LoggerFactory.getLogger(QueryDSLTest2.class);

    @Test
    public void groupBy(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> e1 = queryFactory.select(userEmployees.hireDate.year(), userEmployees.salary.sum(), userEmployees.salary.avg())
                .from(userEmployees)
                .groupBy(userEmployees.hireDate.year())
                //.having(userEmployees.hireDate.year().goe(LocalDate.now().getYear()))
                .fetch();
        assertThat(e1.size()).isGreaterThan(0);
        e1.stream().forEach(item->{
            System.out.println(item.get(userEmployees.hireDate.year())
                    +","+item.get(userEmployees.salary.sum())
                    +","+item.get(userEmployees.salary.avg()));
        });
        //logger.info("t1...{}",e1.getFirstName());
    }

    @Test
    public void exam(){
        // 1998 입사자 사원번호, 이름, 급여, 입사년도
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> e1 = queryFactory
                .select(userEmployees.eid, userEmployees.firstName, userEmployees.salary, userEmployees.hireDate)
                .from(userEmployees)
                .where(userEmployees.hireDate.year().eq(1998))
                //.having(userEmployees.hireDate.year().goe(LocalDate.now().getYear()))
                .fetch();
        assertThat(e1.size()).isGreaterThan(0);
        e1.stream().forEach(item->{
            System.out.println(item.get(userEmployees.eid)
                    +","+item.get(userEmployees.firstName)
                    +","+item.get(userEmployees.salary)
                    +","+item.get(userEmployees.hireDate));
        });

    }

    @Test
    public void divide(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> marketing = queryFactory
                .select(userEmployees.salary,userEmployees.salary.divide(5000).ceil().intValue())
                .from(userEmployees)
                .fetch();
        System.out.println(marketing.size());
        marketing.stream().forEach(item->{
            System.out.printf("%.1f, %d\n"
                    ,item.get(userEmployees.salary)
                    ,item.get(userEmployees.salary.divide(5000).ceil().intValue()));
        });
    }

    @Test
    public void divideExam(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // 2024년 입사자 사원번호, 이름, 급여, 입사일
        List<UserEmployees> emp2005 = queryFactory.selectFrom(userEmployees).where(userEmployees.hireDate.year().eq(2024)).fetch();
        emp2005.stream().forEach(i->{
            System.out.printf("%d, %s, %.1f, %s\n",i.getEid(),i.getFirstName(),i.getSalary(),i.getHireDate());
        });
        // 140 ~ 170 번 사원 중 사원번호 홀수인 사원의 사번, 이름, 입사일
        List<Tuple> oddlist = queryFactory
                .select(userEmployees.eid,userEmployees.firstName,userEmployees.hireDate)
                .from(userEmployees)
                .where(userEmployees.eid.between(140L,170L),userEmployees.eid.mod(2L).eq(1L))
                .fetch();
        System.out.println(oddlist.size());
        oddlist.stream().forEach(item->{
            System.out.printf("%d, %s, %s\n"
                    ,item.get(userEmployees.eid)
                    ,item.get(userEmployees.firstName)
                    ,item.get(userEmployees.hireDate));
        });
        // 이름의 뒤에서 2번째 글자가 r인 사원의 사번, 이름, 급여, 부서명
        List<Tuple> rs = queryFactory
                .select(userEmployees.eid, userEmployees.firstName, userEmployees.salary, userEmployees.empDept.dname)
                .from(userEmployees)
                .innerJoin(userEmployees.empDept)
                .on(userEmployees.firstName.like("%r_"))
                .fetch();
        rs.stream().forEach(i->{
            System.out.printf("%d, %s, %.1f, %s\n"
                    ,i.get(0,Long.class),i.get(1,String.class),i.get(2,Float.class),i.get(3,String.class));
        });
    }

    @Test
    public void caseWhenThen(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> marketing = queryFactory
                .select(userEmployees.salary
                        ,userEmployees.salary
                                .divide(5000).ceil().intValue()
                                .when(0).then("5000 미만")
                                .when(1).then("5000 이상 10000 미만")
                                .when(2).then("10000 이상 15000 미만")
                                .otherwise("15000 이상"))
                .from(userEmployees)
                .fetch();
        System.out.println(marketing.size());
        marketing.stream().forEach(item->{
            System.out.printf("%.1f, %s\n"
                    ,item.get(userEmployees.salary)
                    ,item.get(1,String.class));
        });
    }

    @Test
    public void caseWhenThen2(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> marketing = queryFactory
                .select(userEmployees.salary
                        ,new CaseBuilder()
                                .when(userEmployees.salary.goe(0).and(userEmployees.salary.lt(5000)))
                                .then("5000 미만")
                                .when(userEmployees.salary.goe(5000).and(userEmployees.salary.lt(10000)))
                                .then("5000 이상 10000 미만")
                                .otherwise("10000 이상"))
                .from(userEmployees)
                .fetch();
        System.out.println(marketing.size());
        marketing.stream().forEach(item->{
            System.out.printf("%.1f, %s\n"
                    ,item.get(userEmployees.salary)
                    ,item.get(1,String.class));
        });
    }
}
