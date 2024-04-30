package com.chunjae.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
    private int balance;

    public void deposit(int money){
        this.balance += money;
    }
    public void withdraw(int balance){
        if(this.balance<balance)
            throw new RuntimeException("잔고 부족");
        this.balance -= balance;
    }

}
