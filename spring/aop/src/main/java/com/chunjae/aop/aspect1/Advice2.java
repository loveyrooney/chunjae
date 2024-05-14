package com.chunjae.aop.aspect1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class Advice2 {
    public Object around(ProceedingJoinPoint join) throws Throwable{
        StopWatch watch = new StopWatch();
        System.out.println("joinpoint ... "+join);
        System.out.println("start ...");
        watch.start();
        try{
            Object o = join.proceed();
            return o;
        }finally {
            watch.stop();
            System.out.println("end ...");
            System.out.println("전체 처리 시간 : "+watch.getTotalTimeMillis());
        }
    }
}
