import com.chunjae.dto.MemberMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:mapExam.xml")
public class mapExamTest {
    @Autowired
    private MemberMap memberMap;
    @Test
    public void t1(){
        Assertions.assertEquals(memberMap.getMemberMap().get("네트워크").getName(),"lee");
    }
    @Test
    public void t2(){
        Assertions.assertThrows(NullPointerException.class,()->{
            System.out.println(memberMap.getMemberMap().get("알고리즘").getName());
        });
    }
}
