import java.util.ArrayList;

class Person1{
    private String name;
    public Person1() {
    }
    public Person1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student2 extends Person1{

}
class Gen1{
    //아래와 같이 쓰면, Person1의 자손 단계에 있는 객체는 이 메서드를 쓸수가 없게 된다.
    //public Person1 void prt(ArrayList<Person1> person1s){}

    //그래서 앞으로 Person1의 자손이 될 모든 객체가 이 메서드를 쓸수 있도록 가능성을 열어 주는 것.
    public <T extends Person1> void prt(ArrayList<T> person1s){

    }


}
public class Generic {
    public static void main(String[] args) {
        Gen1 g = new Gen1();
        ArrayList<Student2> s = new ArrayList<>();
        s.add(new Student2());
        g.prt(s);
    }
}
