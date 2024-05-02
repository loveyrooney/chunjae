import com.chunjae.dto.MemberDTO;
import com.chunjae.life.LifeCycleDoing;
import com.chunjae.life.LifeCycleDoing2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeDoingMain {
    public static void main(String[] args) {
        /* spring 생명주기 절차
        1. 생성자나 팩토리메서드를 이용해 bean instance 생성
        2. bean property 에 값과 bean reference 설정
        3. 초기화 메서드 호출
        4. 빈 사용 준비
        5. 사용
        6. 컨테이너 종료시 소멸 메서드 호출

         초기화 메서드 : 빈 객체가 생성되고 DI 마친 후 실행되는 메서드
         initializingBean : 인터페이스. afterPropertiesSet() 메서드 상속
         xml에 init-method 지정
         @PostConstructor
         @Bean(initMethod)

         소멸 메서드 : 컨테이너가 종료될 때 호출, 빈이 사용한 리소스 반환하거나 종료 전 처리할 작업 수행
         DisposableBean : 인터페이스. destroy() 메서드 상속
         xml에 destroy-method 지정
         @PreDestroy
         @Bean(destroyMethod)
         */
        String path = "classpath:life.xml";
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
        MemberDTO dto = ctx.getBean("dto",MemberDTO.class);
        System.out.printf("%s, %d\n",dto.getName(),dto.getAge());

        LifeCycleDoing life = ctx.getBean("life",LifeCycleDoing.class);
        life.prt();
        //ctx.close(); // close 하지 않으면 아직 컨테이너가 종료되지 않은 것

        LifeCycleDoing2 life2 = ctx.getBean("life2",LifeCycleDoing2.class);
        life2.prt();
        life2.view();
        ctx.close();

    }
}
