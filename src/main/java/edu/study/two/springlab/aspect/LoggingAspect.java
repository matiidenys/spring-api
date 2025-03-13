package edu.study.two.springlab.aspect;

import edu.study.two.springlab.service.impls.AuthorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LogManager.getLogger(AuthorService.class);

    @Pointcut("@annotation(edu.study.two.springlab.annotation.AuthorGetAnnotation)")
    public void loggingPointCut(){}

    @Before("loggingPointCut()")
    public void before(){
        logger.info("Get operation is going to be performed");
    }

    @After("loggingPointCut()")
    public void after(){
        logger.info("Get operation has been performed");
    }

    @Around("loggingPointCut()")
    public Object getOperationExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object proceeding = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        logger.info(methodName + " operation took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return proceeding;
    }
}
