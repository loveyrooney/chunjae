package assignment.김혜연_0312;

public class Account2 {
    private String accountNo;
    private String name;
    private int account;

    public Account2(String accountNo, String name, int account) {
        this.accountNo = accountNo;
        this.name = name;
        this.account = account;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
