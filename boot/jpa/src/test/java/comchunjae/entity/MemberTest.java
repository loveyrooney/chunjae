package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    public static void main(String[] args) {
//        EntityManagerFactory emf =
//        Persistence.createEntityManagerFactory("jpa1");
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction(); // 트랜잭션 없이 jpa 동작하지 않는다.
//        try{
//            tx.begin();
////            Member member = new Member();
////            member.setName("kim");
////            member.setAge(10);
////            member.setAddr("서울");
////            member.setWritedate(LocalDateTime.now());
////            Member member2 = new Member();
////            member2.setName("lee");
////            member2.setAge(12);
////            member2.setAddr("제주");
////            member2.setWritedate(LocalDateTime.now());
////            System.out.println("==============");
////            em.persist(member);
////            em.persist(member2);
////            System.out.println("===============");
//            Member m1 = em.find(Member.class,1L);
//            System.out.println(m1.getName());
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            System.out.println(e);
//        }finally {
//            em.clear();
//            em.close();
//        }
    }

}