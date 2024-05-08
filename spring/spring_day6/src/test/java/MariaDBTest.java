import com.chunjae.spring_day6.dao.EmpMapper;
import com.chunjae.spring_day6.dto.EmpDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MariaDBTest {

//    @Autowired
//    private HikariConfig config1;
//
//    @Test
//    public void t1(){
//        assertNotNull(config1);
//        assertEquals("root", config1.getUsername());
//    }

//    @Autowired
//    private DataSource ds;
//     @Test
//    public void test1(){
//          assertNotNull(ds);
//    }

    @Autowired
    private SqlSessionTemplate template;
     @Test
     public void test2(){
         assertNotNull(template);

     }
     @Test
     public void test3(){
        EmpMapper mapper= template.getMapper(EmpMapper.class);
        List<EmpDTO> list= mapper.boardlist();
        assertEquals(100, list.get(0).getEmployee_id());
        assertEquals("Steven",list.get(0).getFirst_name());

     }






}
