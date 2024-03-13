import java.util.Scanner;

class Cal{
    int add(int a,int b){
        return a+b;
    }
    int sub(int a, int b){
        return a-b;
    }
    int mul(int a, int b){
        return a*b;
    }
    String div(int a, int b){
        String result;
        if(b==0)
            result = "0으로 나눌 수 없습니다.";
        else if(a%b !=0)
            result = ((float)a/b)+"";
        else
            result = (a/b)+"";
        return  result;
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cal c = new Cal();

        System.out.println("수1");
        int su1 = Integer.parseInt(sc.nextLine());
        System.out.println("수2");

        int su2 = Integer.parseInt(sc.nextLine());
        int add = c.add(su1,su2);
        int sub = c.sub(su1,su2);
        int mul = c.mul(su1,su2);
        String div = c.div(su1,su2);

        System.out.printf("%d + %d = %d\n",su1,su2,add);
        System.out.printf("%d - %d = %d\n",su1,su2,sub);
        System.out.printf("%d * %d = %d\n",su1,su2,mul);
        System.out.printf("%d / %d = %s",su1,su2,div);
    }
}
