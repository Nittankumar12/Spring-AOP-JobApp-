package com.Railworld.SpringJobAppRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER =  LoggerFactory.getLogger(LoggingAspect.class);


	@Before("execution (* com.Railworld.SpringJobAppRest.service.JobService.*(..))")
	public void logMethodCall(JoinPoint joinPoint) {
		LOGGER.info("Method Called " + joinPoint.getSignature().getName());
	}

	@After("execution (* com.Railworld.SpringJobAppRest.service.JobService.getJob(..))")
	public void logMethodExecuted(JoinPoint joinPoint) {
		LOGGER.info("Method Executed " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution (* com.Railworld.SpringJobAppRest.service.JobService.getAllJobs(..))")
	public void logMethodReturned(JoinPoint joinPoint) {
		LOGGER.info("Method Returned Something "+ joinPoint.getSignature().getName());
	}

	@AfterThrowing("execution (* com.Railworld.SpringJobAppRest.service.JobService.getJob(..))")
	public void logMethodIssue(JoinPoint joinPoint) {
		LOGGER.info("Method Throws error "+ joinPoint.getSignature().getName());
	}


    // but if we want to call this method for a specific method then syntax will
    // be @Before("execution(return type,class name with package, method name, args))

//    @Before("execution (* com.Railworld.SpringJobAppRest.service.JobService.*(..))")
//	public void logMethodCall() {
//		LOGGER.info("Method Called ");
//	}
//
//	@After("execution (* com.Railworld.SpringJobAppRest.service.JobService.getJob(..))")
//	public void logMethodExecuted() {
//		LOGGER.info("Method Executed ");
//	}
//
//	@AfterReturning("execution (* com.Railworld.SpringJobAppRest.service.JobService.getAllJobs(..))")
//	public void logMethodReturned() {
//		LOGGER.info("Method Returned Something ");
//	}
//
//	@AfterThrowing("execution (* com.Railworld.SpringJobAppRest.service.JobService.getJob(..))")
//	public void logMethodIssue() {
//		LOGGER.info("Method Throws error ");
//	}
}

