package org.duffy.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		})
@Log4j 
public class BoardControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	// 테스트 메소드 실행전 셋업 메소드입니다.
	@Before
	public void setup(){
		// 이곳에서 HomeController를 MockMvc 객체로 만듭니다.
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception{
		// HomeController의 "/" 매핑으로 정의합니다.
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception{
		// HomeController의 "/" 매핑으로 정의합니다.
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "PostTest 테스트2")
					.param("context", "Context")
					.param("writer", "userTest")
					)
			.andReturn()
			.getModelAndView()
			.getModelMap());
	}
	
	@Test
	public void testDelete() throws Exception{
		// HomeController의 "/" 매핑으로 정의합니다.
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
					.param("bno", "13")
					)
			.andReturn()
			.getModelAndView()
			.getModelMap());
	}
}
