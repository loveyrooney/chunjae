package junit1;

import com.chunjae.bank.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
    private Account account;
    @BeforeEach
    public void setup(){
        account = new Account(100);
    }
    @Test
    public void testWithdraw(){
        account.withdraw(10);
        Assertions.assertEquals(90,account.getBalance());
    }
    @Test
    public void testDeposit(){
        account.deposit(10);
        Assertions.assertEquals(110,account.getBalance());

    }
    @Test
    public void testWithdrawException(){
        Assertions.assertThrows(RuntimeException.class,()->{
           account.withdraw(80);
        });
    }
}
