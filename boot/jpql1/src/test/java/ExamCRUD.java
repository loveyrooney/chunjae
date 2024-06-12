import com.chunjae.domain.UserEmployees;
import com.chunjae.dto.EmpDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

public class ExamCRUD {
    @Transactional
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // insert
            UserEmployees u = UserEmployees.builder()
                                            .firstName("홍길동")
                                            .hireDate(LocalDate.now())
                                            .salary(500F)
                                            .build();
            em.persist(u);
            // update
            UserEmployees emp100 = em.find(UserEmployees.class,100L);
            emp100.setHireDate(LocalDate.now());
            /* 만약 createQuery("update UserEmployees e set e.hireDate = :moddate").executeUpdate()
               이렇게 적용하게 되면, 직접적으로 DB만 변경하고 영속성 캐시는 변화가 없어져서 싱크 안맞게 되므로
               위와 같이 쓰려고 하면 em.clear()를 꼭 해 주어야 한다.
            */
            em.flush();
            // delete
            UserEmployees emp101 = em.find(UserEmployees.class,101L);
            em.remove(emp101);
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
