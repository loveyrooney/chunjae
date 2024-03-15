/* interface
카테고리가 같지 않은(부모가 다른) 각각의 인스턴스에서 같은 기능을 상속받아 사용하고 싶을 때
인터페이스의 모든 메서드는 추상메서드이고, 어떤 영역이든 접근이 가능해야 한다. public abstract을 생략하고 작성할 수 있다.
인터페이스의 모든 변수는 정적 상수이다. public static final을 생략하고 작성할 수 있다. (선언과 초기화를 모두 해야함)
static block, 생성자 사용 불가(생성자로 변수 초기화 불가), 객체 생성 불가
다중 상속 가능
*/

interface Able{

}

//인터페이스끼리 상속은 extends
interface Flyable extends Able{

    //public static final 상수는 대문자로 표기한다.
    String KINDS = "kinds";
    void fly();
    //공통된 기능은 default 명령어를 달고 구현부를 작성할수 있다.
    default void move(){
        System.out.println("move");
    }
}

interface Workable{
    void work();
    default void prt(){
        System.out.println("workable prt");
    }
    static void view(){
        System.out.println("workable static view");
    }
}

class User implements Flyable, Workable {
    @Override
    public void fly() {
        System.out.println("you can fly");
    }

    @Override
    public void work() {
        System.out.println("you can work");
    }
}

public class Interface1 {
    public static void main(String[] args) {
        Workable.view();

        // 익명 클래스 : 인스턴스마다 메서드의 내용이 달라져야 할 때, 그 객체만을 위한 클래스를 만드는 것
        Workable frontend = new Workable() {
            @Override
            public void work() {
                System.out.println("frontend");
            }
        };
        Workable backend = new Workable() {
            @Override
            public void work() {
                System.out.println("backend");
            }
        };
        frontend.work();
    }
}
