package com.ote.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* *(..)) && @annotation(com.ote.test.Loggable)")
    public Object aroundLoggable(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        System.out.printf("#MethodLogger : %s(%s): %s in %sms\n", point.getSignature().getName(), Stream.of(point.getArgs()).collect(Collectors.toList()), result, System.currentTimeMillis() - start);
        return result;
    }


}