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
@ContextConfiguration("classpath:memberConfigIntegration.xml")
public class IntegrationXmlTest {
    @Autowired
    @Qualifier("memberlist")
    private MemberList memberList;

    @Autowired
    @Qualifier("mlist")
    private MemberList mlist;

    @Test
    public void t1(){
        Assertions.assertEquals("hong_xml",memberList.getMemberList().get(0).getName());

    }

    @Test
    public void t2(){
        Assertions.assertEquals("hong_annotation",mlist.getMemberList().get(0).getName());
    }
}
