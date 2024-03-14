
interface Inter1{
    void p1();
    default void p2(){
        System.out.println("Inter1 p2");
    }
    static void p3(){
        System.out.println("Inter1 static p3");
    }
}

interface Inter2{
    void interMethod1();
    default void interMethod2(){
        System.out.println("Inter2 interMethod2");
    }
}
abstract class Man{
    public abstract void t1();
    public void t2(){
        System.out.println("Man t2");
    }
    public void t3(){
        System.out.println("Man t3");
    }
}

class Man1 extends Man implements Inter1,Inter2{
    //추상 클래스에서 상속받은 메서드 오버라이딩
    @Override //추상 메서드
    public void t1() {
        System.out.println("Man1 t1 override");
    }
    @Override //일반 메서드
    public void t3() {
        System.out.println("Man1 t3 override");
    }

    //인터페이스에서 상속받은 메서드 오버라이딩
    @Override //Inter 1 추상 메서드
    public void p1() {
        System.out.println("Man1 p1");
    }
    @Override //Inter2 추상 메서드
    public void interMethod1() {
        System.out.println("Man1 interMethod1");
    }

    //Man1 인스턴스 메서드
    public void t4() {
        System.out.println("Man1 t4");
    }
}

public class InterfaceCast {
    public static void main(String[] args) {
        Man m = new Man1();
        //Man1 m = new Man(); 은 강제 형변환을 해도 불가능. Man이 추상클래스이기 때문.
        Inter1 m2 = new Man1(); //Inter1에 들어있는 함수만 사용가능
        m2.p1();

    }
}
