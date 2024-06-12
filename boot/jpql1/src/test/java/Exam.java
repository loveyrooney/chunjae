import com.chunjae.domain.UserEmployees;
import com.chunjae.dto.EmpDTO;
import jakarta.persistence.*;

import java.util.List;

public class Exam {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            // 110번 사원
            EmpDTO john = em.createQuery(
                    "select new com.chunjae.dto.EmpDTO(e.eid,e.firstName,e.hireDate,e.salary) " +
                            "from UserEmployees e where e.eid=110",EmpDTO.class).getSingleResult();
            System.out.printf("%d, %s, %s, %.1f\n",john.getEid(),john.getFirstName(),john.getHireDate(),john.getSalary());

            // d로 시작하는 사원번호, 이름, 급여, 입사일, 부서명
            List<Object[]> dlist = em.createQuery(
                    "select e.eid, e.firstName, e.salary, d.dname " +
                            "from UserEmployees e join e.empDept d on e.firstName like :name",Object[].class)
                    .setParameter("name","d%")
                    .getResultList();
            for(Object[] o:dlist){
                System.out.printf("%d, %s, %.1f, %s\n",o[0],o[1],o[2],o[3]);
            }

            // 10000 이상 급여자의 사원번호, 이름, 부서명
            List<Object[]> highsallist = em.createQuery(
                    "select e.eid, e.firstName, d.dname, e.salary " +
                            "from UserEmployees e join e.empDept d on e.salary >= :sal",Object[].class)
                    .setParameter("sal",10000)
                    .getResultList();
            for(Object[] o:highsallist){
                System.out.printf("%d, %s, %s, %.1f\n",o[0],o[1],o[2],o[3]);
            }

            // Marketing 근무 사원의 사원번호, 급여
            List<Object[]> marketinglist = em.createQuery(
                    "select e.eid, e.salary, d.dname " +
                            "from UserEmployees e join e.empDept d on d.dname = :dname",Object[].class)
                    .setParameter("dname","Marketing")
                    .getResultList();
            for(Object[] o:marketinglist){
                System.out.printf("%d, %.1f, %s\n",o[0],o[1],o[2]);
            }

            // Marketing 부서의 도시, 주소, 우편번호
            TypedQuery<Object[]> merketingloc = em.createQuery(
                    "select d.dname, l.city, l.streetAddr, l.postalCode " +
                            "from UserDepartments d join d.deptLoc l on d.dname = :dname", Object[].class)
                    .setParameter("dname", "Marketing");
            Object[] mloc = merketingloc.getSingleResult();
            System.out.printf("%s, %s, %s, %s\n",mloc[0],mloc[1],mloc[2],mloc[3]);

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
