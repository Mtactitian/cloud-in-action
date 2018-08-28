package com.alexb.employeeservice.aspects;

import com.alexb.employeeservice.annotation.Delay;
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
public class DelayAspect {

    @Before(value = "@annotation(com.alexb.employeeservice.annotation.Delay)")
    public void injectRandomDelay(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Delay delay = method.getAnnotation(Delay.class);
        int timeToSleep = delay.millis();

        log.debug("Sleep started");
        Thread.sleep(timeToSleep);
        log.debug("Sleep ended");

    }
}
