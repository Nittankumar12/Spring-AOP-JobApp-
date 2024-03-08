package com.Railworld.SpringJobAppRest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);


    // we can also do this by using before advice
    @Around("execution (* com.Railworld.SpringJobAppRest.service.JobService.getJob(..)) && args(postId)")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("Id is negative, updating it to positive!!");
            postId = - postId;
            LOGGER.info("New value is: " + postId);
        }
         Object object = proceedingJoinPoint.proceed(new Object[]{postId});
        return object;
    }
}
