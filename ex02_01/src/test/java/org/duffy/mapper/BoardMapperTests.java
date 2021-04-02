package org.duffy.mapper;

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
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		boardMapper.getList().forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setContext("TEST");
		board.setTitle("TEST");
		board.setWriter("TEST");
		
		boardMapper.insertSelectKey(board);
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO baord = boardMapper.read(699L);
		
		log.info(baord);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT :"+boardMapper.delete(698L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setContext("UPDATE");
		board.setTitle("TEST");
		board.setWriter("TEST");
		
		log.info("UPDATE COUNT :"+boardMapper.update(board));
	}
	
	@Test
	public void testGetListWithPaging() {
		Criteria cir = new Criteria(3, 10);
		
		boardMapper.getListWithPaging(cir).forEach(log::info);
	}
}
