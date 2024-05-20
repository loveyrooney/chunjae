import com.chunjae.fileupload.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")

public class BoardServiceTest {

    @Autowired
   private BoardService service;

    @Transactional
    @Test
    public void test(){



    }

}
