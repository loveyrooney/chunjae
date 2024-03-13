import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("인원");
        int input = Integer.parseInt(sc.nextLine());
        if(input>10 || input<1){
            System.out.println("인원을 잘못 입력했습니다.");
        }
        String[] names = new String[10];
        int[] kors = new int[10];
        int[] engs = new int[10];
        int[] sums = new int[10];
        for(int i=0; i<=input-1; i++){
            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("국어");
            int kor = Integer.parseInt(sc.nextLine());
            System.out.println("영어");
            int eng = Integer.parseInt(sc.nextLine());
            names[i] = name;
            kors[i] = kor;
            engs[i] = eng;
            sums[i] = kor+eng;
        }
        int sum_t, kor_t, eng_t;
        String name_t;
        for(int i=0; i<=input-2; i++){
            for(int j=1; j<=input-1; j++){
                if(sums[i]==0)
                    break;
                if(sums[i]<sums[j]) {
                    sum_t = sums[i];
                    sums[i] = sums[j];
                    sums[j] = sum_t;
                    name_t = names[i];
                    names[i] = names[j];
                    names[j] = name_t;
                    kor_t = kors[i];
                    kors[i] = kors[j];
                    kors[j] = kor_t;
                    eng_t = engs[i];
                    engs[i] = engs[j];
                    engs[j] = eng_t;
                }
            }
        }
        System.out.println("이름\t 국어\t 영어\t 총점\t 평균\t 성취도\n");
        float avg;
        String grade;
        for(int i=0; i<names.length; i++){
            if(sums[i]==0)
                break;
            avg = sums[i]/2f;
            if(avg>=90)
                grade = "A";
            else if(avg>=80)
                grade = "B";
            else if(avg>=70)
                grade = "C";
            else if(avg>=60)
                grade = "D";
            else
                grade = "F";
            System.out.printf("%s\t %d\t %d\t %d\t %.1f\t %s\n",names[i],kors[i],engs[i],sums[i],avg,grade);
            avg = 0;
            grade = "";
        }
    }
}
