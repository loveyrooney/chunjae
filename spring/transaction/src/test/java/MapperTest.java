import com.chunjae.transaction.dao.EmpMapper;
import com.chunjae.transaction.dto.EmpDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

// transactional 을 사용하면, test 에서 실행한 메서드가 db에 commit 된 후 다시 rollback 처리가 된다.
// 메서드의 동작은 확인하되, 데이터는 원상복구 시켜놓는 것
@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MapperTest {
    @Autowired
    private EmpMapper mapper;

    @Test
    public void t1(){
        Assertions.assertNotNull(mapper);
    }

    @Test
    public void select(){
        Assertions.assertNotNull(mapper.findEmp(101));
        Assertions.assertEquals(90,mapper.findEmp(101).getDepartment_id());
    }

    @Test
    public void insert(){
        EmpDTO dto = new EmpDTO();
        dto.setEmployee_id(2);
        dto.setLast_name("KIM");
        dto.setHire_date("2024-05-14");
        dto.setEmail("kim@test.com");
        dto.setDepartment_id(90);
        Assertions.assertEquals(1,mapper.insertEmp(dto));
    }
    // 트랜잭션 적용 후 실행하면 업데이트만 실패한다. insert 에서 추가된 내용이 실제 db에 없기 때문.
    @Test
    public void update(){
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("last_name","LEE");
        hm.put("email","lee@test.com");
        hm.put("employee_id",2);
        Assertions.assertEquals(1,mapper.updateEmp(hm));
    }

    @Test
    public void delete1(){
        Assertions.assertEquals(1,mapper.deleteEmp(1));
    }
}
