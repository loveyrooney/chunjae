package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserEmpTest {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
//            UserEmp userEmp = new UserEmp();
//            userEmp.setFirstName("흥민");
//            userEmp.setLastName("손");
//            userEmp.setEmail("son@test.com");
//            userEmp.setHireDate(LocalDate.now());
//            userEmp.setSalary(8000);
//            userEmp.setPhoneNumber("010-1234-5678");
//            em.persist(userEmp);
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
