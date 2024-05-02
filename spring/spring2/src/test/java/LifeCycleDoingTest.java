import com.chunjae.config.LifeConfig;
import com.chunjae.dto.MemberDTO;
import com.chunjae.life.LifeCycleDoing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:life.xml")
@ContextConfiguration(classes = {LifeConfig.class, MemberDTO.class})
public class LifeCycleDoingTest {
    @Autowired // xml 에서 MemberDTO 타입의 빈을 찾는다. byType 으로 연결.
    private MemberDTO dto;
    @Test
    public void t1(){
        Assertions.assertNotNull(dto);
    }
    @Test
    public void t2(){
        Assertions.assertEquals("hong",dto.getName());
        System.out.println(dto.getName());
    }
    @Test
    public void t3(){
        Assertions.assertEquals(10,dto.getAge());
        System.out.println(dto.getAge());
    }

    @Autowired
    private LifeCycleDoing life1;
    @Test
    public void d1(){
        System.out.println("life doing start");
        Assertions.assertNotNull(life1);
        // 테스트 메서드의 경우는 이 메서드 안에서 컨테이너의 실행과 마침이 끝난다.
    }


}
