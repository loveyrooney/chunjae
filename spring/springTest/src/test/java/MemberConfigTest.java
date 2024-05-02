import com.chunjae.config.MemberConfig;
import com.chunjae.dto.MemberDTO;
import com.chunjae.service.MemberList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MemberConfig.class})
public class MemberConfigTest {
    @Autowired
    @Qualifier("mlist")
    private MemberList memberList;

    @Test
    public void t1(){
        for(MemberDTO d:memberList.getMemberList()){
            Assertions.assertNotNull(d);
            System.out.println(d.getName()+","+d.getAge());
        }
    }
}
