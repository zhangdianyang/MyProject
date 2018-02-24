package com.zdy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * aop
 * @author zdy
 */
@Aspect
@Component
@Order(1)
public class MyAop {

    @Pointcut(value = "execution(* com.zdy.service..*.*(..))")
    public void pointCutMethod(){}

    @Around("pointCutMethod()")
    public Object aroundService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        return result;
    }

}
