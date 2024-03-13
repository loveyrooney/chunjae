package assignment.김혜연_0312;

public class BankApplication {
    public Account[] account_list = new Account[100];
    public void accountList(){
        System.out.println("---------");
        System.out.println("계좌목록");
        System.out.println("---------");
        for(int i=0; i<account_list.length; i++){
            if(account_list[i] ==null)
                break;
            System.out.printf("%s\t %s\t %d\n",account_list[i].getAccountNo(),account_list[i].getName(),account_list[i].getAccount());
        }
    }
    public Account search(String accountNo){
        Account target = null;
        for(int i=0; i<account_list.length; i++) {
            if (account_list[i].getAccountNo().equals(accountNo)) {
                target = account_list[i];
                break;
            } else if(account_list[i].getAccountNo() == null)
                break;
        }
        return target;
    }

    public void deposit(String accountNo, int money){
        Account target = search(accountNo);
        if(target == null)
            System.out.println("해당 계좌가 없습니다.");
        else {
            target.setAccount(target.getAccount()+money);
            System.out.println("---------");
            System.out.println("예금");
            System.out.println("---------");
            System.out.println("계좌번호:"+target.getAccountNo());
            System.out.println("예금액:"+money);
            System.out.println("잔액:"+target.getAccountNo());
        }
    }
    public void withdraw(String accountNo, int money){
        Account target = search(accountNo);
        if (target == null)
            System.out.println("해당 계좌가 없습니다.");
        else {
            if(target.getAccount()-money<0) {
                System.out.println("잔액이 부족해 출금할 수 없습니다.");
                System.out.println("잔액:" + target.getAccount());
            } else {
                target.setAccount(target.getAccount()-money);
                System.out.println("---------");
                System.out.println("출금");
                System.out.println("---------");
                System.out.println("계좌번호:"+target.getAccountNo());
                System.out.println("출금액:"+money);
                System.out.println("잔액:"+target.getAccount());
            }
        }
    }

}
