package com.alexb.employeeservice.aspects;

import com.alexb.employeeservice.annotation.RandomDelay;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class RandomDelayAspect {

    @Before(value = "@annotation(com.alexb.employeeservice.annotation.RandomDelay)")
    public void injectRandomDelay(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        RandomDelay randomDelay = method.getAnnotation(RandomDelay.class);
        int timeToSleep = randomDelay.millis();

        log.debug("Sleep started");
        Thread.sleep(timeToSleep);
        log.debug("Sleep ended");

    }
}
