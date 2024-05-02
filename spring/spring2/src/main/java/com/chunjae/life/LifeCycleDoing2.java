package com.chunjae.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleDoing2 implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy method call");
    }
    public void a1(){
        System.out.println("a1");
    }
    public void b1(){
        System.out.println("b1");
    }
    public void prt(){
        System.out.println("life2 prt");
    }

    public void view(){
        System.out.println("life2 view");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet method call");
    }
}
