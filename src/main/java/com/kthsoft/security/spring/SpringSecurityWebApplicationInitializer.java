package com.kthsoft.security.spring;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(value = 1)
public class SpringSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	//
}
