import com.chunjae.spring8.service.TempService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class TempTest {
    @Autowired
    private TempService service;

    @Test
    public void templist(){
        Assertions.assertEquals(2, service.findTempList(90).size());
    }

    @Transactional
    @Test
    public void insertTemp(){
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("first_name","PARK");
        hm.put("salary",8000);
        hm.put("department_id",90);
        Assertions.assertEquals(1,service.insertTemp(hm));
    }
}
