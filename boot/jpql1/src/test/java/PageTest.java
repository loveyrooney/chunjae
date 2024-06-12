import com.chunjae.dto.EmpDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class PageTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // limit 를 처리하는 방법
            String sql = "select e.salary" +
                    ", case when e.salary/1000<3 then '3000 미만' " +
                    "       when e.salary/1000<4 then '3000 이상 4000 미만' " +
                    "      else '그 외' "+
                    "  end "+
                    "from UserEmployees e";
            List<Object[]> list = em.createQuery(sql,Object[].class)
                    .setFirstResult(10)  // limit 10,10 과 같은 역할. 쿼리문에 들어가지 않고 메서드 처리한다.
                    .setMaxResults(10)
                    .getResultList();
            for(Object[] o:list){
                System.out.println(o[0]+","+o[1]);
            }

            
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
