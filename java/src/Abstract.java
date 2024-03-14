/* 추상 클래스 : 객체를 생성하지 못하는 클래스
추상 클래스에는 일반 클래스에 있는 내용이 다 있을 수 있다.
추상 메서드가 있는 클래스는 추상 클래스여야 한다. (추상 클래스에는 추상 메서드가 있어야 한다 x)
그러나 객체를 만들지 못하므로 추상 클래스를 상속 받은 자식 클래스를 통해 구현할 수 있다.
*/

abstract class Lives{
    public abstract void isLive();
}

abstract class Animal extends Lives{
    private String name;
    private int age;
    //추상클래스에서 생성자를 사용하는 이유는 변수를 한꺼번에 초기화 하기 위해서.
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void move(){
        System.out.println("move");
    }
    @Override
    public void isLive(){
        System.out.println("yes");
    }
    //자식 클래스마다 모두 다른 내용의 경우에는 추상 메서드
    public abstract void sound();
    //자식 클래스에서 달라지는 몇 가지 경우가 있을 때는 오버라이딩
    public void isWild(){
        System.out.println("yes");
    }

    //public abstract int leg();
}

class Dog extends Animal{

    public Dog(String name, int age){
        super(name, age);
    }
    @Override //추상 메서드의 오버라이딩
    public void sound(){
        System.out.println("bark");
    }

    @Override //일반 메서드의 오버라이딩
    public void isWild(){
        System.out.println("no");
    }
    /* Animal에 leg를 여기서 오버라이딩 하지 않는경우, Dog도 여전히 추상클래스가 된다.
    즉, 추상 클래스를 상속 받는 클래스가 일반 클래스가 되려면, 추상 클래스의 모든 추상 메서드를 오버라이딩 해야 함.
    Lives는 isLive()라는 요소영역 외의 부분이 불투명한 레이어라고 했을 때, isLive()는 그 하위 레이어의 내용이 비춰지게 된다.
    만약 하위 레이어 역시 투명한 레이어라면, 비춰지는 것이 없다. 그래서 몇 개의 투명 레이어가 있든 실체가 있는 요소가 반드시 하나 있어야 한다.
    isLive()가 Animal에서도 추상 메서드라면, Dog에서 실체를 구현해야 한다.
    한편 Lives라는 레이어로는 그 아래 레이어에 있는 isWild()라는 요소영역에 대해서는 볼 수 없다.
    */
}

class Cat extends Animal {
    public Cat(String name, int age){
        super(name, age);
    }
    @Override
    public void sound() {
        System.out.println("miao");
    }
}

public class Abstract {
    public static void main(String[] args) {
        //추상 클래스는 인스턴스를 생성할 수 없다.
        //Animal a1 = new Animal();
        Animal dog = new Dog("dog",2);
        dog.sound();
        Animal cat = new Cat("cat",3);
        cat.sound();
        //추상 메서드의 동작 방식은 구현체마다 같지만, 추상 메서드의 내용은 구현체마다 다르게 구현된다 : 다형성

    }
}
