package APIs;

import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

public class SystemMain {
    public static void main(String[] args) {
        PrintStream ps = System.out;
        ps.print(new Date());
        ps.printf("%s\t %d\t %o\n","hong",10,10);

        for(int i=0; i<10; i++)
            //현재 시간을 1/1000 초(ms)로 알려줌
            System.out.println(System.currentTimeMillis());

        //arrayCopy()
        int[] source = new int[10];
        source[0] = 10;
        source[1] = 20;
        source[2] = 30;
        int[] target = new int[10];
        target[0] = 100;
        target[1] = 200;
        target[2] = 300;
        target[3] = 400;

        for(int i:source){
            System.out.printf("%d\t",i);
        }
        System.out.println();
        for(int i:target){
            System.out.printf("%d\t",i);
        }
        System.out.println();
        //source 1번째 부터 복사를 시작해 target 6번째에 붙여넣는다 2개를
        System.arraycopy(source,1,target,6,2);
        for(int i:target){
            System.out.print(i+"\t");
        }

        //exit()
        System.out.println();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("계속 입력?");
            String yn = sc.nextLine();
            if(!"y".equals(yn))
                System.exit(0);
        }
    }
}
