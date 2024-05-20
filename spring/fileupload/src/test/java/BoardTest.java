import com.chunjae.fileupload.dao.BoardMapper;
import com.chunjae.fileupload.dto.BoardDTO;
import com.chunjae.fileupload.dto.InfoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static  org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class BoardTest {
  private static Logger logger= LoggerFactory.getLogger(BoardTest.class);
    @Autowired
     private BoardMapper mapper;


    public void test(){

        HashMap<String, Object> o=new HashMap<>();
        InfoDTO dto=new InfoDTO();
        dto.setTitle("aaa");
        o.put("dto", dto);
        int result= mapper.insert(o);
         assertEquals(1, result);
         logger.info("......key out {}", o.get("id"));


    }

  @Transactional
   @Test
    public void test2(){
        HashMap<String, Object> o=new HashMap<>();
        InfoDTO dto=new InfoDTO();
        dto.setTitle("aaa");
        String[] filenames=new String[]{"/file1","/file2","/file3"};
        List<String> files= Arrays.asList(filenames);
        o.put("filenames",files);
        o.put("dto", dto);
        int result= mapper.insert(o);
        logger.info("o.get....{}",o.get("id"));
        logger.info("....filenames {}", filenames[0]);
        int result2=mapper.subinsert(o);
        assertEquals(3, result2);
    }

    @Test
    public void test3(){

           List<BoardDTO> list=  mapper.list();
           assertEquals("aaa",list.get(0).getInfotitle());
    }


}
