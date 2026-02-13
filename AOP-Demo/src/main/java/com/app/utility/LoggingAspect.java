package com.app.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // Apply on all controller methods
    /*
    Note: 1st * :  for interception any return type of method
           2nd * : for all classes of the package
           3rd * : for all methods of the classes
     */
    @Around("execution(* com.app.controller.*.*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("➡️ Entering {}.{}() with args = {}",
                className, methodName, Arrays.toString(args));

        Object result = joinPoint.proceed(); // actual method call

        long endTime = System.currentTimeMillis();

        log.info("⬅️ Exiting {}.{}() | Response = {} | Time = {} ms",
                className, methodName, result, (endTime - startTime));

        return result;
    }
}

