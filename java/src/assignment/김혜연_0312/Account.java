package assignment.김혜연_0312;

public class Account {
    private String accountNo;
    private String name;
    private int account;

    Account(String accountNo,String name, int account){
        this.accountNo = accountNo;
        this.name = name;
        this.account = account;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void create(){
        System.out.println("---------");
        System.out.println("계좌생성");
        System.out.println("---------");
        System.out.println("계좌번호:"+accountNo);
        System.out.println("계좌주:"+name);
        System.out.println("초기입금금액:"+account);
        System.out.println("결과:계좌가 생성되었습니다.");
    }
}
