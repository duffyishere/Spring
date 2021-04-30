package org.duffy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	Sample1Mapper sampleMapper1;
	
	@Setter(onMethod_ = @Autowired)
	Sample2Mapper sampleMapper2;
	

	@Test
	public void insertTest() {
		log.info(sampleMapper1.insertCol1("asd2"));;
	}
}
