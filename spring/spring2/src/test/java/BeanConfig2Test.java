import com.chunjae.config.BeanConfig;
import com.chunjae.config.BeanConfig2;
import com.chunjae.dto.MemberDTO;
import com.chunjae.dto.MemberList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BeanConfig2.class, BeanConfig.class}) // 이 어노테이션 안에는 문자열 혹은 클래스 배열이 들어가야 함.
public class BeanConfig2Test {
    @Autowired
    private MemberList memberList;
    @Test
    public void isNull(){
        assertNotNull(memberList);
    }
    @Test
    public void prtList(){
        for(MemberDTO dto: memberList.getList()){
            System.out.println(dto.getName()+","+dto.getAge());
        }
    }

    @Autowired
    @Qualifier("createMemberBean1") // @Autowired 는 byType 으로 가져오는데 MemberDTO 로 만들어진 빈이 2개기 때문에 이름으로 지정
    private MemberDTO memberDTO;
    @Test
    public void isNotNull(){
        assertNotNull(memberDTO);
    }
    @Test
    public void assertEquals(){
        Assertions.assertEquals(memberDTO.getAge(),20);
    }
}
