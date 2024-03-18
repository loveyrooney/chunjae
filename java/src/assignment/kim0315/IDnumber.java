package assignment.kim0315;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Person{
    private String IDnum;
    private String name;
    private String birth;
    private String gender;
    private int age;

    public Person(String IDnum, String name){
        this.IDnum = IDnum;
        this.name = name;
        formatting();
    }

    private void formatting(){
        GregorianCalendar gc = new GregorianCalendar();
        String YY = IDnum.substring(0,2);
        String MM = IDnum.substring(2,4);
        String DD = IDnum.substring(4,6);
        char FM = IDnum.charAt(7);
//        if(YY<gc.getWeekYear()-2000) {
//            age = gc.getWeekYear()-(2000+YY);
//            birth = (2000+YY)+"년 "+MM+"월 "+DD+"일";
//        } else {
//            age = gc.getWeekYear()-(1900+YY);
//            birth = (1900+YY)+"년 "+MM+"월 "+DD+"일";
//        }
        if('1'==FM|| '2'==FM) {
            age = gc.getWeekYear()-(Integer.parseInt("19"+YY));
            birth = "19"+YY+"년 "+MM+"월 "+DD+"일";
        } else {
            age = gc.getWeekYear()-(Integer.parseInt("20"+YY));
            birth = "20"+YY+"년 "+MM+"월 "+DD+"일";
        }
        if('1'==FM || '3'==FM)

            gender = "남자";
        else
            gender = "여자";
    }

    public void prt(){
        System.out.println("이름: "+name);
        System.out.println("생년월일: "+birth);
        System.out.println("성별: "+gender);
        System.out.println("나이: "+age);
    }
}

public class IDnumber {
    public static void main(String[] args) {
        Person p1 = new Person("000101-3010101","김아무개");
        Person p2 = new Person("990202-2098765","이아무개");
        Person p3 = new Person("580331-1973840","박아무개");
        Person p4 = new Person("181122-4829076","홍아무개");
        p1.prt();
        p2.prt();
        p3.prt();
        p4.prt();

        //lecture
        Scanner sc = new Scanner(System.in);
        GregorianCalendar cal = new GregorianCalendar();
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("idNumber");
        String idNumber = sc.nextLine();

        String y = idNumber.substring(0,2);
        String M = idNumber.substring(2,4);
        String D = idNumber.substring(4,6);
        String G = idNumber.substring(7,8);
        String gender = "";
        if("1".equals(G)||"3".equals(G))
            gender = "남자";
        else
            gender = "여자";
        if("1".equals(G)||"2".equals(G))
            y = "19"+y;
        else
            y = "20"+y;
        System.out.println("이름: "+name);
        System.out.printf("생년월일: %s년 %s월 %s일\n",y,M,D);
        System.out.println("성별: "+gender);
        System.out.println("나이: "+(cal.get(Calendar.YEAR)-Integer.parseInt(y)));

    }
}
