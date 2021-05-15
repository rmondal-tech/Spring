package com.java.spring.dta.jpa.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
	@Component
	public class LoggingAspect {
	    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	    @Before("execution(String MyController())")
	    private void loggingAspectForHomeController(){
	        // code to be executed
	        LOGGER.info("aspect works");
	        System.out.println("Aspect Works");
	    }
	}

