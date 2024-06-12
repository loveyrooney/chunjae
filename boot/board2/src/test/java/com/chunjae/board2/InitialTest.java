package com.chunjae.board2;

import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.repository.BoardRepository;
import com.chunjae.board2.service.BoardService;
import static org.assertj.core.api.Assertions.*;

import jakarta.transaction.Transactional;
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
}
