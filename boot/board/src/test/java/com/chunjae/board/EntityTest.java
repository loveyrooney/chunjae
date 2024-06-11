package com.chunjae.board;

import com.chunjae.board.domain.UserBoard;
import com.chunjae.board.repository.BoardRepository;
import com.chunjae.board.service.BoardService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = "spring.config.location=classpath:application.yml")
@Transactional
public class EntityTest {

    private final Logger log = LoggerFactory.getLogger(EntityTest.class);
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void t1(){
        assertThat(em).isNotNull();
    }

    @Test
    public void findAll(){
        assertThat(boardService.findList().size()).isGreaterThan(100);
    }

    @Test
    public void findById(){
        Optional<UserBoard> board = boardRepository.findById(100L);
        UserBoard b1 = board.orElseThrow();
        assertThat(b1.getTitle()).isEqualTo("Steven");
    }

    @Test
    public void findByTitle(){
        Optional<UserBoard> bytitle = boardRepository.findByTitle("Lex");
        UserBoard b2 = bytitle.orElseThrow();
        assertThat(b2.getBoardId()).isEqualTo(102L);
        log.info("lex... {}",b2.getWriteDate());
    }

    @Test
    public void findByTitleContaining(){
        List<UserBoard> containtitle = boardRepository.findByTitleContaining("ee");
        for(UserBoard u:containtitle){
            log.info("contain... {}",u.getTitle()+u.getBoardId());
        }
    }
}
