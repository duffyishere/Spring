package org.duffy.mapper;

import java.util.stream.IntStream;

import org.duffy.domain.ReplyVO;
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
public class ReplyMapperTests {

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper replyMapper;
	
	private Long[] bnoArr = {5545L, 5544L, 5543L, 5542L, 5541L};
	
	@Test
	public void testMapper() {
		
		log.info(replyMapper);
	}
	
	@Test
	public void testInsert() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO replyVO = new ReplyVO();
			replyVO.setBno(bnoArr[i%5]);
			replyVO.setReply("TEST" + i);
			replyVO.setReplyer("TESTER"+i);
			
			replyMapper.insert(replyVO);
		});
	}
	
	@Test
	public void testRead() {
		
		log.info(replyMapper.read(2L));
	}
	
	@Test
	public void testDelete() {
		
		log.info("Count :"+replyMapper.delete(11L));
	}
	
	@Test
	public void testUpdate() {
	
		ReplyVO vo = replyMapper.read(2L);
		
		vo.setReply("Update Reply");
		
		log.info("Count :"+replyMapper.update(vo));
	}
	
}
