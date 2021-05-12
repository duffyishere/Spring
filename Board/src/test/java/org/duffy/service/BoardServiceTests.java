package org.duffy.service;

import org.duffy.domain.BoardVO;
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

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		
		board.setTitle("22New22");
		board.setWriter("dasdb");
		board.setContext("22NEW");
		
		log.info(service.register(board)+"..................");
		log.info(board.getBno());
	}
	
	@Test
	public void testModify() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(12L);
		board.setTitle("22New");
		board.setWriter("dasdb");
		board.setContext("22NEW");
		
		log.info(service.modify(board));
	}
}
