package com.chunjae.config;

import com.chunjae.life.LifeCycleDoing;
import com.chunjae.life.LifeCycleDoing2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeConfig {
    // 어노테이션 빈 생성도 마찬가지로 init 은 상속메서드가 우선, destroy 는 설정이 가장 마지막에 실행된다.
    @Bean(name="doing2", initMethod = "a1", destroyMethod = "b1")
    public LifeCycleDoing2 createDoing2(){
        return new LifeCycleDoing2();
    }
    @Bean(name="doing1", initMethod = "a", destroyMethod = "b")
    public LifeCycleDoing createDoing(){
        return new LifeCycleDoing();
    }



}
