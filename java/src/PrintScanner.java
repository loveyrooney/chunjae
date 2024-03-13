import java.util.Scanner;

public class PrintScanner {
    public static void main(String[] args) {
        System.out.print("hello");
        System.out.println("\nthis is hong");
        System.out.println("hello, world");

        //format : %s(string), %d(정수형-int,long), %f(실수형-float,double)
        System.out.printf("name is %s\n", "kim");
        System.out.printf("age is %d\n", 20);
        System.out.printf("height is %.1f\n", 190.2523);

        String name = "hong"; //char는 '', string은 ""
        int age = 10;
        System.out.printf("name is %s\n", name);
        System.out.printf("age is %d\n", age);

        Scanner scanner = new Scanner(System.in);
        System.out.println("write your name");
        String name1 = scanner.nextLine();
        System.out.println("write your age");
        int age2 = Integer.parseInt(scanner.nextLine());
        System.out.printf("name is %s\n", name1);
        System.out.printf("age is %d\n", age2);

    }
}
