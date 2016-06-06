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

@Component
@Aspect
public class MethodLogger {

    @Around("execution(* *(..)) && @annotation(com.ote.test.Loggable)")
    public Object aroundLoggable(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        System.out.printf("####################%s(%s): %s in %sms\n", point.getSignature().getName(), Stream.of(point.getArgs()).collect(Collectors.toList()), result, System.currentTimeMillis() - start);
        return result;
    }

    @AfterReturning("execution(* *(..)) && target(instance) && args(newValue) && @annotation(com.ote.test.Trigger)")
    public void afterOnUpdate(JoinPoint joinPoint, Object instance, Object newValue) throws Throwable {
        System.out.println("++++++++++++++++++++++++++");
        Method exectutedMethod = joinPoint.getStaticPart().getSignature().getDeclaringType().getDeclaredMethod(joinPoint.getStaticPart().getSignature().getName(), String.class);
        String methodToBeTriggered = exectutedMethod.getAnnotation(com.ote.test.Trigger.class).method();
        Method trigMethod = joinPoint.getStaticPart().getSignature().getDeclaringType().getDeclaredMethod(methodToBeTriggered);
        trigMethod.setAccessible(true);
        trigMethod.invoke(joinPoint.getThis());

    }
}