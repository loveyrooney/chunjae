import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Person1{
    private String name;
    private int age;
    public Person1() {
    }
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
}
class Student2 extends Person1{
    private String hak_no;
    public Student2(String name, int age, String hak_no){
        super(name,age);
        this.hak_no = hak_no;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
            .append(", Student2")
            .append("{hak_no= '"+hak_no+"'}");
        return sb.toString();
    }
}
class Gen1{
    /* 아래와 같이 쓰면, Person1의 자손 단계에 있는 객체는 이 메서드에 매개변수로 들어올 수 없다.
    매개변수도 리턴도 Person1 타입만 가능
    public Person1 void prt(ArrayList<Person1> person1){}

    그래서 앞으로 Person1의 자손이 될 모든 객체가 이 메서드에 매개변수로 들어올 수 있도록 해 주는 것.
    매개변수와 리턴에 Person1과 그의 자손들 타입이 가능
    public <T extends Person1> void prt(ArrayList<T> o){}
    */

    //한 단계 더 나아가 형변환과 함께 쓸 수 있다.
    public <T extends Person1> void prt(List<T> o){
        System.out.println("Gen prt");
        for(int i=0; i<o.size(); i++){
            System.out.println(o.get(i));
        }
    }
    //public void prt(List<? extends Person1> o){}
    //이렇게 써도 똑같지만 위 버전을 더 많이 쓴다.

}
public class Generic {
    public static void main(String[] args) {
        //제네릭 : 자료구조 안에 어떤 타입을 넣을 것인가를 정해주는 꺽쇠, 꺽쇠 안에는 원시 타입이 들어갈 수 없다.
        Gen1 g = new Gen1();
        ArrayList<Student2> s = new ArrayList<>();
        s.add(new Student2("hong",10,"1111"));

        System.out.println(s);
        g.prt(s);

        HashSet<? extends Person1> s2 = new HashSet<>();

    }
}
