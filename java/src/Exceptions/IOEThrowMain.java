package Exceptions;

import java.io.IOException;

class Sample{
    //num이 5보다 작으면 예외 발생
    //try catch를 쓰면 throw 이하가 던진 예외를 catch 블록에서 받는다.
    public void prt(int num) {
        try {
            System.out.println("hi prt");
            if(num<5) {
                System.out.println("메서드 내에서 해결");
                throw new IOException("num은 5보다 작다");
            }
            System.out.println(num);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    //num이 0보다 작으면 예외 발생
    //throws 를 쓰면 throw 이하가 던진 예외를 Exception 한테 미룬다.
    public void prt2(int num) throws IOException {
        System.out.println("hi prt");
        if(num<0)
            throw new IOException("num은 0보다 작다");
        System.out.println(num);
    }
    public void prt3(int num) throws CustomIOException {
        System.out.println("hi prt");
        if(num<0)
            throw new CustomIOException("num은 0보다 작다");
        System.out.println(num);
    }
}
public class IOEThrowMain {
    public static void main(String[] args) throws IOException {
        Sample s = new Sample();
        s.prt(4);
        try {
            s.prt2(-1);
        } catch (IOException e){
            System.out.println("메서드 호출하는 곳에서 해결");
            System.out.println(e);
        }
        s.prt3(-5); //CustomIOException 으로 던지는 것
        s.prt2(-10); //java.lang.IOException 으로 던지는 것

    }

}
