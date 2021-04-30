package org.duffy.service;

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
public class SampleTxServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleTxService sampleTxService;
	
	@Test
	public void testLong() {
		String str = "Starry, starry night\n"
				+ "Paint your palette blue and gray\n"
				+ "Look out on a summer's day";
		
		log.info(str.getBytes().length);
		
		sampleTxService.addData(str);
	}
	
}
