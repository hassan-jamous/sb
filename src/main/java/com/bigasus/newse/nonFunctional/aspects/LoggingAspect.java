package com.bigasus.newse.nonFunctional.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(@com.bigasus.newse.nonFunctional.aspects.annotations.LogMe * *.*(..))")
    void annotatedClass() {
        //pointcut for annotated classes
    }

    @Pointcut("execution(* (@com.bigasus.newse.nonFunctional.aspects.annotations.LogMe *).*(..))")
    void annotatedMethod() {
        //pointcut for annotated methods
    }

    @Around("annotatedClass() || annotatedMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        LOGGER.info("Before " + point.getSignature().toShortString());
        Object result;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            LOGGER.severe("Error");
            throw throwable;
        }
        LOGGER.info("After" + point.getSignature().toShortString());
        return result;
    }
}
