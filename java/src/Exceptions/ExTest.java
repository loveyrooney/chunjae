package Exceptions;

import java.util.Scanner;

class Calc{
    public double getSum(int data) throws InvalidException{
        if(data>5 || data<2)
            throw new InvalidException("입력 값에 오류가 있습니다.");
        double result = 0;
        for(int i=1; i<=data; i++)
            result += i;
        return result;
    }
}

class InvalidException extends Exception{
    public InvalidException(String msg){
        super(msg);
    }
}
public class ExTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calc c = new Calc();
        try {
            System.out.println("input num");
            double result = c.getSum(Integer.parseInt(sc.nextLine()));
            System.out.println(result);
        } catch (InvalidException e){
            System.out.println(e.getMessage());
        } catch (Exception e){  //여기서 다른 경우의 exception 까지 처리하든지 아니면 main 옆에 throws Exception
            System.out.println(e);
        }
    }
}
