package com.chunjae.querydsl1;

import static com.chunjae.querydsl1.domain.QUserEmployees.*;
import static com.chunjae.querydsl1.domain.QUserDepartments.*;

import com.chunjae.querydsl1.domain.QUserEmployees;
import com.chunjae.querydsl1.domain.UserDepartments;
import com.chunjae.querydsl1.domain.UserEmployees;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static org.assertj.core.api.Assertions.*;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class QueryDSLTest2 {
    @PersistenceContext
    private EntityManager em;
    private Logger logger = LoggerFactory.getLogger(QueryDSLTest2.class);

    @Test
    public void before(){
        assertThat(em).isNotNull();
    }

    @Test
    public void innerJoin(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> marketing = queryFactory
                .select(userEmployees.eid, userEmployees.firstName, userEmployees.hireDate, userDepartments.dname)
                .from(userEmployees)
                .innerJoin(userEmployees.empDept,userDepartments) // ? 여기에 userDepartments 안써도 동작한다.
                .on(userEmployees.empDept.dname.eq("IT"))
                .fetch();
        marketing.stream().forEach(item->{
            System.out.printf("%d, %s, %s, %s\n"
                    ,item.get(userEmployees.eid)
                    ,item.get(userEmployees.firstName)
                    ,item.get(userEmployees.hireDate)
                    ,item.get(userDepartments.dname));
        });
    }

    @Test
    public void outerJoin(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Tuple> marketing = queryFactory
                .select(userEmployees.eid, userEmployees.firstName, userEmployees.hireDate, userDepartments.dname)
                .from(userEmployees)
                .leftJoin(userEmployees.empDept,userDepartments)
                .where(userEmployees.firstName.like("%k%"))
                .fetch();
        System.out.println(marketing.size());
        marketing.stream().forEach(item->{
            System.out.printf("%d, %s, %s, %s\n"
                    ,item.get(userEmployees.eid)
                    ,item.get(userEmployees.firstName)
                    ,item.get(userEmployees.hireDate)
                    ,item.get(userDepartments.dname));
        });
    }

    @Test
    public void joinExam(){
        // Marketing 부서 사원들 급여 평균, 부서명
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        Tuple marketing = queryFactory
                .select(userEmployees.salary.avg(),userEmployees.empDept.dname)
                .from(userEmployees)
                .innerJoin(userEmployees.empDept)
                .on(userEmployees.empDept.dname.eq("Marketing"))
                .fetchOne();
        System.out.println(marketing.size());
        System.out.printf("%.1f, %s\n",marketing.get(userEmployees.salary.avg()),marketing.get(userEmployees.empDept.dname));

        // 부서명, 부서별 평균 급여
        List<Tuple> depts = queryFactory
                .select(userEmployees.empDept.dname, userEmployees.salary.avg())
                .from(userEmployees)
                .leftJoin(userEmployees.empDept)
                .groupBy(userEmployees.empDept.dname)
                .fetch();
        System.out.println(depts.size());
        depts.stream().forEach(item->{
            System.out.printf("%s, %.1f\n"
                    ,item.get(userEmployees.empDept.dname)
                    ,item.get(userEmployees.salary.avg()));
        });
    }

    @Test
    public void thetaJoin(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // cross join 방식
        List<Tuple> marketing = queryFactory
                .select(userEmployees.eid, userEmployees.firstName, userEmployees.hireDate, userDepartments.dname)
                .from(userEmployees,userDepartments)
                .where(userEmployees.firstName.eq(userDepartments.dname))
                .fetch();
        // inner join 방식
        List<Tuple> marketing2 = queryFactory
                .select(userEmployees.eid, userEmployees.firstName, userEmployees.hireDate, userDepartments.dname)
                .from(userEmployees)
                .leftJoin(userDepartments)
                .on(userEmployees.firstName.eq(userDepartments.dname))
                .fetch();
        System.out.println(marketing.size());
        System.out.println(marketing2.size());

    }

    @Test
    @Transactional
    public void fetchJoin(){
        // jpql
        String sql = "select d from UserDepartments d inner join fetch UserEmployees e on d.did = e.empDept.did";
        List<UserDepartments> list = em.createQuery(sql,UserDepartments.class).getResultList();
        System.out.println(list.size());
        for(UserDepartments d:list){
            //System.out.println(d.getDname());
            for(UserEmployees e:d.getDeptEmpsList()){
                System.out.println(d.getDname()+","+e.getFirstName());
            }
        }
        // queryDSL
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<UserEmployees> marketing = queryFactory
                .select(userEmployees)
                .from(userEmployees)
                .innerJoin(userEmployees.empDept)
                .fetchJoin()
                .fetch();
        System.out.println(marketing.size());
        marketing.stream().forEach(item->{
            System.out.printf("%d, %s, %s\n",item.getEid(),item.getFirstName(),item.getEmpDept().getDname());
        });
    }

    @Test
    @Transactional
    public void subQuery(){
        // jpql
//        String sql6 = "select count(e) from UserEmployees e where e.salary > (select avg(e2.salary) from UserEmployees e2)";
//        Long subresult = em.createQuery(sql6,Long.class).getSingleResult();
//        System.out.println(subresult);
        // queryDSL
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QUserEmployees emp = new QUserEmployees("emp");
        List<Long> salAvg = queryFactory
                .select(userEmployees.count())
                .from(userEmployees)
                .where(userEmployees.salary.gt(JPAExpressions.select(emp.salary.avg()).from(emp)))
                .fetch();
        System.out.println(salAvg.size());
        salAvg.stream().forEach(item->{
            System.out.println(item);
        });

    }

    @Test
    @Transactional
    public void subQueryExam(){
        // 부서명에 s 가 포함된 사원 정보
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // inner join 방법
        List<UserEmployees> salAvg = queryFactory
                .select(userEmployees)
                .from(userEmployees)
                .innerJoin(userEmployees.empDept)
                .where(userEmployees.empDept.dname.like("%s%"))
                .fetchJoin()
                .fetch();
        System.out.println(salAvg.size());
        for(UserEmployees u:salAvg){
            System.out.println(u.getFirstName()+","+u.getEmpDept().getDname());
        }
        // sub query 방법
        List<UserEmployees> subs = queryFactory.select(userEmployees)
                .from(userEmployees)
                .where(userEmployees.empDept.did
                        .in(JPAExpressions
                                .select(userDepartments.did)
                                .from(userDepartments)
                                .where(userDepartments.dname.like("%s%"))))
                .fetch();
        System.out.println(subs.size());
        subs.stream().forEach(i->{
            System.out.printf("%s, %s\n",i.getFirstName(),i.getEmpDept().getDname());
        });
    }




}
