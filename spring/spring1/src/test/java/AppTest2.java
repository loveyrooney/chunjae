import com.chunjae.cast.Person;
import com.chunjae.list.MemberDTO;
import com.chunjae.list.Members;
import com.chunjae.list.Student;
import com.chunjae.cast.T1;
import com.chunjae.map.Member;
import com.chunjae.set.SetPerson;
import com.chunjae.set.SetString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class AppTest2 {
    public static void main(String[] args) {
        String path = "classpath:app2.xml";
        ApplicationContext ctx = new GenericXmlApplicationContext(path);

        // xml 축약 라이브러리 활용
        Student s1 = ctx.getBean("s1",Student.class);
        s1.prt_student();

        // List<String>, List<Member> 타입의 인스턴스 변수를 가지는 Members class
        System.out.println("-----ms1.setData1(new ArrayList<String>()) -----");
        Members ms1 = ctx.getBean("ms1",Members.class);
        List<String> list1 = ms1.getData1();
        for(String s:list1){
            System.out.println(s);
        }
        System.out.println("----- ms1.setData2(ArrayList<MemberDTO>())-----");
        for(MemberDTO dto :ms1.getData2()){
            System.out.println(dto.getName()+", "+dto.getAge());
        }

        // interface 타입의 인스턴스 변수를 가지는 T1 class : xml 에서 interface를 상속한 구현체 클래스를 주입해 주어야 한다.
        System.out.println("-------- T1(new Man()) ---------");
        T1 t1 = ctx.getBean("t1", T1.class);
        t1.doing();


        String path2 = "classpath:Sample1.xml";
        ApplicationContext ctx2 = new GenericXmlApplicationContext(path2);

        // Map<String,Category> 타입의 인스턴스 변수를 가지는 Member class
        System.out.println("----- Member(new HashMap<String,Category>()) ------");
        Member member = ctx2.getBean("member",Member.class);
        member.prt();

        // Set<String> 타입의 인스턴스 변수를 가지는 SetString class
        System.out.println("----- SetString(new HashSet<String>()) ------");
        SetString set1 = ctx2.getBean("set1", SetString.class);
        for(String s: set1.getStrings()){
            System.out.printf(s+", ");
        }
//        Iterator<String> ito = set1.getStrings().iterator();
//        while(ito.hasNext()){
//            System.out.println(ito.next());
//        }
        System.out.println();
        System.out.println("----- set2 = new SetString(); set2.SetStrings(new HashSet<String>()) ------");
        SetString set2 = ctx2.getBean("set2", SetString.class);
        for(String s: set2.getStrings()){
            System.out.printf(s+", ");
        }
        System.out.println();

        // Set<Person> 타입의 인스턴스 변수를 가지는 SetPerson class
        System.out.println("---- set3 = new SetPerson(); set3.SetPersons(new HashSet<Person>()) ----");
        SetPerson set3 = ctx2.getBean("set3",SetPerson.class);
        for(Person p : set3.getPersonSet()){
            p.act();
        }
        // Set<MemberDTO> 타입의 인스턴스 변수를 가지는 SetPerson class
        System.out.println("---- set4 = new SetPerson(new HashSet<MemberDTO>()); ----");
        SetPerson set4 = ctx2.getBean("set4",SetPerson.class);
        for(MemberDTO dto : set4.getMemberDTOSet()){
            System.out.println(dto.getName()+", "+dto.getAge());
        }
    }
}
