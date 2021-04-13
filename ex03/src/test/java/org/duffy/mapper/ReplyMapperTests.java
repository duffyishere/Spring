package org.duffy.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper replyMapper;
	
	@Test
	public void testMapper() {
		
		log.info(replyMapper);
	}
}
