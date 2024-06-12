import com.chunjae.domain.UserDepartments;
import com.chunjae.domain.UserEmployees;
import jakarta.persistence.*;

import java.util.List;

public class JoinTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // Natural join (식별 관계 조인)
            // select e.empDept.dname from UserEmployees 로 가져오지 말고 join 처리를 해 줄 것.
            // hibernate 5 버전 이하에서 inner join 시 2개씩 나오는 문제. distinct 넣어서 써줘야 함. 6버전부터 개선됨.
            String sql = "select e.firstName, d.dname from UserEmployees e inner join e.empDept d where e.eid >200";
            List<Object[]> joinlist = em.createQuery(sql,Object[].class).getResultList();
            for(Object[] o:joinlist){
                System.out.println(o[0]+", "+o[1]);
            }
            // employees + departments join
            String sql2 = "select e.eid, e.firstName, e.salary, d.dname from UserEmployees e left join e.empDept d where e.firstName like '%k%'";
            // left join 에서는 on e.firstName like '%k%' 를 적용하면 이 조건에 해당하지 않는 부서명은 모두 null 이 나온다. where 를 걸든지, inner join 이 되어야 함.
            List<Object[]> resultlist = em.createQuery(sql2,Object[].class).getResultList();
            for(Object[] o:resultlist){
                System.out.printf("%d, %s, %.1f, %s",o[0],o[1],o[2],o[3]);
                System.out.println();
            }
            // employees + departments + locations join
            String sql3 = "select e.eid, e.firstName, e.salary, d.dname, l.city " +
                    "from UserEmployees e inner join e.empDept d inner join d.deptLoc l on d.dname =:dname order by e.salary desc";
            // inner join 에서 where d.dname=:dname 을 하면 전체를 다 받아온 후 where 로 다시 필터링, on 으로 거는 경우 그 조건이 적용된 부분만 join 해서 속도 향상
            List<Object[]> resultlist2 = em.createQuery(sql3,Object[].class)
                    .setParameter("dname","Sales")
                    .setFirstResult(0)
                    .setMaxResults(5)
                    .getResultList();
            for(Object[] o:resultlist2){
                System.out.printf("%d, %s, %.1f, %s, %s",o[0],o[1],o[2],o[3],o[4]);
                System.out.println();
            }

            // Theta join (비 식별 관계 조인)
            String sql4 = "select e.firstName, d.dname from UserEmployees e inner join UserDepartments d on e.salary < d.did";
            List<Object[]> thetalist = em.createQuery(sql4,Object[].class).getResultList();
            for(Object[] o:thetalist){
                System.out.println(o[0]+","+o[1]);
            }

            // fetch join (lazy 로딩 시 쿼리문이 반복되며 생기는 n+1 문제에 대해, 쿼리를 한번에 동작하도록 해주는)
            String sql7 = "select d from UserDepartments d inner join fetch d.deptEmpsList e where d.dname = 'Marketing'";
            List<UserDepartments> deptemplist = em.createQuery(sql7, UserDepartments.class).getResultList();
            for(UserDepartments d : deptemplist){
                System.out.printf("%d, %s\n",d.getDid(),d.getDname());
                for(UserEmployees e : d.getDeptEmpsList()){
                    System.out.println(e.getFirstName());
                }
            }

            // aggregate function
            String sql5 = "select count(e.salary), max(e.salary), min(e.salary), sum(e.salary) from UserEmployees e";
            Object[] aggregate = em.createQuery(sql5,Object[].class).getSingleResult();
            System.out.printf("%d, %.1f, %.1f, %.1f",aggregate[0],aggregate[1],aggregate[2],aggregate[3]);

            // jpql 에서 Sub Query 는 select, where 절에만 사용할 수 있다. (from 절 불가)
            String sql6 = "select count(e) from UserEmployees e where e.salary > (select avg(e2.salary) from UserEmployees e2)";
            Long subresult = em.createQuery(sql6,Long.class).getSingleResult();
            System.out.println(subresult);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
        }finally {
            em.close();
            emf.close();
        }
    }
}
