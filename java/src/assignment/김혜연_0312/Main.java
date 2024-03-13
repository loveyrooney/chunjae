package assignment.김혜연_0312;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Q15
        MemberService m = new MemberService();
        boolean result = m.login("lee","12345");
        if(result){
            System.out.println("로그인 되었습니다.");
            m.logout("hong");
        } else {
            System.out.println("id 또는 비밀번호가 일치하지 않습니다.");
        }

        //Q20
        Scanner sc = new Scanner(System.in);
        BankApplication bank = new BankApplication();
        int count = 0;
        while(true){
            System.out.println("-------------------------------------");
            System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
            System.out.println("-------------------------------------");
            int input = Integer.parseInt(sc.nextLine());
            System.out.println("선택>"+input);
            if(input ==2)
                bank.accountList();
            else if(input ==5) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("계좌번호를 입력하세요");
                String accountNo = sc.nextLine();
                switch (input) {
                    case 1:
                        System.out.println("이름을 입력하세요");
                        String name = sc.nextLine();
                        System.out.println("초기 입금 금액을 입력하세요");
                        int money = Integer.parseInt(sc.nextLine());
                        Account user = new Account(accountNo, name, money);
                        bank.account_list[count] = user;
                        count += 1;
                        user.create();
                        break;
                    case 3:
                        System.out.println("금액을 입력하세요");
                        int money3 = Integer.parseInt(sc.nextLine());
                        bank.deposit(accountNo,money3);
                        break;
                    case 4:
                        System.out.println("금액을 입력하세요");
                        int money4 = Integer.parseInt(sc.nextLine());
                        bank.withdraw(accountNo,money4);
                        break;
                    default:
                        System.out.println("숫자를 잘못입력하였습니다.");
                }
            }

        }

        //Q20 with lecture
        Account2[] account2s = new Account2[100];
        int count2 = 0;
        while(true){
            System.out.println("-------------------------------------");
            System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
            System.out.println("-------------------------------------");
            String input = sc.nextLine();
            System.out.println("선택>"+input);
            if("1".equals(input)){
                System.out.println("---------");
                System.out.println("계좌생성");
                System.out.println("---------");
                System.out.println("계좌번호");
                String accountNo = sc.nextLine();
                System.out.println("계좌주");
                String name = sc.nextLine();
                System.out.println("초기입금금액");
                int money = Integer.parseInt(sc.nextLine());
                Account2 account2 = new Account2(accountNo,name,money);
                account2s[count2++] = account2;
                System.out.println("결과: 계좌가 생성되었습니다.");
            } else if("2".equals(input)){
                System.out.println("---------");
                System.out.println("계좌목록");
                System.out.println("---------");
                for(int i=0; i<count2; i++){
                    System.out.printf("%s\t %s\t %d\n",account2s[i].getAccountNo(),account2s[i].getName(),account2s[i].getAccount());
                }
            } else if("3".equals(input)){
                System.out.println("---------");
                System.out.println("예금");
                System.out.println("---------");
                System.out.println("계좌번호");
                String accountNo = sc.nextLine();
                for(int i=0; i<count; i++){
                    if(account2s[i].getAccountNo().equals(accountNo)){
                        System.out.println("예금액");
                        int money = Integer.parseInt(sc.nextLine());
                        account2s[i].setAccount(account2s[i].getAccount()+money);
                        break;
                    }
                }
            } else if("4".equals(input)){
                System.out.println("---------");
                System.out.println("출금");
                System.out.println("---------");
                String accountNo = sc.nextLine();
                for(int i=0; i<count; i++){
                    if(account2s[i].getAccountNo().equals(accountNo)){
                        System.out.println("출금액");
                        int money = Integer.parseInt(sc.nextLine());
                        if(account2s[i].getAccount()<money)
                            System.out.println("잔고 부족");
                        else {
                            account2s[i].setAccount(account2s[i].getAccount() - money);
                            System.out.println("정상처리 되었습니다.");
                        }
                        break;
                    }
                }
            } else if("5".equals(input)){
                System.out.println("프로그램 종료");
            } else
                System.out.println("다시 선택하세요.");
        }

    }
}