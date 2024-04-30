package com.chunjae.list;

import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> items;
    private Jumsu jumsu;

    public Student(String name, int age, Jumsu jumsu) {
        this.name = name;
        this.age = age;
        this.jumsu = jumsu;
    }

    public Student(List<String> items) {
        this.items = items;
    }

    public void prt_studentList(){
        for(String i:items){
            System.out.println(i);
        }
    }

    public void prt_student(){
        System.out.printf("name: %s ",name);
        System.out.printf(", age : %d\n",age);
        System.out.printf("kor : %d ",jumsu.getKor());
        System.out.printf(", eng : %d ",jumsu.getEng());
        System.out.printf(", math: %d\n",jumsu.getMath());
    }
}
