import com.chunjae.beans1.Component1;
import com.chunjae.beans2.Component2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:component.xml")
public class ComponentTest {
    @Autowired
    private Component1 com1;
    @Autowired
    private Component2 com2;
    @Test
    public void t1(){
        Assertions.assertNotNull(com1);
        Assertions.assertNotNull(com2);
    }
    @Test
    public void t2(){
        com1.prt();
    }
    @Test
    public void t3(){
        com2.view();
    }

}
