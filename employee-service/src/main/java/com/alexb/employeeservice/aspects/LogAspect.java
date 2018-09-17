package com.alexb.employeeservice.aspects;

import com.alexb.employeeservice.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @After(value = "@annotation(com.alexb.employeeservice.annotation.Log)")
    public void logMessage(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Log log = method.getAnnotation(Log.class);
        String level = log.level();
        String message = log.message();

        Logger logger = LoggerFactory.getLogger(method.getDeclaringClass());

        switch (level.toLowerCase()) {
            case "info":
                logger.info(message);
                break;
            case "debug":
                logger.debug(message);
                break;
            case "error":
                logger.error(message);
                break;
            case "warn":
                logger.warn(message);
                break;
            default:
                logger.trace(message);
        }
    }
}
