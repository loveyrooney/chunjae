package assignment.kim0314;

import java.util.Scanner;

class MemberDTO{
    private String name;
    private int age;
    public MemberDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

}
class MemberPro{
    private MemberDTO[] arr = new MemberDTO[3];
    private int counter = 0;

    //    public MemberDTO[] getArr() {
//        return arr;
//    }
    public boolean addMember(MemberDTO member){
        if(counter< arr.length){
            arr[counter] = member;
            counter++;
            return true;
        } else
            return false;
    }

    public void prtMember(){
        for(int i=0; i<counter; i++){
            System.out.printf("%s\t %d\n",arr[i].getName(),arr[i].getAge());
        }
    }

    public void sortDesc(){
        MemberDTO temp;
        for(int i=0; i<counter-1; i++){
            for(int j=1; j<counter; j++){
                if(arr[i].getAge() < arr[j].getAge()){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
public class MemberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberPro memberPro = new MemberPro();
        //MemberDTO[] memberLists = memberPro.getArr();

        int i=0;
        while(true){
//            if(i==3)
//                break;
            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("나이");
            int age = Integer.parseInt(sc.nextLine());
            MemberDTO member = new MemberDTO(name,age);
            if(memberPro.addMember(member)) {
                System.out.println("추가 성공");
                System.out.println("계속 입력?");
                if(!"y".equalsIgnoreCase(sc.nextLine()))
                    break;
            } else {
                System.out.println("추가 실패");
                break;
            }
            //memberLists[i] = member;
            i++;
        }

        memberPro.sortDesc();
        memberPro.prtMember();
//        System.out.println("이름\t 나이");
//        for(int j=0; j<=i; j++){
//            System.out.printf("%s\t %d\n",memberLists[j].getName(),memberLists[j].getAge());
//        }


    }
}
