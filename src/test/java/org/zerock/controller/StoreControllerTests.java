package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
@WebAppConfiguration 
public class StoreControllerTests {

	@Inject
	WebApplicationContext ctx;
	
	MockMvc mockMvc; 
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); //가짜 MVC
	}
	
	@Test
	public void testList() throws Exception{
		//페이지는 .param하면됨
		Map<String, Object> map = mockMvc.perform(get("/store/list")).andReturn().getModelAndView().getModel();
	
		System.out.println(map);
	}
	
}
