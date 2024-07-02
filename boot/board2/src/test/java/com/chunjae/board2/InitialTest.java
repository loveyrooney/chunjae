package com.chunjae.board2;

import com.chunjae.board2.domain.MyBoard;
import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.dto.SubDTO;
import com.chunjae.board2.repository.BoardRepository;
import com.chunjae.board2.service.BoardService;
import static org.assertj.core.api.Assertions.*;

import com.chunjae.board2.service.SubService;
import jakarta.transaction.Transactional;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class InitialTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private SubService subService;

    private Logger logger = LoggerFactory.getLogger(InitialTest.class);

    @Test
    public void initrepo(){
        // given

        // when

        // then
        assertThat(boardService).isNotNull();
    }

    @Test
    public void findByTitle(){
        assertThat(boardService.findBoardList("k").size()).isGreaterThan(5);
        logger.info("result...{}",boardService.findBoardList("k").size());
    }

    @Test
    public void findData(){
        assertThat(boardService.findData("Steven").size()).isEqualTo(2);
        logger.info("result...{}",boardService.findData("Steven").size());
    }

    @Test
    public void modify(){
        assertThat(boardService.modify(100L)).isEqualTo(1);
        logger.info("result...{}",boardService.modify(100L));
    }

    @Test
    public void findById(){
        assertThat(boardService.detail(100L).getBoardId()).isEqualTo(100);
    }

    @Test
    public void save(){
        MyBoardDTO dto = new MyBoardDTO();
        dto.setTitle("hellooo");
        dto.setContent("hello");
        boardService.writeNew(dto);
        assertThat(boardService.findData("hellooo")).isNotNull();
        // getWriteDate() 는 null 이 나오는데 실행시 정상적으로 날짜 적용된다.. 이유뭘까
        logger.info("hellooo...{}",boardService.findData("hellooo").get(0).getBoardId());
    }

//    @Test
//    public void del(){
//        boardService.deleteData(100L);
//        logger.info("del...{}",boardService.findData("Steven").size());
//    }

    @Test
    public void detail(){
        assertThat(boardService.detail(100L).getTitle()).isEqualTo("Steven");
    }

//    @Test
//    public void insertSub(){
//        SubDTO dto = SubDTO.builder()
//                .content("hello")
//                .boardId(100L)
//                .build();
//        assertThat(subService.insertSub(dto)).isEqualTo(1L);
//    }
}
