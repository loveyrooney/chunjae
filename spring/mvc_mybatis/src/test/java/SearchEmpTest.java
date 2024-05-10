import com.chunjae.mvc_mybatis.dto.EmpDTO;
import com.chunjae.mvc_mybatis.service.EmpSearchServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


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

    @Test
    public void t5(){
        List<EmpDTO> list = service.searchEmpList("employee_id","100",0,10);
        Assertions.assertEquals("Steven",list.get(0).getFirst_name());
    }

    @Test
    public void t6(){
        List<EmpDTO> list = service.searchEmpList("first_name","a",0,10);
        Assertions.assertEquals("Pat",list.get(1).getFirst_name());
        for(EmpDTO dto:list){
            System.out.println(dto.getFirst_name());
        }
    }

    @Test
    public void t7(){
        List<EmpDTO> list = service.searchEmpList("department_name","z",0,10);
        Assertions.assertNotNull(list);
        // 검색 결과가 없는 경우 빈 리스트가 반환된다. 리스트 객체는 있으나 길이가 0이다. 
        System.out.println(list);
        Assertions.assertEquals(0,list.size());
    }
}
