package com.chunjae.board2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class PageTest {
    Logger logger = LoggerFactory.getLogger(PageTest.class);
    @Test
    public void t1(){
        PageRequest page = PageRequest.of(0,10);
        logger.info("pagenum : {}",page.getPageNumber());
        logger.info("pagesize : {}",page.getPageSize());

    }
}
