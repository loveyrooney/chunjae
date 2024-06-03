package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

// detach, merge
public class BoardTest4 {
    public static void main(String[] args) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("jpa1");
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
//            Board b = em.find(Board.class,6L);
//            System.out.println("====================");
//            System.out.println(b.getTitle());
//            System.out.println("====================");
//            em.detach(b);
//            System.out.println("===================");
//            b.setTitle("hello"); // detach 만 하면 동작하지 않는다.
//            em.merge(b); // 여기까지 변경된 것이 다시 반영가능해 진다.
//            System.out.println("===================");
//            b.setTitle("hello2"); // merge 이후의 내용은 반영되지 않는다.
//            tx.commit(); // detach 만 하면 update 문이 동작하지 않는다, merge 하는 경우 merge 전까지의 변경내용이 반영되어 update 문 동작한다.
//        }catch (Exception e){
//            tx.rollback();
//            System.out.println(e);
//        }finally {
//            em.close();
//            emf.close();
//        }
    }
}
