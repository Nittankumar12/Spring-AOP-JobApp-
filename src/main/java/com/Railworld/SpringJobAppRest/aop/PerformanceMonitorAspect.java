package com.Railworld.SpringJobAppRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution (* com.Railworld.SpringJobAppRest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken by " + proceedingJoinPoint.getSignature().getName() + " is " + (end-start) + "ms");
        return object;
    }
}
