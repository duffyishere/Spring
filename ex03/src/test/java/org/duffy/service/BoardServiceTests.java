package org.duffy.service;

import static org.junit.Assert.assertNotNull;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ ={@Autowired} )
	private BoardService boardService;
	
	
	//Error - 2021.3.27(solved :2021.3.27 )
	//No default constructor found; nested exception is java.lang.NoSuchMethodException: org.duffy.service.BoardServiceImpl.<init>()
	//org.duffy.serviceImpl에 기본 생성자 생성후 해결
	@Test
	public void testExist() {
		
		log.info(boardService);
		assertNotNull(boardService);
	}
	
	
	//Error - 2021.3.27
	//Null Point Exception
	//org.duffy.serviceImpl에서 boardMapper를 빈을 생성하지 않았음 
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("NEW");
		board.setContext("NEW");
		board.setWriter("newbie");

		boardService.register(board);
		
		log.info(board.getBno());
	}

	
	@Test
	public void testGetListAll() {
		Criteria cri = new Criteria();
		boardService.getListAll(cri).forEach(log::info);
	}
	
	@Test
	public void testGetList() {
		boardService.getList(22L);
	}
	
	@Test
	public void testRemove() {
		boardService.remove(22L);
		
	}
	
}
