import com.chunjae.mvc_mybatis.dao.EmpMapper;
import com.chunjae.mvc_mybatis.service.EmpServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class EmpTest {
    @Autowired
    private EmpServiceImpl service;

    @Test
    public void t1(){
        Assertions.assertNotNull(service.empList());
        Assertions.assertEquals(106,service.empList().size());
    }

    @Autowired
    private EmpMapper mapper;

    @Test
    public void t2(){
        Assertions.assertNotNull(mapper);
    }

}
