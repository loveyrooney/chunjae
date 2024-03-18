package Collections;

import java.util.ArrayList;
import java.util.Scanner;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class ArrayListExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> personArr = new ArrayList<>();
        for(int i=0; i<3; i++){
            System.out.println("name");
            String name = sc.nextLine();
            System.out.println("age");
            int age = Integer.parseInt(sc.nextLine());
            personArr.add(new Person(name,age));
        }
        System.out.println("이름\t 나이");
        for(int i=0; i<personArr.size(); i++){
            System.out.printf("%s\t %d\n",personArr.get(i).getName(),personArr.get(i).getAge());
        }



    }
}
