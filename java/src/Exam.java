import java.util.Arrays;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("name");
//        String name = sc.nextLine();
//        System.out.println("kor");
//        int kor = Integer.parseInt(sc.nextLine());
//        System.out.println("eng");
//        int eng = Integer.parseInt(sc.nextLine());
//        System.out.println("math");
//        int math = Integer.parseInt(sc.nextLine());
//
//        System.out.printf("이름: %s\n",name);
//        System.out.printf("국어: %d\n",kor);
//        System.out.printf("영어: %d\n",eng);
//        System.out.printf("수학: %d\n",math);
//        System.out.printf("총점: %d\n",kor+eng+math);
//        System.out.printf("평균: %.1f\n",(kor+eng+math)/3f); //float type
//        System.out.printf("%f\n",(kor+eng+math)/3.0); //double type
//
//        System.out.print("이름\t 국어\t 영어\t 수학\t 총점\t 평균\n");
//        System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\n", name,kor,eng,math,kor+eng+math,(kor+eng+math)/3f);


//        System.out.println("name");
//        String name = sc.nextLine();
//        System.out.println("age");
//        int age = Integer.parseInt(sc.nextLine());
//        System.out.println((age>=20)?name+","+age+",성년":name+","+age+",미성년");


//        System.out.println("num1");
//        int num1 = Integer.parseInt(sc.nextLine());
//        System.out.println("num2");
//        int num2 = Integer.parseInt(sc.nextLine());
//        System.out.println("num3");
//        int num3 = Integer.parseInt(sc.nextLine());
//        int max = (num1>=num2) ? num1:num2;
//        max = (max>=num3)?max:num3;
//        int min = (num1<=num2) ? num1:num2;
//        min = (min<=num3)?min:num3;
//        System.out.println(max+","+min);


//        System.out.println("name");
//        String name = sc.nextLine();
//        System.out.println("kor");
//        int kor = Integer.parseInt(sc.nextLine());
//        System.out.println("eng");
//        int eng = Integer.parseInt(sc.nextLine());
//        System.out.println("math");
//        int math = Integer.parseInt(sc.nextLine());
//        String result = "";
//
//        if(kor<90 && eng<90 && math<90)
//            result = "bad";
//        else if (kor>=90 && eng>=90 && math>=90)
//            result = "excellent";
//        else
//            result = "good";
//
//        System.out.println("이름:"+name);
//        System.out.println("국어:"+kor+", 영어:"+eng+", 수학:"+math);
//        System.out.println("성취도:"+result);


//        System.out.println("score");
//        int score = Integer.parseInt(sc.nextLine());
//        if(score<0 || score>100)
//            System.out.println("점수를 잘못 입력했습니다.");
//        else {
//            //switch 문에 들어가는 값은 byte,short, char,int, String, enum만 가능
//            switch (score/10){
//                case 10:
//                    System.out.println("점수:"+score);
//                    System.out.println("학점: A+");
//                    break;
//                case 9:
//                    System.out.println("점수:"+score);
//                    System.out.println("학점: A");
//                    break;
//                case 8:
//                    System.out.println("점수:"+score);
//                    System.out.println("학점: B");
//                    break;
//                case 7:
//                    System.out.println("점수:"+score);
//                    System.out.println("학점: C");
//                    break;
//                case 6:
//                    System.out.println("점수:"+score);
//                    System.out.println("학점: D");
//                    break;
//                default:
//                    System.out.println("점수:"+score);
//                    System.out.println("학점: F");
//            }


//        System.out.println("name");
//        String name = sc.nextLine();
//        System.out.println("kor");
//        int kor = Integer.parseInt(sc.nextLine());
//        System.out.println("eng");
//        int eng = Integer.parseInt(sc.nextLine());
//        System.out.println("math");
//        int math = Integer.parseInt(sc.nextLine());
//
//        int sum = kor+eng+math;
//        float avg = sum/3f; // (float)sum/3
//        String result = "";
//        if(avg>=90)
//            result = "수";
//        else if (avg>=80)
//            result = "우";
//        else if (avg>=70)
//            result = "미";
//        else if (avg>=60)
//            result = "양";
//        else
//            result ="가";
//
//        System.out.println("이름: "+name);
//        System.out.println("국어: "+kor);
//        System.out.println("영어: "+eng);
//        System.out.println("수학: "+math);
//        System.out.println("총점: "+sum);
//        System.out.printf("평균: %.1f\n",avg);
//        System.out.println("성취도: "+result);


//        for(int i=5; i<11; i++)
//            System.out.print(i+" ");
//        System.out.println();
//        for(int i=10; i>4; i--)
//            System.out.print(i+" ");
//        System.out.println();
//        System.out.println("start");
//        int start = Integer.parseInt(sc.nextLine());
//        System.out.println("end");
//        int end = Integer.parseInt(sc.nextLine());
//        int temp = 0;
//        if(start>end) {
//            temp = end;
//            end = start;
//            start = temp;
//        }
//        for(int i=start; i<=end; i++)
//            System.out.print(i+" ");


//        System.out.println("number");
//        int num = Integer.parseInt(sc.nextLine());
//        int r = 1;
//        String r2 = "";
//        for(int i=num; i>0; i--) {
//            r *= i;
//            if (i > 1)
//                r2 += i+"*";
//            else
//                r2 += i+"=";
//        }
//        System.out.printf("%d! = %s%d",num,r2,r);

