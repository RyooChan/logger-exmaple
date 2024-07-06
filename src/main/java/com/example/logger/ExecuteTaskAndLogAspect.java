package com.example.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecuteTaskAndLogAspect {

    @Around("@annotation(com.example.logger.ExecuteTaskAndLog)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        String targetClassName = joinPoint.getSignature().getDeclaringTypeName();
        String targetMethodName = joinPoint.getSignature().getName();

        log.info(targetClassName + "." + targetMethodName + " 의 실행 시간 : " + duration + "ms");
        return proceed;
    }
}
