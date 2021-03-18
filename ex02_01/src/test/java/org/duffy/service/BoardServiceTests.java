package org.duffy.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.duffy.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

    @Test
    public void testExist(){
        log.info(boardService);
    }

    @Test
    public void testRegister(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("New Title");
        boardVO.setContext("New Context");
        boardVO.setWriter("Newbie");

        log.info("Number of added : "+boardService.register(boardVO));
        log.info("new bno : "+boardVO.getBno());
    }

    @Test
    public void testGetAllPost(){
        boardService.getAllPost().forEach(log::info);
    }

    @Test
    public void testGetPost(){
        log.info(boardService.getPost(5L));
    }

    @Test
    public void testRemove(){
        log.info("REMOVE RESULT : " + boardService.remove(4696L));
    }

    @Test
    public void testModify(){
        BoardVO boardVO = new BoardVO();
        boardVO = boardService.getPost(5L);

        boardVO.setTitle("Change title");
        log.info("MODIFY RESULT : " + boardService.modify(boardVO));
    }
}
