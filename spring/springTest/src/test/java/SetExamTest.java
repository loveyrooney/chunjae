import com.chunjae.config.SetExam;
import com.chunjae.dto.MemberDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SetExam.class)
public class SetExamTest {
    @Autowired
    private Set<MemberDTO> membrSet;
    @Test
    public void t1(){
        Assertions.assertNotNull(membrSet);

    }
}
