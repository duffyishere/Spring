package org.duffy.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.duffy.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;

    @Test
    public void getList(){
        boardMapper.getList().forEach(log::info);
    }

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("TEST");
        boardVO.setWriter("TESTER");
        boardVO.setContext("TEST CONTEXT");

        boardMapper.insertSelectKey(boardVO);
        log.info(boardVO);
    }

    @Test
    public void testRead(){
        BoardVO boardVO = boardMapper.read(10L);
        log.info("-----------------------");
        log.info(boardVO);
    }
}
