package com.iris.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.iris.dao.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
@Transactional
@WebAppConfiguration
public class BoardControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;
    
    @Autowired
    BoardDao boardDao;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void findAll() throws Exception {

        MockHttpSession session = new MockHttpSession();

        mockMvc.perform(get("/findAll").session(session)).andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    
    @Test
    public void findOne() throws Exception {

        MockHttpSession session = new MockHttpSession();

        mockMvc.perform(get("/findOne").session(session)
        		.param("id", String.valueOf(boardDao.findAll().get(0).getId()))
        		).andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

}
