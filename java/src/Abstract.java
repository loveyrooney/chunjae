/* 추상 클래스 : 객체를 생성하지 못하는 클래스
추상 클래스에는 일반 클래스에 있는 내용이 다 있을 수 있다. (추상 메서드만 갖는 것 x)
그러나 객체를 만들지 못하므로 추상 클래스를 상속 받은 자식 클래스를 통해 구현할 수 있다.
*/
abstract class Animal{
    public void move(){
        System.out.println("move");
    }
    //자식 클래스마다 모두 다른 내용의 경우에는 추상 메서드
    //추상 메서드는 구현체마다 다르게 구현된다 : 다형성
    public abstract void sound();
    //자식 클래스에서 달라지는 몇 가지 경우가 있을 때는 오버라이딩
    public void isWild(){
        System.out.println("yes");
    }
}

class Dog extends Animal{
    @Override //추상 메서드의 오버라이딩
    public void sound(){
        System.out.println("bark");
    }

    @Override //일반 메서드의 오버라이딩
    public void isWild(){
        System.out.println("no");
    }
}

class Cat extends Animal {
    @Override
    public void sound(){
        System.out.println("miao");
    }
}

public class Abstract {
    public static void main(String[] args) {
        //추상 클래스는 인스턴스를 생성할 수 없다.
        //Animal a1 = new Animal();
        Animal dog = new Dog();
        dog.sound();
        Animal cat = new Cat();
        cat.sound();

    }
}
