package assignment;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        //StudentDTO 라는 클래스 타입의 배열
        StudentDTO[] dto = new StudentDTO[10];
        Scanner sc = new Scanner(System.in);

        //StudentDTO에 입력받은 데이터 저장
        int i=0;
        for( ; i<dto.length; i++){
            System.out.println("input name");
            String name = sc.nextLine();
            System.out.println("input kor");
            int kor = Integer.parseInt(sc.nextLine());
            System.out.println("input eng");
            int eng = Integer.parseInt(sc.nextLine());
            dto[i] = new StudentDTO(name,kor,eng);
            dto[i].setSum(kor+eng);
            dto[i].setAvg((kor+eng)/2f);
            System.out.println("계속입력?");
            if(!"y".equals(sc.nextLine())) //equals를 쓸 때는 변수. 쓰지말고 문자열. 으로 쓴다.
                break;
        }

        //총점이 높은 순으로 정렬
        //temp의 타입이 뭐가 되어야 하고 그 타입은 primitive/reference 인지 생각할 것
        StudentDTO temp;
        for(int j=0; j<=i-1; j++){  //j의 범위는 배열의 length가 아니다.
            for(int k=1; k<=i; k++){
                if(dto[j].getSum()<dto[k].getSum()) {
                    temp = dto[j];
                    dto[j] = dto[k];
                    dto[k] = temp;
                }
            }
        }

        //출력
        System.out.printf("이름\t 국어\t 영어\t 총점\t 평균\t 성취도\n");
        for(int j=0; j<=i; j++){
            String grade = "";
            if(dto[j].getAvg()>=90)
                grade = "수";
            else if(dto[j].getAvg()>=80)
                grade = "우";
            else if(dto[j].getAvg()>=70)
                grade = "미";
            else if(dto[j].getAvg()>=60)
                grade = "양";
            else
                grade = "가";
            System.out.printf("%s\t %d\t %d\t %d\t %.1f\t %s\n",dto[j].getName(),dto[j].getKor(),dto[j].getEng(),dto[j].getSum(),dto[j].getAvg(),grade);
        }
    }
}
