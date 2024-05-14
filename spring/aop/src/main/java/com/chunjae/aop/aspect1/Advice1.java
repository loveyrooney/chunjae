package com.chunjae.aop.aspect1;
/*
   AOP, Aspect Oriented Programming
   advisor : advice + joinPoint
   advice : 해당 aspect 상황에 동작할 메서드들이 있는 클래스
   joinPoint : 해당 aspect 상황에 특정 범위에(execution) 동작하도록 연결
   bean 에 init-method, destroy-method 를 지정하는 것은 bean 의 생성 주기와 관련있고,
   aop advice 는 사용자의 관점에 따라 같은 메서드를 매 bean 마다 적용하는 게 아니라 한번에 지정해서 적용할 수 있다는 것과 관련있다.
*/

public class Advice1 {
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }
    public void after1(Throwable ex){
        System.out.println("after throwable");
        System.out.println(ex);
    }
    public void after2(Object o){
        System.out.println("after returning advice");
        System.out.println(o);
    }
}
