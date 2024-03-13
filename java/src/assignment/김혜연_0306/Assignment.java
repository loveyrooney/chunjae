

import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Q1-for
        System.out.println("숫자를 입력하시오");
        int num = Integer.parseInt(sc.nextLine());
        String s1 = "1 ";
        float d1 = 1f;
        for(int i=2; i<=num; i++){
            if(i%2==0) {
                d1 -= 1f/i;
                s1 += "-1/"+i+" ";
            } else {
                d1 += 1f/i;
                s1 += "+1/"+i+" ";
            }
        }
        System.out.printf("for문 : %s = %f\n",s1,d1);

        //Q1-while
        int wi = 1;
        String ws1 = "1 ";
        float wd1 = 1f;
        while(wi<num){
            wi++;
            if(wi%2==0){
                wd1 -= 1f/wi;
                ws1 += "-1/"+wi+" ";
            } else {
                wd1 += 1f/wi;
                ws1 += "+1/"+wi+" ";
            }
        }
        System.out.printf("while문: %s = %f\n",ws1,wd1);

        //Q2
        System.out.println("숫자를 입력하시오");
        int num2 = Integer.parseInt(sc.nextLine());
        int sum = 0;
        String s2 = "";
        for(int i=1; i<=num2; i++) {
            sum += i;
            s2 += i+" ";
        }
        System.out.printf("%s\n",s2);
        System.out.printf("합계: %d\n",sum);

        //Q3
        System.out.println("숫자를 입력하시오");
        int num3 = Integer.parseInt(sc.nextLine());
        int sum2 = 1;
        String s3 = "1";
        for(int i=2; i<=num3; i++){
            if(i%2==0){
                sum2 -= i;
                s3 += "-"+i;
            } else {
                sum2 += i;
                s3 += "+"+i;
            }
        }
        System.out.printf("%s = %d",s3,sum2);
    }
}
