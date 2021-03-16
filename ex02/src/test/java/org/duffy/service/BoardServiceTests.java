package org.duffy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j 
public class BoardServiceTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testPrint() {
		
		log.info(boardService);
		
	}
	
	@Test
	public void testGetList() {
		
		boardService.getList().forEach(log::info);
	}
}
