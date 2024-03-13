import java.util.Scanner;

public class ifForWhile {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            System.out.println((Math.random()*3));
            //3보다 작은 난수, 자리수 조정하면 n보다 작은 양수의 범위를 랜덤으로 사용가능
        }
        System.out.println((int)0.003*100);

        /* 무한루프
        for( ; ; ){}
        while(true){}
        */

        //총합이 입력값 이하가 되도록 홀수합 구하기
        Scanner sc = new Scanner(System.in);
        System.out.println("num");
        int num = Integer.parseInt(sc.nextLine());
        int sum = 0;
        String r1 = "";
        //내가 푼 방식
        for(int i=1; ; i+=2){
            sum += i;
            r1 += i+" ";
            if(sum+i+2>num)     //해석해야 하는 새로운 작업을 하고, 그것을 검사한다
                break;
            /*  좀더 유지보수에 용이한 코드 방식
                sum += i;       //기존 작업을 한다
                if(sum > num)  //검사를 한다
                    sum -= i;   //작업을 undo 한다
                    break;
                r1 += i+" ";
            */
        }
        System.out.println(r1);
        System.out.println("총합: "+sum);

        //구구단 for문
        for(int i=1; i<10; i++){
            for(int j=2; j<6; j++){
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }

        //구구단 while문
        int k=1, l=2;
        while(k<10){
            while(l<6){
                System.out.print(l+"*"+k+"="+l*k+"\t");
                l++;
            }
            System.out.println();
            k++;
            l = 2;
        }



    }
}
