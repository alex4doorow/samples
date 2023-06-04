package com.sir.richard.boss.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.apache.log4j.Logger;

@Aspect
public class LoggingAspect {

    //private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sir.richard.boss.bo.CustomerBo.addCustomer())")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing addCustomer() method");
    }


    @Before("execution(boolean com.sir.richard.boss.bo.CustomerBo.doReconnect())")
    public void doReconnectAdvice() {
        System.out.println("log Executing doReconnect() method");
        //LOG.info("log Executing doReconnect() method");
    }

    /*
    @AfterReturning(pointcut = "execution(boolean com.sir.richard.boss.bo.CustomerBo.doReconnect())", returning = "result")
    public void doReconnectAdvice(JoinPoint joinPoint, boolean result) {
        //LOGGER.info("Executing doReconnect() method");
        //LOGGER.info("Result of doReconnect(): " + result);
        System.out.println("Executing doReconnect() method");
        System.out.println("Result of doReconnect(): " + result);
    }
    */


}
