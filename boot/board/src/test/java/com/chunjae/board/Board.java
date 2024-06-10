package com.chunjae.board;

public class Board {
    private String name;
    private int age;

    public Board(){

    }

    public Board(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
