package assignment.kim0318;

import java.util.ArrayList;
import java.util.Scanner;

class StudentDTO{
    private String hak_no;
    private String name;
    private int age;

    public StudentDTO(String hak_no, String name, int age) {
        this.hak_no = hak_no;
        this.name = name;
        this.age = age;
    }

    public String getHak_no() {
        return hak_no;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class UserArray{
    public ArrayList<StudentDTO> arr = new ArrayList<>();
    public void addArr(StudentDTO s){
        arr.add(s);
        System.out.println("입력완료");
    }
    public void removeArr(String hak_no){
        int idx = searchHakNo(hak_no);
        arr.remove(arr.get(idx));
        System.out.println("삭제완료");
    }
    public void updateArr(String hak_no,int age){
        int idx = searchHakNo(hak_no);
        arr.get(idx).setAge(age);
        System.out.println("수정완료");
    }
    public int searchHakNo(String hak){
        for(StudentDTO i:arr){
            if(i.getHak_no().equals(hak))
                return arr.indexOf(i);
        }
        return 0;
    }
    public void prtOne(String hak_no){
        int idx = searchHakNo(hak_no);
        System.out.println("학번: "+arr.get(idx).getHak_no());
        System.out.println("이름: "+arr.get(idx).getName());
        System.out.println("나이: "+arr.get(idx).getAge());
    }
    public void prtAll(){
        System.out.println("학번\t 이름\t 나이");
        for(StudentDTO i:arr){
            System.out.printf("%s\t %s\t %d",i.getHak_no(),i.getName(),i.getAge());
            System.out.println();
        }
    }

}
public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserArray ua = new UserArray();
        while(true){
            System.out.println("1.입력 2.수정 3.삭제 4.조회 5.전체보기 6.종료");
            int input = Integer.parseInt(sc.nextLine());
            String hak_no;
            int age;
            if(input==1){
                while(true){
                    while(true){
                        System.out.println("1.입력");
                        System.out.println("학번을 입력하세요");
                        hak_no = sc.nextLine();
                        if(ua.searchHakNo(hak_no) !=0)
                            System.out.println("기존 학번이 있습니다.");
                        else
                            break;
                    }
                    System.out.println("이름을 입력하세요");
                    String name = sc.nextLine();
                    System.out.println("나이를 입력하세요");
                    age = Integer.parseInt(sc.nextLine());
                    ua.addArr(new StudentDTO(hak_no,name,age));
                    System.out.println("계속 입력할까요?");
                    if(!"y".equals(sc.nextLine()))
                        break;
                }
            } else if(input ==2){
                while(true){
                    System.out.println("2.수정");
                    System.out.println("수정할 학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(ua.searchHakNo(hak_no)==0) {
                        System.out.println("학번이 없습니다.");
                        System.out.println("계속 수정할까요?");
                        if(!"y".equals(sc.nextLine()))
                            break;
                    } else{
                        System.out.println("수정할 나이");
                        age = Integer.parseInt(sc.nextLine());
                        ua.updateArr(hak_no,age);
                        System.out.println("계속 수정하시겠습니까?");
                        if(!"y".equals(sc.nextLine()))
                            break;
                    }
                }
            } else if(input==3){
                while(true){
                    System.out.println("3.삭제");
                    System.out.println("삭제할 학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(ua.searchHakNo(hak_no)==0) {
                        System.out.println("학번이 없습니다.");
                        System.out.println("계속 삭제할까요?");
                        if(!"y".equals(sc.nextLine()))
                            break;
                    } else{
                        ua.removeArr(hak_no);
                        System.out.println("계속 삭제하시겠습니까?");
                        if(!"y".equals(sc.nextLine()))
                            break;
                    }
                }
            } else if(input==4){
                while(true){
                    System.out.println("3.조회");
                    System.out.println("조회할 학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(ua.searchHakNo(hak_no)==0) {
                        System.out.println("학번이 없습니다.");
                        System.out.println("계속 조회할까요?");
                        if(!"y".equals(sc.nextLine()))
                            break;
                    } else{
                        ua.prtOne(hak_no);
                        System.out.println("계속 조회하시겠습니까?");
                        if(!"y".equals(sc.nextLine()))
                            break;
                    }
                }
            } else if(input==5){
                while(true){
                    System.out.println("5.전체보기");
                    ua.prtAll();
                    System.out.println("다시 보시겠습니까?");
                    if(!"y".equals(sc.nextLine()))
                        break;
                }
            } else {
                System.out.println("6.종료");
                if("y".equals(sc.nextLine())) {
                    System.out.println("종료 완료");
                    break;
                }
            }

        }
    }
}
