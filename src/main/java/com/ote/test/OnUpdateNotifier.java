package com.ote.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.stream.Collectors;
import java.util.stream.Stream;
/*

@Aspect
public class OnUpdateNotifier {

    @Around("set(@com.ote.test.OnUpdate java.lang.Sring *.*)")
    public Object after(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        System.out.printf("#%s(%s): %s in %sms\n", point.getSignature().getName(), Stream.of(point.getArgs()).collect(Collectors.toList()), result, System.currentTimeMillis() - start);
        return result;
    }
}*/