//        System.out.println("su");
//        int su = Integer.parseInt(sc.nextLine());
//        for(int i=3; i<=su; i+=3)
//            System.out.printf("%d\t",i);

//        int i=1;
//        while(i<=9){
//            System.out.printf("%d ",i);
//            i+=2;
//        }

//        int i=1;
//        int odd = 0;
//        int even = 0;
////        for( ; i<=10; i++){
////            if(i%2==0)
////                even += i;
////            else
////                odd += i;
////        }
//
//        while(i<=10){
//            if(i%2==0)
//                even += i;
//            else
//                odd += i;
//            i++;
//        }
//        System.out.printf("even: %d, odd: %d, sum: %d\n",even,odd,even+odd);

//        for(int i=1; i<=3; i++){
//            for(int j=1; j<=4; j++){
//                System.out.print("*\t");
//            }
//            System.out.println();
//        }

//        System.out.println("depth");
//        int depth = Integer.parseInt(sc.nextLine());
////        for(int i=1; i<=depth; i++){
////            for(int j=1; j<=i; j++){
////                System.out.print("* ");
////            }
////            System.out.println();
////        }
//        int i=1, j=1;
//        while(i<=depth){
//            while(j<=i){
//                System.out.print("* ");
//                j++;
//            }
//            System.out.println();
//            i++;
//            j = 1;
//        }

//        for(int i=1; i<=depth; i++){
//            for(int j=1; j<=depth; j++){
//                if(j<=depth-i)
//                    System.out.print(" ");
//                else
//                    System.out.print("*");
//            }
//            System.out.println();
//        }

//        int i=1, j=1;
//        while(i<=depth){
//            while (j<=depth){
//                if(j<=depth-i)
//                    System.out.print(" ");
//                else
//                    System.out.print("*");
//                j++;
//            }
//            System.out.println();
//            i++;
//            j=1;
//        }

//        for(int i=1; i<=depth; i++){
//            for(int j=1; j<=depth; j++){
//                if(j%2==0)
//                    System.out.print("-");
//                else
//                    System.out.print("+");
//            }
//            System.out.println();
//        }

//        int r = 1;
//        for(int i=1; i<=depth; i++){
//            for(int j=1; j<=i; j++){
//                System.out.print(r+"\t");
//                r += 2;
//            }
//            System.out.println();
//        }

//        if(depth%2!=0)
//            depth += 1;
//        int turn = depth/2;
//        for(int i=1; i<=turn; i++){
//            for(int j=1; j<=i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for(int i=turn+1; i<depth; i++){
//            for(int j=1; j<=depth-turn; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//
//        for(int i=depth; i>=1; i--){
//            for(int j=1; j<=depth; j++){
//                if(j>depth-i)
//                    System.out.print("* ");
//                else
//                    System.out.print("  ");
//            }
//            System.out.println();
//        }

//        int input = 0, price=0;
//        int account = 0;
//        while(true){
//            System.out.println("-------------------------------");
//            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//            System.out.println("-------------------------------");
//            input = Integer.parseInt(sc.nextLine());
//
//            if(input==1) {
//                System.out.println("price");
//                price = Integer.parseInt(sc.nextLine());
//                account += price;
//                System.out.printf("예금액> %d\n",price);
//                if(account>=0)
//                    System.out.printf("잔고> %d\n",account);
//                else
//                    System.out.println("잔고> 잔고부족");
//            } else if (input ==2){
//                System.out.println("price");
//                price = Integer.parseInt(sc.nextLine());
//                if(account-price>=0) {
//                    account -= price;
//                    System.out.printf("출금액> %d\n", price);
//                    System.out.printf("잔고> %d\n", account);
//                } else {
//                    System.out.printf("출금 요청액> %d (잔고부족으로 처리불가)\n", price);
//                    System.out.printf("잔고> %d\n", account);
//                }
//            } else if(input==3){
//                System.out.printf("잔고> %d\n",account);
//            } else {
//                System.out.println("프로그램을 종료합니다.");
//                break;
//            }
//        }

//        int[] scores = new int[3];
//        System.out.println("input");
//        for(int i=0; i<scores.length; i++){
//            scores[i] = Integer.parseInt(sc.nextLine());
//        }
//        for(int i=0; i<scores.length; i++){
//            System.out.println(scores[i]);
//        }

//        System.out.println("input");
//        int input = Integer.parseInt(sc.nextLine());
//        int[] score = new int[input];
//        for(int i=0; i<score.length; i++){
//            System.out.println("score");
//            score[i] = Integer.parseInt(sc.nextLine());
//        }
//        for(int i=0; i<score.length; i++){
//            System.out.println(score[i]);
//        }

//        System.out.println("N");
//        int N = Integer.parseInt(sc.nextLine());
//        int[] score = new int[N];
//        int sum = 0;
//        for(int i=0; i<N; i++){
//            System.out.println("score");
//            score[i] = Integer.parseInt(sc.nextLine());
//            sum += score[i];
//        }
//        for(int i=0; i<N; i++){
//            System.out.println(score[i]);
//        }
//        System.out.println(sum);



    }
}
