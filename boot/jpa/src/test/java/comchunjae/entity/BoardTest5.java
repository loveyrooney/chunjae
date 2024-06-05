package comchunjae.entity;

import comchunjae.entity.cascade.Board;
import comchunjae.entity.cascade.RepBoard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class BoardTest5 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();

            Board b1 = new Board();
            b1.setTitle("보드1");
            b1.setContent("보드1이야");
            b1.setWriter("김보드");
            em.persist(b1);  // 영속성 컨텍스트에 저장

            RepBoard r1 = new RepBoard();
            r1.setContent("댓글1이야");
            r1.setWriter("김댓글");
            r1.setBoard(b1);
            em.persist(r1);

            RepBoard r2 = new RepBoard();
            r2.setContent("댓글2야");
            r2.setWriter("이댓글");
            r2.setBoard(b1);
            em.persist(r2);

            // b1.getReplies().add(r1); 이 작업을 해주면 캐시에도 RepBoard 가 들어가는데.
            // 보드와 댓글을 모두 연결해 주는 편의 메서드를 사용하면 편하다.
            //b1.appendRep(r1); 을 해주면 r1.setBoard(b1); 과 b1.getReplies().add(r1); 을 한번에 할 수 있다.

            em.flush();  // 영속성 컨텍스트에 있는 내용들을 DB 쿼리로 작동

            System.out.println("==== before find =====");
            System.out.println("board: "+r1.getBoard().getTitle());  // 영속성 컨텍스트 캐시에서 가져옴
            List<RepBoard> repBoardList = b1.getReplies();
            for(RepBoard r:repBoardList){
                System.out.println("reply: "+r.getContent());   // List<RepBoard> 에 넣지 않았기 때문에 캐시에 없음
            }
            em.clear();
            System.out.println("===== after find ======");
            Board findb1 = em.find(Board.class,b1.getBoardId());   // DB에서 찾아서 가져옴, 이 때는 RepBoard 찾지 않음
            List<RepBoard> findrepBoardList = findb1.getReplies(); // 이 때 지연로딩으로 찾아서 가져옴
            for(RepBoard r:findrepBoardList){
                System.out.println("reply: "+r.getContent());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            System.out.println(e);
        }finally {
            em.close();
            emf.close();
        }
    }
}


// 실행 결과
//Hibernate:
//     /* insert for
//        com.chunjae.entity.Board */ insert   => b1 의 insert
//        into
//        board (content, createDate, modifyDate, readNo, title, writer)
//        values
//        (?, ?, ?, ?, ?, ?)
//        Hibernate:
//    /* insert for
//        com.chunjae.entity.RepBoard */insert  => r1 의 insert
//        into
//        reply (board_id, content, createDate, modifyDate, readNo, writer)
//        values
//        (?, ?, ?, ?, ?, ?)
//        Hibernate:
//    /* insert for
//        com.chunjae.entity.RepBoard */insert  => r2 의 insert
//        into
//        reply (board_id, content, createDate, modifyDate, readNo, writer)
//        values
//        (?, ?, ?, ?, ?, ?)

//        ==== before find =====
//        board: 보드1                 => 이 보드1의 자료는 영속성 컨텍스트 캐시에서 가져옴
//                                       댓글은 board 에 List<RepBoard> 에 넣지 않았기 때문에 캐시에 없음.

//        ===== after find ======
//        Hibernate:
//        select
//        b1_0.board_id,
//        b1_0.content,
//        b1_0.createDate,
//        b1_0.modifyDate,
//        b1_0.readNo,
//        b1_0.title,
//        b1_0.writer
//        from
//        board b1_0
//        where
//        b1_0.board_id=?
//        Hibernate:                  => 댓글을 조회해야 하는 시점에서 지연로딩으로 select 함.
//        select
//        r1_0.board_id,
//        r1_0.rep_id,
//        r1_0.content,
//        r1_0.createDate,
//        r1_0.modifyDate,
//        r1_0.readNo,
//        r1_0.writer
//        from
//        reply r1_0
//        where
//        r1_0.board_id=?
//        reply: 댓글1이야
//        reply: 댓글2야