import com.chunjae.mvc_mybatis.service.EmpSearchServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class SearchEmpTest {
    @Autowired
    @Qualifier("empSearchService")
    private EmpSearchServiceImpl service;

    @Test
    public void t1(){
        Assertions.assertNotNull(service);
    }

    @Test
    public void t2(){
        int count = service.totalCount("employee_id","100");
        Assertions.assertEquals(1,count);
    }

    @Test
    public void t3(){
        int count = service.totalCount("first_name","a");
        Assertions.assertEquals(70,count);
    }

    @Test
    public void t4(){
        int count = service.totalCount("department_name", "a");
        Assertions.assertEquals(53,count);
    }
}
