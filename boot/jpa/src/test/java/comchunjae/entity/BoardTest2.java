package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

// flush, clear
public class BoardTest2 {
    public static void main(String[] args) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("jpa1");
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
//            Board b1 = em.find(Board.class,6L);
//            b1.setTitle("data5");
//            em.flush(); // 여기에 flush 를 쓰면 여기서 바로 update 문을 던진다. 그렇지 않으면 commit 할 때 update 가 던져진다.
//            em.clear(); // 여기에 clear 를 쓰면 캐시 정보를 지운다.
//            System.out.println("==============");
//            Board findb1 = em.find(Board.class,6L);
//            System.out.println(b1.getTitle()); // 이 정보는 이미 캐시에 저장이 되어 있으므로 select 하지 않는다. clear 를 한 경우 캐시에 내용이 없으므로 select 를 동작한다.
//            tx.commit(); // 중간에 flush 가 없으면 여기서 최종적으로 update 를 한다.
//        }catch (Exception e){
//            tx.rollback();
//            System.out.println(e);
//        }finally {
//            em.close();
//            emf.close();
//        }
    }
}
