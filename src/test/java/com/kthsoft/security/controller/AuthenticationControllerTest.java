package com.kthsoft.security.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.kthsoft.security.spring.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
public class AuthenticationControllerTest {
	
	@Autowired
	protected WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
		//
	}

	@Test
	public void testAuthenticationEndpoint() throws Exception {
		// When and Then
		mockMvc.perform(get("/testAuthentication")).andExpect(status().is(200));
	}

}
