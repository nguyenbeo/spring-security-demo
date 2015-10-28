package com.kthsoft.security.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kthsoft.security.restdata.ErrorResponse;

/**
 * Access Denied Handler to return JSON if AccessDeniedException happened
 *  
 * @author nguyenbeo
 */
public class SpringDemoAccessDeniedHandlerImpl extends AccessDeniedHandlerImpl {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, 
			AccessDeniedException reason) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Not enough right to use this - " 
        		+ reason.getMessage());
        
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        
        PrintWriter out = response.getWriter();
        out.print(objectMapper.writeValueAsString(errorResponse));
        out.flush();
        out.close();
        return;
	}
}
