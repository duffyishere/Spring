package org.duffy.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "file:web/WEB-INF/applicationContext.xml",
        "file:web/WEB-INF/dispatcher-servlet.xml"})
@Log4j
public class BoardControllerTests {

    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        //WARN : org.springframework.web.servlet.PageNotFound - No mapping for GET /board/list (해결)
        //web.xml에 url-pattern를 /로 변경후 dispatcher-servlet.xml를 추가하니 해결
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap());
    }

    @Test
    public void testGet() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
        .param("bno", "6"))
                .andReturn()
                .getModelAndView()
                .getModelMap());
    }

    @Test
    public void testRegister() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
        .param("title", "test new title")
        .param("context", "test new context")
        .param("writer", "user00")
        ).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testModify() throws Exception {
        String reulstPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
        .param("bno", "6")
        .param("title", "Modify Title")
        .param("context", "Modify Context")
        ).andReturn().getModelAndView().getViewName();

        log.info(reulstPage);
    }

    @Test
    public void testRemove() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
        .param("bno", "4702")
        ).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }
}

