package Exceptions;

class Sample2{
    public void prt(int num) throws UserException{
        if(num<0)
            throw new UserException("num이 0보다 작다");
        System.out.println(num);
    }
}
public class REThrowMain {
    public static void main(String[] args){
        Sample2 s2 = new Sample2();
        try {
            s2.prt(0);
            s2.prt(-10);
        } catch (UserException e){
            System.out.println(e);
        }

    }
}
