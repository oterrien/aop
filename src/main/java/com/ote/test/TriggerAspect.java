package com.ote.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TriggerAspect {

    @AfterReturning("execution(* *(..)) && @annotation(com.ote.test.Trigger)")
    public void afterOnUpdate(JoinPoint joinPoint) throws Throwable {
        System.out.println("#TriggerAspect : ");
        Method exectutedMethod = joinPoint.getStaticPart().getSignature().getDeclaringType().getDeclaredMethod(joinPoint.getStaticPart().getSignature().getName(), String.class);
        String methodToBeTriggered = exectutedMethod.getAnnotation(com.ote.test.Trigger.class).method();
        Method trigMethod = joinPoint.getStaticPart().getSignature().getDeclaringType().getDeclaredMethod(methodToBeTriggered);
        trigMethod.setAccessible(true);
        trigMethod.invoke(joinPoint.getThis());
    }
}
