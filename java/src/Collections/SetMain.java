package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Person1{
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return age == person1.age && Objects.equals(name, person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class SetMain {
    public static void main(String[] args) {
        /* Set : Set interface 상속하여 만들어짐.
        순서 보장 x(index 없음, get()사용 x, iterator로 출력), 중복(동등성) 허용 x
        */

        HashSet<String> hs = new HashSet<>();
        hs.add("a1");
        hs.add("t1");
        hs.add("test");
        hs.add("hello");
        hs.add("a2");
        hs.add("a1"); //"a1" 은 문자열 상수라서 같은 객체이므로 중복을 허용하지 않음.
        hs.add(new String("a1")); //이것은 문자열 상수와 다른 객체이지만, equals와 hashcode가 같으면 중복으로 생각함.
        hs.add(null); //null 추가가 되긴 하지만 권장 x

        System.out.println(hs.size());

        //순서가 보장되지 않는 요소들은 열거형을 통해 나열할 수 있다.
        Iterator<String> ita = hs.iterator();
        while(ita.hasNext()){
            System.out.print(ita.next()+"\t");
        }

        System.out.println();
        System.out.println("-------------------------");
        HashSet<Person1> hs2 = new HashSet<>();
        hs2.add(new Person1("hong",20));
        hs2.add(new Person1("park",10));
        hs2.add(new Person1("hong",20)); //이거는 위에 있는 hong,20객체와 다른 객체이다.

        Iterator<Person1> ita2 = hs2.iterator();
        while(ita2.hasNext()){
            System.out.println(ita2.next());
        }
        // equals와 hascode 오버라이딩 하지 않으면 모두 다 다른 객체로 판단한다.

    }
}
