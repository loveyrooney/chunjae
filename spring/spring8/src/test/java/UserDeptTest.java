
import com.chunjae.spring8.service.UserDeptService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserDeptTest {
    @Autowired
    private UserDeptService deptService;

    @Test
    public void list(){
        Assertions.assertEquals(27,deptService.findUserDeptList().size());
        Assertions.assertEquals("IT",deptService.findUserDeptList().get(5).getDepartment_name());
    }

    @Test
    public void detail(){
        Assertions.assertEquals("IT", deptService.findUserDept(60).getDepartment_name());
    }


}
