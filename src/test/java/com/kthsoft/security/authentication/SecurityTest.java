package com.kthsoft.security.authentication;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.servlet.Filter;

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
import com.kthsoft.security.spring.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class SecurityTest {

	private static final String UNAUTHORIZED_USER = "unauthorizedUser";

	private static final String CORRECT_PASSWORD = "password";

	private static final String USERNAME = "user";

	@Autowired
	protected WebApplicationContext wac;
	
	@Autowired
    private Filter springSecurityFilterChain;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = webAppContextSetup(this.wac)
				.addFilters(springSecurityFilterChain)
				.build();
	}

	@After
	public void tearDown() throws Exception {
		//
	}

	@Test
	public void testRequireAuthentication() throws Exception {
		// When and Then
		// Redirect to login form
		mockMvc.perform(get("/testAuthentication")).andExpect(status().is(401));
	}
	
	@Test
	public void testBasicAuthenticationAndAuthorizationSuccess() throws Exception {
		// When and Then
		// Login with correct username password
		mockMvc.perform(get("/testAuthentication").with(httpBasic(USERNAME, CORRECT_PASSWORD)))
			.andExpect(status().is(200))
			.andExpect(authenticated().withUsername(USERNAME));
	}
	
	@Test
    public void testAuthenticationFailed() throws Exception {
		// When and Then
		// Login with invalid password
		mockMvc.perform(get("/testAuthentication").with(httpBasic(USERNAME,"INVALID_PASSWORD")))
            .andExpect(status().is(401))
            .andExpect(unauthenticated());
    }
	
	@Test
	public void testBasicAuthenticationSuccessButNotAuthorization() throws Exception {
		// When and Then
		// Login success but not have correct right 
		mockMvc.perform(get("/testAuthentication").with(httpBasic(UNAUTHORIZED_USER, CORRECT_PASSWORD)))
            .andExpect(status().is(403))
            .andExpect(authenticated().withUsername(UNAUTHORIZED_USER));
	}
}
