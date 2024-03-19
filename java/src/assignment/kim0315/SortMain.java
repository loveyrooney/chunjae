package assignment.kim0315;

import assignment.StudentDTO;

import java.util.Scanner;

class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentArr{
    private Student[] arr = new Student[5];
    private int count=0;

    public Student[] getArr() {
        return arr;
    }

    public void addArr(Student s, int c){
        if(c< arr.length) {
            arr[c] = s;
            count++;
        } else {
            System.out.println("추가 실패");
        }
    }

    public void sortAgeArr(){
        Student temp;
        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                if(arr[i].getAge()<arr[j].getAge()){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public void sortNameArr(){
        char LN_i, LN_j;
        Student temp;
        int nameLength;
        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                nameLength = Math.max(arr[i].getName().length(),arr[j].getName().length());
                for(int k=0; k<nameLength; k++) {
                    LN_i = arr[i].getName().charAt(k);
                    LN_j = arr[j].getName().charAt(k);
                    if((int)LN_i>(int)LN_j){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    } else if((int)LN_i<(int)LN_j)
                        break;
                }

            }
        }
    }

    //lecture
    public void sortNameArr2(){
        Student temp;
        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                int result = arr[i].getName().compareTo(arr[j].getName());
                    if(result>0){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
            }
        }
    }


//    출력은 main에서 하고 클래스에서 하지 않는다.
//    public void prt(){
//        System.out.println("이름\t 나이");
//        for(int i=0; i<count; i++){
//            System.out.println(arr[i].getName()+"\t"+arr[i].getAge());
//        }
//    }
}

public class SortMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentArr studentArr = new StudentArr();
        Student[] arr = studentArr.getArr();
        for(int i=0; i<arr.length; i++){
            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("나이");
            int age = Integer.parseInt(sc.nextLine());
            //여기서 객체를 만드는 것과 addArr()안에서 객체를 만드는 것의 차이 생각해 볼것
            Student s = new Student(name,age);
            studentArr.addArr(s,i);
        }

        //lecture
        while(true){
            System.out.println("1. ageDesc 2. nameAsc 3.exit");
            String ch = sc.nextLine();
            if("3".equals(ch)){
                System.out.println("종료합니다");
                break;
            } else if("2".equals(ch)){
                studentArr.sortNameArr2();
            } else
                studentArr.sortAgeArr();
            for(Student s:arr){
                System.out.println(s);
            }
        }


    }
}
