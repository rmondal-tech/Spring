package com.java.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;//Simple Logging Facade for Java (SLF4J) 
import org.springframework.stereotype.Component;



@Aspect      //aspect class declaration
@Component  //it is also necessary . Both defines a aspect class
public class MyBeforeAspect {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
  //  @Before("execution(* com.java.spring.*.*(..))")
    @Before("execution(public * com.java.spring.dta.jpa.controller.MyController.showPerson(*))")
    public void before(JoinPoint joinPoint) {
        //Advice
      //  logger.info(" Check for user access ");
        //logger.info(" Allowed execution for {}", joinPoint);
        System.out.println("in aspect");
    }
}
