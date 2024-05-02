package com.chunjae.auto;
/* Autowire
byName : 프로퍼티 이름과 같은 이름을 갖는 빈 객체 설정
byType : 프로퍼티 타입과 같은 타입을 갖는 빈 객체 설정.
         xml 에서 타입이 같은 빈을 여러개 지정할 수 없다.
constructor : 생성자 파라미터 타입과 같은 타입을 갖는 빈 객체를 생성자에 전달.
              생성자는 여러 경우가 다 필요한거기 때문에 필요한 부분만 명시를 하는 것이 좋다.
 */

public class Autowire1 {
    private Info info1;
    private Info info2;

    public Autowire1() {
        System.out.println("Autowire1 constructor NoArgs ");
    }

    public Autowire1(Info info1, Info info2) {
        System.out.println("Autowire1 constructor AllArgs");
    }

    public Autowire1(Info info1,String s) {
        System.out.println("Autowire1 constructor args info1, string");
    }

    public void setInfo1(Info info1) {
        System.out.println("Autowire1 setter info1");
    }

    public void setInfo2(Info info2) {
        System.out.println("Autowire1 setter info2");
    }
    public void prt(){
        System.out.println("Autowire1 prt");
    }
}
