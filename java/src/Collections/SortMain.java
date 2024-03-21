package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person2 implements Comparable{
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //Comparable 상속을 받으면 compareTo 메서드를 override 해야 한다.
    //비교는 해당 객체와 매개변수 o 객체 사이에서 이루어진다.
    @Override
    public int compareTo(Object o) {
        int result;
        if(o instanceof Person2){
            Person2 p = (Person2) o;
            result = name.compareTo(p.name);
        } else
            throw new ClassCastException();
        return result;
    }
}

class Person3{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentSort implements Comparator<Person3>{
    //Comparator를 상속받는 경우 compare 메서드를 override 해야 한다.
    //비교 대상이 되는 클래스의 객체 2개가 매개변수로 들어오고 그들을 비교한다.
    @Override
    public int compare(Person3 o1, Person3 o2) {
        return -(o1.getAge()-o2.getAge());
    }
}
public class SortMain {
    public static void main(String[] args) {
        /* Comparable 은 비교를 원하는 클래스에 상속하고, Comparator 는 메서드 구현체 클래스를 따로 만들어 쓴다.
        Comparator 구현체 클래스는 메서드 오버라이드한 것만 존재하는 클래스로 두고 쓰는 것이 좋다.
        Collections.sort()의 매개변수는 List<> 로 하자.
        */
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(5);
        data.add(10);
        data.add(56);
        data.add(2);

        //그냥 출력
        for (Integer datum : data)
            System.out.print(datum + " ");
        System.out.println();
        System.out.println("--------------------");

        //소트 후 출력
        Collections.sort(data);
        for(int i:data)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("--------------------");

        //객체 타입
        ArrayList<Person2> arr = new ArrayList<>();
        arr.add(new Person2("hong",20));
        arr.add(new Person2("park",20));
        arr.add(new Person2("kim",10));
        arr.add(new Person2("lee",25));
        for(Person2 p:arr)
            System.out.println(p);

        //Comparable 활용 sort (해당 객체 클래스 안에 Comparable 상속, compareTo 메서드로 sort)
        System.out.println("--------------------");
        Collections.sort(arr);
        for(Person2 p:arr)
            System.out.println(p);

        System.out.println("--------------------");
        ArrayList<Person3> arr2 = new ArrayList<>();
        arr2.add(new Person3("hong",20));
        arr2.add(new Person3("park",29));
        arr2.add(new Person3("kim",10));
        arr2.add(new Person3("lee",60));

        //Comparator 활용 sort (Comparator 역할을 하는 새로운 클래스에 compare 메서드로 sort)
        Collections.sort(arr2,new StudentSort());
        //arr2.sort(new StudentSort());
        //ArrayList 에는 sort 메서드가 있으므로 이렇게 쓸 수도 있다.
        for(Person3 p:arr2)
            System.out.println(p);
    }
}
