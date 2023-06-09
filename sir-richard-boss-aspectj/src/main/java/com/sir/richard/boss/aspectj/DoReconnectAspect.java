package com.sir.richard.boss.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DoReconnectAspect {


    @After("execution(final boolean org.apache.activemq.transport.failover.FailoverTransport.doReconnect())")
    public void afterDoReconnect() {
        System.out.println("Intercepted doReconnect() method");
        // Ваш код обработки или логирования здесь
    }


    //@Pointcut("execution(final boolean org.apache.activemq.transport.failover.FailoverTransport.doReconnect())")
    public void failoverTransportDoReconnect() {
    }

    //@AfterReturning(pointcut = "failoverTransportDoReconnect()", returning = "result")
    public void afterReturningFromFailoverTransportDoReconnect(boolean result) {
        System.out.println("doReconnect method of FailoverTransport has been called. Result: " + result);
    }


    //private static final Logger LOG = LoggerFactory.getLogger(DoReconnectAspect.class);

    /*
    @AfterReturning(pointcut = "execution(boolean com.sir.richard.boss.activemq.transport.failover.FailoverTransport.doReconnect())", returning = "result")
    public void logDoReconnect(JoinPoint joinPoint, boolean result) {
        System.out.println("logDoReconnect result:" + result);
        LOG.info("Executing doReconnect() method");
        LOG.info("Result of doReconnect(): {}", result);
    }

    */

    //@Pointcut("execution(org.apache.activemq.transport.failover.FailoverTransport.new())")
    public void failoverTransportConstructor() {
    }

   //@After("failoverTransportConstructor()")
    public void afterFailoverTransportConstructor() {
        System.out.println("*2 Constructor of FailoverTransport has been called.");
    }

    //@After("execution(final boolean org.apache.activemq.transport.failover.FailoverTransport.doReconnect())")
    public void logFailoverTransportMethods1(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("*** Called FailoverTransport doReconnect method: " + methodName);
    }

    //@After("execution(* org.apache.activemq.transport.failover.FailoverTransport.*(..))")
    public void logFailoverTransportMethods2(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("*** Called FailoverTransport method: " + methodName);
    }

    //@Around("execution(final boolean com.sir.richard.boss.activemq.transport.failover.FailoverTransport.doReconnect())")
    public boolean doReconnectAdvice1(ProceedingJoinPoint joinPoint) throws Throwable {
        // Before method execution
        //LOG.info("Before doReconnect() method");
        System.out.println("Before doReconnect() method");

        // Proceed with the original method execution
        boolean result = (boolean) joinPoint.proceed();

        // After method execution
        System.out.println("After doReconnect() method");
        System.out.println("Result of doReconnect(): " + result);


        //LOG.info("After doReconnect() method");
        //LOG.info("Result of doReconnect(): " + result);

        // Return the result
        return result;
    }

    //@Around("execution(boolean org.apache.commons.lang3.StringUtils.isNotEmpty(..))")
    public boolean stringUtilsIsNotEmptyAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // Before method execution
        //LOG.info("Before doReconnect() method");
        System.out.println("Before StringUtils.isNotEmpty method");

        // Proceed with the original method execution
        boolean result = (boolean) joinPoint.proceed();

        // After method execution
        System.out.println("After StringUtils.isNotEmpty method");
        System.out.println("Result of StringUtils.isNotEmpty(): " + result);


        //LOG.info("After doReconnect() method");
        //LOG.info("Result of doReconnect(): " + result);

        // Return the result
        return result;
    }



}
