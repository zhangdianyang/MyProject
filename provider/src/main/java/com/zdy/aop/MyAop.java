package com.zdy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(MyAop.class);

    @Pointcut(value = "execution(* com.zdy.service..*.*(..))")
    public void pointCutMethod(){}

    @Around("pointCutMethod()")
    public Object aroundService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("耗时="+(endTime-startTime)+"毫秒");
        return result;
    }

    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void afterThrowingService(Throwable e) throws Exception {
        e.printStackTrace();
        throw new Exception("服务器错误");
    }

}
