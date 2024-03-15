import java.util.Scanner;

class Cal2{
    void add(int a,int b){
        System.out.println("add: "+(a+b));
    }
    void sub(int a, int b){
        System.out.println("sub: "+(a-b));
    }
    void mul(int a, int b){
        System.out.println("mul: "+(a*b));
    }
    void div(int a, int b){
        if(b==0)
            System.out.println("0으로 나눌 수 없습니다.");
        else if(a%b !=0)
            System.out.println("div: "+((float)a/b));
        else
            System.out.println("div: "+(a/b));
    }
}
class ArrTest{
    void prt(String[] b){
        for(String a:b)
        System.out.println(a);
    }
}

class UserStudent{
    String hakno;
    String name;
    String addr;
    String tel;
    UserStudent(){}
    UserStudent(String hakno, String name, String tel){
        this.hakno = hakno;
        this.name = name;
        this.tel = tel;
    }
}

public class Console {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("수1");
//        int su1 = Integer.parseInt(sc.nextLine());
//        System.out.println("수2");
//        int su2 = Integer.parseInt(sc.nextLine());
//        Cal2 cal = new Cal2();
//        cal.add(su1,su2);
//        cal.sub(su1,su2);
//        cal.mul(su1,su2);
//        cal.div(su1,su2);
        ArrTest a = new ArrTest();
        String[] arr = {"hello","hi","world"};
        a.prt(arr);
        //a.prt(new String[]{"a","b"}); 직접 넣으려면 이렇게 써야한다.

//        System.out.println("학번");
//        String hakeno = sc.nextLine();
//        System.out.println("name");
//        String name = sc.nextLine();
//        System.out.println("tel");
//        String tel = sc.nextLine();
//        UserStudent u1 = new UserStudent(hakeno,name,tel);
//        UserStudent u2 = new UserStudent();
//        System.out.printf("%s, %s, %s",u1.hakno, u1.name, u1.tel);


    }
}
