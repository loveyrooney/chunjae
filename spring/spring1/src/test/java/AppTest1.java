import com.chunjae.list.MemberDTO;
import com.chunjae.list.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppTest1 {
    public static void main(String[] args) {
        String path = "classpath:app1.xml";  // classpath 경로는 resources 부터 시작.
        ApplicationContext ctx = new GenericXmlApplicationContext(path);

        // 기본생성자로 만들기 MemberDTO plain = new MemberDTO();
        MemberDTO d1 = ctx.getBean("plain", MemberDTO.class); // MemberDTO d1 = (MemberDTO) ctx.getBean("plain"); 와 같은 표현
        MemberDTO d2 = ctx.getBean("plain2",MemberDTO.class);
        MemberDTO d3 = ctx.getBean("plain",MemberDTO.class);
        System.out.println(d1==d2);
        System.out.println(d1==d3); // 같은 이름의 빈은 싱글턴 객체를 가져온다.

        // primitive 매개변수 생성자로 만들기 MemberDTO ins = new MemberDTO("hong",10); (생성자 주입)
        MemberDTO ins = ctx.getBean("ins",MemberDTO.class);
        System.out.println(ins.getName()+", "+ins.getAge());

        // 기본 생성자로 만든 후 setter로 내용 넣기 (세터 주입)
        MemberDTO ins2 = ctx.getBean("ins2",MemberDTO.class);
        System.out.println(ins2.getName()+", "+ins2.getAge());


        // reference 매개변수 생성자로 만들기
        // 변수를 만들어서 넣기 Jumsu jumsu1 = new Jumsu(80,60,90); Student student = new Student("lee",23,jumsu1);
        Student student1 = ctx.getBean("student1",Student.class);
        student1.prt_student();

        // 아예 매개변수 안에서 선언하기
        // Student student = new Student("lee",25,new Jumsu(90,80,70));
        Student student2 = ctx.getBean("student2",Student.class);
        student2.prt_student();

        // Student student3 = new Student(new ArrayList<String>("a1","a2","a3"));
        Student student3 = ctx.getBean("student3",Student.class);
        student3.prt_studentList();

    }
}
