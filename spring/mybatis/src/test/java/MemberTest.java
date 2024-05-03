import com.chunjae.dao.MemberDAO;
import com.chunjae.dto.MemberDTO;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc_dbcp.xml")
public class MemberTest {
    @Autowired
    private HikariDataSource hikariDataSource;
    MemberDAO dao;
    @Test
    public void t1(){
        Assertions.assertNotNull(hikariDataSource);
        Assertions.assertEquals("root",hikariDataSource.getUsername());
    }

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Test
    public void t2(){
        Assertions.assertNotNull(sqlSessionTemplate);
    }
    @BeforeEach
    public void before(){
        dao = sqlSessionTemplate.getMapper(MemberDAO.class);
    }
    @Test
    public void t3(){
        List<MemberDTO> members = dao.findMembers();
        Assertions.assertEquals(2,members.size());
        for(MemberDTO d:members){
            System.out.println(d);
        }
    }

    @Test
    public void t4(){
        MemberDTO dto = dao.findMember(2);
        Assertions.assertNotNull(dto);
        System.out.println(dto.getName());
        Assertions.assertEquals("박지성",dto.getName());
    }

    @Test
    public void t5(){
        int result = dao.deleteMember(5);
        Assertions.assertEquals(0,result);
//        Assertions.assertThrows(SQLException.class,()->{
//            dao.deleteMember(5);
//        });
    }

    @Test
    public void t6(){
        int result = dao.insertMember(new MemberDTO("기성용",36,"서울"));
        Assertions.assertEquals(1,result);
    }
    @Test
    public void t7(){
        List<MemberDTO> result = dao.findMembersContainsName("%손%");
        Assertions.assertEquals(1,result.size());
        for(MemberDTO dto:result){
            System.out.println(dto.getAddr());
        }
    }

    @Test
    public void t8(){
        int result = dao.deleteMemberWithName("기성용");
        Assertions.assertEquals(1,result);
    }

    @Test
    public void t9(){
        MemberDTO dto = dao.findMember(2);
        dto.setAge(45);
        int result = dao.updateMember(dto);
        Assertions.assertEquals(1,result);
    }

}
