package com.kthsoft.security.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.kthsoft.security.handler.SpringDemoAccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http)
			throws Exception {
		http.authorizeRequests().antMatchers("/**").access("hasAnyRole('ROLE_USER')").and()
			.httpBasic().and()
			.exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
	};

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER").and()
			.withUser("unauthorizedUser").password("password").roles("UNAUTHORIZED_USER");
	}

	@Bean
	public SpringDemoAccessDeniedHandlerImpl getAccessDeniedHandler() {
		return new SpringDemoAccessDeniedHandlerImpl();
	}
}
