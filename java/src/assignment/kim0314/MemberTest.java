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
    private MemberDTO[] arr = new MemberDTO[10];
    public MemberDTO[] getArr() {
        return arr;
    }
}
public class MemberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberPro memberPro = new MemberPro();
        MemberDTO[] memberLists = memberPro.getArr();

        int i=0;
        while(true){
            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("나이");
            int age = Integer.parseInt(sc.nextLine());
            MemberDTO member = new MemberDTO(name,age);
            memberLists[i] = member;
            System.out.println("계속 입력?");
            if(!"y".equals(sc.nextLine()))
                break;
            i++;
        }

        System.out.println("이름\t 나이");
        for(int j=0; j<=i; j++){
            System.out.printf("%s\t %d\n",memberLists[j].getName(),memberLists[j].getAge());
        }
    }
}
