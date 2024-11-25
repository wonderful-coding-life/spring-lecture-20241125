package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @After("@annotation(PrintExecutionTime)")
    public void afterPrintExecutionTime(JoinPoint joinPoint) {
        System.out.println("after " + joinPoint.toShortString() + " with " + joinPoint.getArgs().length + " args.");
    }

    @AfterReturning(value = "@annotation(PrintExecutionTime)", returning = "result")
    public void afterReturningPrintExecutionTime(JoinPoint joinPoint, String result) {
        System.out.println("after returning " + result);
    }

}
