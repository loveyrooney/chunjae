package Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        /* Throwable class 의 자식은 error 와 exception 이 있다.
        error 는 프로그램으로 해결이 불가능한 문제. threadDeath, LinkageError, VirtualMachineError 등
        exception 은 프로그램으로 해결이 가능하다. (RuntimeException 과 RuntimeException 이 아닌 것으로 분류)
        Runtime 아닌 exception은 컴파일 과정에서 발생하는 예외, check Exception
        */

        //RuntimeException 이 아닌 Exception (ex IOException, SQLException, XMLParseException 등)
        InputStream is = System.in; //byte 단위로 입력받음
        InputStreamReader isr = new InputStreamReader(is);
        while(true){
            //try catch 문으로 처리하거나, 해당 익셉션이 일어나는 메서드 이름 뒤에 throws 해당익셉션명
            //exception의 명시가 없었던 경우는 익셉션이 일어나는 메서드에 throws Exception 이 생략되어 있는 경우이다.
            //exeption의 명시가 있기 시작하면 익셉션이 일어나는 메서드에 try catch나 throws 처리를 해 주어야 함.
            try{
                System.out.println("char");
                char ch = (char)isr.read(); //여기서 IOException 발생 가능성 있음
                if(ch=='.')
                    break;
                System.out.println(ch);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        //RuntimeException
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                System.out.println("exit");
                String exit = sc.nextLine();
                if(exit.equals("."))
                    break;
                System.out.println("number 1");
                int num1 = Integer.parseInt(sc.nextLine());
                System.out.println("number 2");
                int num2 = Integer.parseInt((sc.nextLine()));
                System.out.println(num1 / num2);
            } catch (NumberFormatException e){
                System.out.println(e);
                System.out.println(e.getMessage()); //가장 간단함. 빌드시에는 이정도로 한다.
                e.printStackTrace(); //어디서 에러가 났는지 구체적으로 보여줌. 보안문제 있어서 사용 안하는게 좋다.
            } catch (ArithmeticException e){
                System.out.println(e);
            }
            // catch (RuntimeException e) {
            //  System.out.println(e);
            // }
            //조상 익셉션 하나만으로 통합해서 사용해도 되고, 타겟 익셉션과 병행하려면 조상 익셉션을 가장 아래에 써야 한다.
            //조상 익셉션이 자손 익셉션보다 위에 있으면 컴파일 에러.
            finally {
                System.out.println("ok");
            }
        }





    }
}
