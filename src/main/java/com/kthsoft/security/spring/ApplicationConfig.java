package com.kthsoft.security.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.kthsoft.security.controller")
public class ApplicationConfig {
	// No need any more bean configuration
}
