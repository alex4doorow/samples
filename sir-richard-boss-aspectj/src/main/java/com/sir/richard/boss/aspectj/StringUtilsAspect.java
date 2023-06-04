package com.sir.richard.boss.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StringUtilsAspect {
    /*
    @Around("execution(public static boolean org.apache.commons.lang3.StringUtils.isNotEmpty(..))")
    public boolean aroundIsNotEmpty(ProceedingJoinPoint joinPoint) throws Throwable {        // Ваш код, выполняющийся перед вызовом метода
        System.out.println("Before calling isNotEmpty method");
        // Вызов метода
        boolean result = (boolean) joinPoint.proceed();
        // Ваш код, выполняющийся после вызова метода
        System.out.println("After calling isNotEmpty method");
        return result;
    }

    */

    @After("call(public static * org.apache.commons.lang3.StringUtils.*(..))")
    public void logStringUtilsMethods1(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Called StringUtils method: " + methodName);
    }

    @After("call(public static * org.apache.commons.lang3.StringUtils.isNotEmpty(..))")
    public void logStringUtilsMethods2(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Called StringUtils method isNotEmpty: " + methodName);
    }

    @Around("execution(public static boolean org.apache.commons.lang3.StringUtils.isNotEmpty(java.lang.CharSequence)) && args(cs)")
    public Object aroundIsNotEmpty(ProceedingJoinPoint joinPoint, CharSequence cs) throws Throwable {
        // Ваш код, выполняющийся перед вызовом метода
        System.out.println("Before calling org.apache.commons.lang3.StringUtils.isNotEmpty");

        // Вызов метода
        Object result = joinPoint.proceed();

        // Ваш код, выполняющийся после вызова метода
        System.out.println("After calling org.apache.commons.lang3.StringUtils.isNotEmpty");

        return result;
    }
}
