package com.ote.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Aspect
public class OnUpdateNotifier {

    @After("@annotation(com.ote.test.OnUpdate)")
    public void after() throws Throwable {
        System.out.println("after onUpdate");
    }
}
