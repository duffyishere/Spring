package org.duffy.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
import org.duffy.domain.PageDTO;
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
public class BoadMapperTests {
	 
	@Setter(onMethod_= {@Autowired})
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		log.info("------------------");
		boardMapper.getList();
		boardMapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("Test 테스트");
		vo.setContext("Context 테스트");
		vo.setWriter("tester");
		
		boardMapper.insert(vo);
		
		log.info("-----------");
		log.info(vo.getBno());
	}
	
	public void testInsertKey() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("Test 테스트");
		vo.setContext("Context 테스트");
		vo.setWriter("tester");
		
		boardMapper.insertSelectKey(vo);

		log.info("-----------");
		log.info(vo.getBno());
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(1L);
		
		log.info(vo);
		
	}

	@Test
	public void delete() {
		int count = boardMapper.delete(2L);
		
		log.info(count);
		
	}
	
	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(11L);
		vo.setContext("Update Context");
		vo.setTitle("Update Title");
		
		log.info(boardMapper.update(vo));
	}
	
	@Test
	public void testMapping() {
		Criteria cri = new Criteria(1, 5);
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
//		list.forEach(b -> log.info(b));
		list.forEach(log::info);
	}
	
	@Test
	public void testPageDTO() {
		Criteria cri = new Criteria(21);
		
		PageDTO pageDTO = new PageDTO(cri, 253);
		
		log.info(pageDTO);
	}
	
	@Test
	public void testSearchPaging() {
		Criteria cri = new Criteria();
		cri.setType("TCW");
		cri.setKeyword("Test");
		
		List<BoardVO> board = boardMapper.getListWithPaging(cri);
		board.forEach(log::info);
	}
}
