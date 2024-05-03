import com.chunjae.dao.TempDAO;
import com.chunjae.dto.TempDTO;
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
public class TempTest {
    @Autowired
    private SqlSessionTemplate sqlSession;
    TempDAO dao;
    @Test
    public void t1(){
        Assertions.assertNotNull(sqlSession);
    }

    @BeforeEach
    public void b1(){
        dao = sqlSession.getMapper(TempDAO.class);
    }

    @Test
    public void t2(){
        List<TempDTO> templist = dao.findTemps();
        Assertions.assertEquals(100,templist.get(0).getEid());
        for(int i=0; i<5; i++){
            System.out.println(templist.get(i).getEid());
        }
    }
}
