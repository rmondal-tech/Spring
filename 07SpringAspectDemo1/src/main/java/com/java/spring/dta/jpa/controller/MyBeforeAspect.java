package com.java.spring.dta.jpa.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;//Simple Logging Facade for Java (SLF4J) 
import org.springframework.stereotype.Component;

/*
 * To create an aspect, you should follow these steps:

Step 1: Create class annotated with @Aspect
Step 2: Declare a pointcut (where the aspect is applied)
Step 3: Declare an advice (code to be executed)
 */

@Aspect      //aspect class declaration
@Component  //it is also necessary . Both defines a aspect class
//component will not work if scan is not mentioned and packge structure is different
public class MyBeforeAspect {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //@Before is one of the advice type and execution(..) part is the pointcut expression.
  //  @Before("execution(* com.java.spring.*.*(..))")
    
    @Before("execution(public * com.java.spring.dta.jpa.controller.MyController.testAspect())")
    public void log() {
        //Advice
       logger.info(" Check for user access ");
       logger.info(" Allowed execution for ");
        System.out.println("in aspect");
    }
}

//----------------------------------------------
/*
What are cross-cutting concerns?

How do you implement cross-cutting concerns in an application?

What is AOP and what problem AOP is trying to solve? how to implement logging ,security?

What are Aspects and Pointcuts in AOP?

What are the different types of AOP advices?

How do you implement AOP with Spring Boot?

How can you use Spring AOP ?

What are some AOP best practices?

// The cross-cutting concern-  is a concern which can be applicable through out the application 
     and it effects the entire application. logging ,security

//Aspect oriented programming -- is a programming paradigm that aims to increase modularity by allowing the separation
 of cross-cutting concerns. It does so by adding additional behavior(an advice) to existing code without modifying
 the code itself.   
  
   https://mehmetozanguven.github.io/spring/2020/11/13/aspect-oriented-programming-with-spring-boot-1.html
 2. Terminology in AOP
---------------------
 //Aspect: The class that implements the cross cutting concern.

// Pointcut: where the aspect is applied, controller etc

 //Advice: what code to be executed.

 //JointPoint-To determine which method was called, we use joinpoint.Advices can be presented with information about the       joinpoint. For example: method name, class name etc.The Join Point is a specific execution instance of an advice.

//Weaver: Weaver is the framework that implements AOP — AspectJ or Spring AOP.
  * 
  * 
 Example of the problem -
 ----------------------
   

For instance, security is one of the cross-cutting concern. Let’s you have decided that only one endpoint can be accessible without login requirement in your application. After that I assumed that you updated your application like this:
public class UserLoginStatus{
  public static boolean isLoggedInUser(HttpServletRequest req){
    // returns true if user is logged in
  }
}
// ..
public class Controller{
    
  public String accessibleEndpoint(HttpServletRequest req){
   	return "success"
  }
    
  public String endpoint1(HttpServletRequest requestForEndpoint1){
    if (!UserLoginStatus.isLoggedInUser(..){
      return "error";
    }
    return "success"
  }
        
  public String endpoint2(HttpServletRequest requestForEndpoint2){
    if (!UserLoginStatus.isLoggedInUser(..)){
      return "error";
    }
    return "success"
  }
        
  public String endpoint3(HttpServletRequest requestForEndpoint3){
    if (!UserLoginStatus.isLoggedInUser(..)){
      return "error";
    }
    return "success"
  }
}

for each business logic you have, you are extending with the security concern. At the end your business logic will be equal to business logic + security concern

Let’s say after that update, you decided to log all endpoints. Then I assumed that you updated your application like this one:
public class UserLoginStatus{
  public static boolean isLoggedInUser(HttpServletRequest req){
    // return true if loggedin user for that request
  }
}
// ..
public class Controller{
  private static final Logger LOGGER = LoggerFactory...;
    
  public String accessibleEndpoint(HttpServletRequest req){
    final String methodName = "accessibleEndpoint";
    LOGGER.info("log for method: {} and reques: {} ", methodName, req);
   	return "success"
  }
    
  public String endpoint1(HttpServletRequest requestForEndpoint1){
    final String methodName = "endpoint1";
    LOGGER.info("log for method: {} and reques: {} ", methodName, req);
    if (!UserLoginStatus.isLoggedInUser(..){
      LOGGER.info("not logged in user");  
      return "error";
    }
    LOGGER.info("another log")      
    return "success"
  }
        
 ..................
 ...................
 
}
At the end your business logic will be equal to 
----------------------------------------------------
 business logic = business logic + security concern + logging concern
---------------------------------------------------



Solution of the problem:
-----------------------

It is clear that solutions like the above are not the feasible. It would be nice if there is central class that handles all these concerns (which are not directly related to our business logic).

That’s the AOP is trying to solve. AOP allows centralized implementation of cross-cutting concerns. Because without AOP, they can not be implemented in a single place.

---------------------------------------------------------------------------------

What was the @Before and execution(...) ?
@Before is one of the advice type and execution(..) part is the pointcut expression.

Advice Types -
--------------

Before Advice (@Before)
Executed before the actual method.
If you want to avoid the call original method, you can do that only throwing exception inside the advice.
And the end execution is propagated to the caller.

After Advice (@After)
Executed after the original method

After Throwing (@AfterThrowing )
Executed if the actual method throws an exception
Exception will be propagated to the caller.

After Returning (@AfterReturning)
Executed if the method returned successfully

Around (@Around)
Wraps around the method
Only the one can prevent the original method from being called. (this can also be done by throwing exception at @Before advice, but at the end it will be propagated to the caller)
Only advice that can catch exceptions and it will not propagated to the caller.
Only advice that can modify return value.
We use ProceedingJoinPoint which extends JoinPoint in that advice. This class includes method proceed()that allows us to continue the original method call.
// Pointcut Expression-
This is the expression where aspect is applied. In the example above:
// execution means that it is a method execution pointcut expression
// execute **before advice**, before the method execution called homeController which returns String and takes no parameter.
@Before("execution(String homeController())")


We can also use wild-cards for parts of the expression:

Wild-card for return type: *
Wild-card for method name : *
Wild-card for parameters: ..
// expression for any method name which takes any parameter and any return type
"execution(* *(..))""
There are also other pointcut expressions such as within, args. For more info you can check the spring-aop-pointcut-tutorial from Bealdung.

Some pointcut expressions
the execution of any method:
"execution(* *(..))"
the execution of any method with a name beginning with “set”:
"execution(* set*(..))"
the execution of any method defined by the AccountService interface:
"execution(* com.xyz.service.AccountService.*(..))"
the execution of any method defined in the service package:
"execution(* com.xyz.service.*.*(..))"
the execution of any method defined in the service package or sub-package:
"execution(* com.xyz.service..*.*(..))"
 */
 