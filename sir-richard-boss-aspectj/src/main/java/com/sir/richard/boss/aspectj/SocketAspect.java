package com.sir.richard.boss.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.IOException;
import java.net.SocketAddress;

@Aspect
public class SocketAspect {

    @Before("execution(public void java.net.Socket.*(..))")
    public void beforeDoConnect() {
        System.out.println("*** Intercepted java.net.Socket.connect method before");
        // Ваш код обработки или логирования здесь
    }

    @After("execution(public void java.net.Socket.*(..))")
    public void afterDoConnect() {
        System.out.println("*** Intercepted java.net.Socket.connect method after");
        // Ваш код обработки или логирования здесь
    }

    //@Around("execution(public void java.net.Socket.connect(java.net.SocketAddress, int)) && args(endpoint, timeout)")
    @Around("execution(* java.net.Socket.connect(java.net.SocketAddress, int)) && args(endpoint, timeout)")
    public void aroundConnect(ProceedingJoinPoint joinPoint, SocketAddress endpoint, int timeout) throws Throwable {
        try {
            System.out.println("*** Before connect");
            joinPoint.proceed();
            System.out.println("*** After connect");
        } catch (IOException e) {
            System.out.println("*** Exception during connect: " + e.getMessage());
            throw e;
        }
    }
}
