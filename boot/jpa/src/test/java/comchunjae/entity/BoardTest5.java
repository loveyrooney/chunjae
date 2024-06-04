package comchunjae.entity;

import comchunjae.entity.cascade.Board;
import comchunjae.entity.cascade.BoardBase;
import comchunjae.entity.cascade.RepBoard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class BoardTest5 {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Board b1 = new Board();
            b1.setTitle("hello,board3");
            b1.setContent("보드3이야");
            b1.setWriter("이보드");
            b1.setWriteDate(LocalDateTime.now());

            RepBoard r1 = new RepBoard();
            r1.setContent("댓글1이야");
            r1.setWriter("박댓글");
            r1.setWriteDate(LocalDateTime.now());
            //r1.setBoard(b1);

            RepBoard r2 = new RepBoard();
            r2.setContent("댓글2야");
            r2.setWriter("최댓글");
            r2.setWriteDate(LocalDateTime.now());
            //r2.setBoard(b1);

            b1.addChild(r1);
            b1.addChild(r2);

            // cascade 하지 않으면 각각을 persist 해 주어야 insert 가 일어난다.
            em.persist(b1);
//            em.persist(r1);
//            em.persist(r2);
            // cascade 하면 보드만 삭제해도 딸린 댓글이 모두 삭제가 일어난다.
//            Board b = em.find(Board.class,1L);
//            em.remove(b);
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
