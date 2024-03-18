package assignment.kim0315;

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
}

class StudentArr{
    public Student[] arr = new Student[5];
    private int count=0;

    public void addArr(Student s,int c){
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

    public void prt(){
        System.out.println("이름\t 나이");
        for(int i=0; i<count; i++){
            System.out.println(arr[i].getName()+"\t"+arr[i].getAge());
        }
    }
}

public class SortMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentArr studentArr = new StudentArr();
        for(int i=0; i<studentArr.arr.length; i++){
            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("나이");
            int age = Integer.parseInt(sc.nextLine());
            Student s = new Student(name,age);
            studentArr.addArr(s,i);
        }
        studentArr.sortAgeArr();
        studentArr.prt();
        studentArr.sortNameArr();
        studentArr.prt();
    }
}
