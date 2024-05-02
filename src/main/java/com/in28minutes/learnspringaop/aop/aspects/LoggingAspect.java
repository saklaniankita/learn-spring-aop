package com.in28minutes.learnspringaop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * AOP configuration class
 */
@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.dataPackageConfig()")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        logger.info("Before Aspect: {} with arguments {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallafter(JoinPoint joinPoint) {
        logger.info("after Aspect: {} with arguments {}", joinPoint, joinPoint.getArgs());
    }

    @Around("com.in28minutes.learnspringaop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    public Object performanceTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info("Around Aspect: {}. Method executed in {} milliseconds", proceedingJoinPoint, endTime-startTime);
        return returnValue;
    }
}
