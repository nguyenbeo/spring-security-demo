package com.kthsoft.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAuthenticationController {
	
	/**
     * Test Authentication
     */
    @RequestMapping(value = "/testAuthentication", method = RequestMethod.GET)
    public ResponseEntity<Void> testAuthentication() {
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
