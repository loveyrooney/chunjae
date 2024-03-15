package APIs;

import java.util.Objects;

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override // alt + insert 에서 사용시 자동으로 만들어 준다.
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public boolean equals(Object o){
//        if(o==null) return false;
//        else if(o instanceof Person) {
//            Person p = (Person)o;
//            return name.equals(p.name) && age == p.age;
//        } else return false;
//    }

//    alt + insert 에서 equals() and hashcode() 선택 시
    @Override //같은 클래스에서 만든 인스턴스의 모든 필드 값이 같은지를 알아보는 여부로 재정의 (중복된 객체 탐지 기능)
    public boolean equals(Object o) {
        if (this == o) return true; //객체가 같으면 항상 같음
        if (o == null || getClass() != o.getClass()) return false; //객체가 널이거나 클래스가 다르면 항상 다름
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name); //
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class ObjectMain {
    public static void main(String[] args) {
        Person p1 = new Person("hong",20);
        Object p2 = new Person("hong",20);
        Person p3 = new Person("hong",20);

        //toString()
        System.out.println(p1); //인스턴스에서 자동으로 toString() 호출
        System.out.println(p1.toString());

        //equals()
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(new Person("hong",20)));
        System.out.println(p1.equals(p3));
        System.out.println(p1==p3);
        System.out.println(p1.toString()==p3.toString());


    }
}
