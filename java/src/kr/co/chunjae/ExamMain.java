package kr.co.chunjae;  //패키지 이름은 보통 도메인으로 만든다. ko.co.chunjae

import assignment.Sample1; //다른 패키지에 있을 때 import

public class ExamMain {
    public static void main(String[] args) {
        //패키지 연습 Sample1
        Sample1 s = new Sample1();
        s.prt();

        //문제 풀이 Sample
        int[] arr = {10,20,30};
        Sample ins = new Sample();
        arr = ins.calDouble(arr);
        ins.prt(arr);




    }
}
