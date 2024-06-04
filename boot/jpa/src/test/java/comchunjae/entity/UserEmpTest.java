package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class UserEmpTest {
    public static void main(String[] args) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("jpa1");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
////            UserEmp userEmp = new UserEmp();
////            userEmp.setFirstName("강인");
////            userEmp.setLastName("이");
////            userEmp.setEmail("lee@test.com");
////            userEmp.setHireDate(LocalDate.now());
////            userEmp.setSalary(BigDecimal.valueOf(5000.0));
////            userEmp.setPhoneNumber("010-1234-5679");
////            userEmp.setManager(em.find(UserEmp.class,2L));
////            UserDept dept = em.find(UserDept.class,1L);
////            userEmp.setUserDept(dept);
////            em.persist(userEmp);
//            // 조회
////            UserEmp e1 = em.find(UserEmp.class,1L);
////            System.out.println(e1.getFirstName()+e1.getUserDept().getDepartmentName());
////            UserJob j1 = new UserJob();
////            j1.setJobId("IT_PROG");
////            j1.setJobTitle("Programmer");
////            j1.setMinSalary(BigDecimal.valueOf(4000));
////            j1.setMaxSalary(BigDecimal.valueOf(10000));
////            em.persist(j1);
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            System.out.println(e);
//        }finally {
//            em.close();
//            emf.close();
//        }
    }
}
