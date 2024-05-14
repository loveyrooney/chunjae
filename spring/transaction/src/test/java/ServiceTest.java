import com.chunjae.transaction.service.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class ServiceTest {
    @Autowired
    private EmpService empService;

    @Test
    public void t1(){
        Assertions.assertNotNull(empService);
    }

    @Test
    public void doing(){
        empService.doing();
    }

}
