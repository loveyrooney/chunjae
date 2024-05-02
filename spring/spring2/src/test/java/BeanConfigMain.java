import com.chunjae.config.BeanConfig;
import com.chunjae.config.BeanConfig2;
import com.chunjae.dto.MemberDTO;
import com.chunjae.dto.MemberList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BeanConfigMain {
    public static void main(String[] args) {
        // annotation 으로 등록한 빈을 가져오기 위한 컨텍스트
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        MemberDTO dto = ctx.getBean("createMemberBean1", MemberDTO.class);
        MemberDTO dto2 = ctx.getBean("createMemberBean1", MemberDTO.class);
        MemberDTO dto3 = ctx.getBean("createMemberBean2", MemberDTO.class);
        List<String> list = ctx.getBean("list", List.class);
        System.out.println(dto==dto2); // singleton
        System.out.println(dto3.getName()+","+dto3.getAge());
        for(String s:list){
            System.out.print(s+" ");
        }

        System.out.println();
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfig2.class);
        MemberList memberList = ctx2.getBean("ins", MemberList.class);
        List<MemberDTO> list2 = memberList.getList();
        for(MemberDTO d:list2){
            System.out.println(d.getName()+", "+d.getAge());
        }

    }
}
