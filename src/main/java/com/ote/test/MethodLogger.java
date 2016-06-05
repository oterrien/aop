package com.ote.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
public class MethodLogger {

    @Around("execution(* *(..)) && @annotation(com.ote.test.Loggable)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        System.out.printf("#%s(%s): %s in %sms\n", point.getSignature().getName(), Stream.of(point.getArgs()).collect(Collectors.toList()), result, System.currentTimeMillis() - start);
        return result;
    }
}