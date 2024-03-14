package APIs;

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
        System.out.println(p1.equals(new Person("hong",10)));
        System.out.println(p1.equals(p3));


    }
}
