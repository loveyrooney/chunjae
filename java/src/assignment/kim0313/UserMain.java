package assignment.kim0313;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserArr userArr = new UserArr();
        //User[] users = userArr.getUserArrs();
        int i=0;
        while(i<5){
            System.out.println("이름");
            String name = sc.nextLine();
            System.out.println("나이");
            int age = Integer.parseInt(sc.nextLine());
            User user = new User(name,age);
            userArr.getUserArrs()[i] = user;
            i++;
        }
        System.out.println("이름\t 나이");
        for(int j=0; j<5; j++){
            System.out.printf("%s\t %d\n",userArr.getUserArrs()[j].getName(),userArr.getUserArrs()[j].getAge());
        }


    }
}
