package com.chunjae.board;

import com.chunjae.board.service.BoardService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(properties = "spring.config.location=classpath:application.yml")
@Transactional
public class EntityTest {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BoardService boardService;

    @Test
    public void t1(){
        Assertions.assertNotNull(em);
    }

    @Test
    public void findAll(){
        Assertions.assertEquals(107,boardService.findList().size());
    }
}
