package com.chunjae.aop.aspect1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class Advice3 {

    // execution 메서드를 타겟으로 지정한다.
    @Pointcut("execution(* com.chunjae.aop.service.Service2.*(..))")
    private void pointMethod(){
    }

    @Before("pointMethod()")
    public void before(){
        System.out.println("before Advice3");
    }

    // within 클래스를 타겟으로 지정한다. (해당 클래스 내의 메서드에 동작)
    @After("within(com.chunjae.aop.service.Service2)")
    public void after(){
        System.out.println("after Advice3");
    }

    @AfterReturning(pointcut = "execution(* com.chunjae..service.Service2.*(..))", returning = "o")
    public void after(Object o){
        System.out.println("after returning Advice3 :"+o);
    }

    @AfterThrowing(pointcut = "execution(* com.chunjae..service.Service2.*(..))", throwing = "ex")
    public void after(Throwable ex){
        System.out.println("after throwable Advice3 :"+ex);
    }

    @Around("execution(* com.chunjae..service.Service3.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch watch = new StopWatch();
        System.out.println("around start Advice3 ");
        watch.start();
        try{
            Object o = joinPoint.proceed();
            return o;
        }finally {
            watch.stop();
            System.out.println(" around end Advice3 ");
            double time = watch.getTotalTimeMillis();
            System.out.println(" around 경과시간 : "+time);

        }
    }


}
