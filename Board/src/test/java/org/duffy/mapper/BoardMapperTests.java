package org.duffy.mapper;

import org.duffy.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		boardMapper.getList().forEach(log::info);
//		log.info(boardMapper.getList());
	}
	
	@Test
	public void testDelete() {
		
		boardMapper.delete(9L);
	}
	
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("test03");
		board.setWriter("newbie");
		board.setContext("test");
		
		log.info("----------------------------------------------");
		log.info(boardMapper.insert(board)+".............................");
		log.info(board.getBno());
	}

}
