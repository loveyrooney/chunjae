import com.chunjae.config.IntegrationConfig;
import com.chunjae.dto.MemberDTO;
import com.chunjae.dto.Members;
import com.chunjae.service.MemberList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = IntegrationConfig.class)
public class IntegrationConfigTest {
    @Autowired
    @Qualifier("memberlist")
    private MemberList memberList;

    @Autowired
    @Qualifier("mlist")
    private MemberList mlist;

    @Autowired
    @Qualifier("members")
    private Members members;

    @Test
    public void t1(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{
            System.out.println(memberList.getMemberList().get(2).getName());
        });
    }

    @Test
    public void t2(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{
            for(int i=0; i<=mlist.getMemberList().size(); i++){
                System.out.println(mlist.getMemberList().get(i).getName());
            }
        });
    }

    // NullPointer 가 나오는 경우 생각해 볼 것
    @Test
    public void t3(){
        Assertions.assertThrows(NullPointerException.class,()->{
            String result = "";
            if(members.getMembers().get(0).getAge()==40)
                result = null;
            System.out.println(result);
        });
    }
}
