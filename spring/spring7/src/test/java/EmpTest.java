import com.chunjae.spring7.dao.EmpMapper;
import com.chunjae.spring7.dto.EmpDTO;
import com.chunjae.spring7.service.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class EmpTest {

    @Autowired
    private EmpMapper mapper;

    @Test
    public void mapperNotNull(){
        Assertions.assertNotNull(mapper);
    }
    @Autowired
    private EmpService empService;

    @Test
    public void serviceNotNull(){
        Assertions.assertNotNull(empService);
    }

    @Test
    public void findEmpListTest(){
        List<EmpDTO> list = empService.empList("hire_date","1999",0,10);
        Assertions.assertEquals("Diana",list.get(0).getFirst_name());
        for(EmpDTO d:list){
            System.out.println(d.getEmployee_id()+d.getFirst_name());
        }
    }

    @Test
    public void countEmpListTest(){
        Assertions.assertEquals(1,empService.countEmpList("employee_id","100"));
    }

    @Test
    public void findEmpTest(){
        Assertions.assertEquals(null,empService.detailEmp(0));
        System.out.println(empService.detailEmp(0));
        //Assertions.assertEquals("Steven",empService.detailEmp(100).getFirst_name());
    }
}
