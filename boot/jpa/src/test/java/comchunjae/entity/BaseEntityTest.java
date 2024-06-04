package comchunjae.entity;

import comchunjae.entity.baseEntity.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BaseEntityTest {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa1");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();

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
