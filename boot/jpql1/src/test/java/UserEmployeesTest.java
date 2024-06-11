import com.chunjae.domain.UserEmployees;
import com.chunjae.dto.EmpDTO;
import jakarta.persistence.*;

import java.util.List;

class UserEmployeesTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // jpql 에서는 테이블 이름을 엔티티명으로 적고, select * 은 엔티티 별칭으로 적는다.
            // TypeQuery : 명시적 타입 지정 쿼리
            TypedQuery<UserEmployees> typedQuery = em.createQuery(
                    "select e from UserEmployees e", UserEmployees.class);
            List<UserEmployees> resultList = typedQuery.getResultList();
//            for(UserEmployees e:resultList){
//                System.out.println(e.getEid()+","+e.getFirstName());
//            }
            // 쿼리 결과는 dto 타입으로도 가져올 수 있다. 단 패키지명까지 포함해 생성자를 만들어야 하고, dto 에는 해당 컬럼 생성자들이 있어야함.
            List<EmpDTO> dtolist = em.createQuery(
                    "select new com.chunjae.dto.EmpDTO(e.firstName, e.salary) from UserEmployees e"
                    , EmpDTO.class).getResultList();
//            for(EmpDTO d:dtolist){
//                System.out.println(d.getFirstName()+", "+d.getSalary());
//            }
            // Query : 타입이 지정되지 않은 쿼리 (Object 로 받음)
            String sql = "select e.firstName, e.salary from UserEmployees e";
            Query q = em.createQuery(sql);
            List<Object[]> resultq = q.getResultList();
//            for(Object[] o:resultq){
//                System.out.println(o[0]+","+o[1]);
////                UserEmployees u = (UserEmployees) o; 엔티티와 컬럼이 맞지않기 때문에 에러
////                System.out.println(u.getFirstName()+u.getSalary());
//            }

            // getResultList()
            List<UserEmployees> eelist = em.createQuery("select e from UserEmployees e " +
                    "where e.firstName like '%ee%'",UserEmployees.class).getResultList();
//            for(UserEmployees e:eelist){
//                System.out.println(e.getFirstName());
//            }
            // getSingleResult() : 만약 결과가 2개 이상인 경우 에러남
            UserEmployees re = em.createQuery("select e from UserEmployees e " +
                    "where e.firstName like '%ee%'",UserEmployees.class).getSingleResult();
//            System.out.println(re.getFirstName());

            // parameter 추가  1) :를 붙이고 변수명  (변수명으로 쓰는 것을 추천)
            String sql2 = "select e from UserEmployees e where e.eid=:id";
                // 이렇게 setParameter, getResult 까지 한번에 체이닝 해도 되고
            UserEmployees lex = em.createQuery(sql2,UserEmployees.class)
                            .setParameter("id","102").getSingleResult();
            System.out.println(lex.getEid()+","+lex.getFirstName());
            // parameter 추가  2) ?를 붙이고 파라미터 idx
            String sql3 = "select e from UserEmployees e " +
                    "where e.salary >=?1 and e.firstName like ?2";
                // 이렇게 하나씩 나누어서 써도 된다.
            TypedQuery<UserEmployees> tq = em.createQuery(sql3,UserEmployees.class);
            tq.setParameter(1,5000);
            tq.setParameter(2,"%x%"); // '%x%' 로 적용된다.
            List<UserEmployees> tqlist = tq.getResultList();
            for(UserEmployees u:tqlist){
                System.out.println(u.getFirstName()+", "+u.getSalary());
            }

            // createNativeQuery() : 엔티티 사용을 권장하므로 쓰지 않는 것이 좋다.
            List nativeq = em.createNativeQuery(
                    "select * from user_employees where salary > 10000"
                    ,Object[].class).getResultList();
//            for(Object[] o : nativeq){
//                System.out.println(o[1]);
//                System.out.println(o[2]);
//            }
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