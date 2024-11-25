package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintExecutionTimeAspect {

    @Around("@annotation(PrintExecutionTime)")
    public Object printExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        var object = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("executed " + executionTime + " ms.");

        return object;
    }

    @Before("@annotation(PrintExecutionTime)")
    public void beforePrintExecutionTime(JoinPoint joinPoint) {
        if (((String)joinPoint.getArgs()[0]).contains("admin")) {
            throw new IllegalArgumentException("can't say hello to admin");
        }
    }







}
