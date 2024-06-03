package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

// insert, select
public class BoardTest {
    public static void main(String[] args) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("jpa1");
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
////            Board b1 = new Board();
////            b1.setTitle("title1");
////            b1.setContent("안녕하세요");
////            b1.setWriter("hong");
////            b1.setWritedate(LocalDateTime.now());
////            Board b2 = new Board("title2","안녕히가세요","lee");
////            em.persist(b1);
////            System.out.println("=============");
////            em.flush();
////            em.persist(b2);
////            System.out.println("=============");
//            Board b2 = new Board();
//            b2.setContent("content1");
//            b2.setTitle("title1");
//            em.persist(b2);
//            System.out.println("==============");
//            Board b3 = em.find(Board.class,1L);
//            System.out.println(b3.getBid());
//            System.out.println(b3.getTitle());
//            System.out.println(b3.getContent());
//            System.out.println("=================");
//            Board b4 = em.find(Board.class,6L); // b2를 찾아오는 것, db select 를 하지 않고 영속성 컨텍스트 캐시에서 찾는다.
//            System.out.println(b4.getContent()); // content1
//            System.out.println("=================");
//            b4.setContent("update content2");  // b4를 수정하는 것은 곧 b2의 현재 객체 상태 수정.
//            tx.commit(); // 여기에서 b2의 엔티티 상태와 db 상태를 비교해 맞지않으면 b2 엔티티 상태로 업데이트
//        }catch (Exception e){
//            tx.rollback();
//            System.out.println(e);
//        }finally {
//            em.close();
//            emf.close();
//        }
    }
}
