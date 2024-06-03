package comchunjae.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmpTest {
    public static void main(String[] args) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("jpa1");
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
////            Employees e1 = em.find(Employees.class,1L);
////            // 엔티티간 관계 설정을 하지 않고 기존 sql 방식으로 id 를 연결해 놓으면 다음과 같이 find 를 2번 해야 한다.
//////            Departments d1 = em.find(Departments.class,e1.getDepartment_id());
//////            System.out.println(e1.getFirst_name());
//////            System.out.println(d1.getDepartment_name());
////            // 엔티티간 관계 설정을 해 두면 find 할 때 해당 엔티티 기준 left join 으로 참조된 엔티티 객체를 가져올 수 있다.
////            System.out.println(e1.getFirst_name());
////            System.out.println(e1.getDepartments().getDepartment_name());
//
////            Departments d1 = new Departments();
////            d1.setDepartment_name("dept-3");
////            em.persist(d1);
////            System.out.println("===============");
////            Employees e2 = new Employees();
////            e2.setFirst_name("성용");
////            e2.setLast_name("기");
////            e2.setDepartments(d1);
////            em.persist(e2);
////            System.out.println("===============");
////            Employees e3 = new Employees();
////            e3.setFirst_name("규성");
////            e3.setLast_name("조");
////            e3.setDepartments(d1);
////            em.persist(e3);
//
//            Departments d2 = em.find(Departments.class,1L);
//            System.out.println("부서명: "+d2.getDepartment_name());
//            for(Employees e:d2.getEmployees()){
//                System.out.println("사원명: "+e.getFirst_name());
//            }
////            Departments d3 = em.find(Departments.class,4L);
////            d3.setDepartment_name("dept-4");
////            System.out.println(d3.getDepartment_name());
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
