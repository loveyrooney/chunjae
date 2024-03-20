package Collections;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;
        if(o instanceof Student){
            Student s = (Student) o;
            result = -(age-s.getAge());
            if(result==0){
                result = name.compareTo(s.getName());
            }
        } else
            throw new ClassCastException();
        System.out.println(name+((Student) o).getName()+result);
        return result;
    }

//    @Override
//    public int compareTo(Object o) {
//        int result = 100;
//        if(o instanceof Student){
//            Student s = (Student) o;
//            if(age<s.getAge())
//                result = 2;
//            else if(age==s.getAge() && name.compareTo(s.getName())>0)
//                result = 1;
//            else if(age==s.getAge() && name.compareTo(s.getName())==0)
//                result = 0;
//            else if(age==s.getAge() && name.compareTo(s.getName())<0)
//                result = -1;
//            else
//                result = -2;
//        } else
//            throw new ClassCastException();
//        System.out.println(name+((Student) o).getName()+result);
//        return result;
//    }


}
public class SortExam {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("kim",10));
        arr.add(new Student("kang",60));
        arr.add(new Student("park",50));
        arr.add(new Student("han",50));

        Collections.sort(arr);
        for(Student s:arr)
            System.out.println(s);
    }
}
