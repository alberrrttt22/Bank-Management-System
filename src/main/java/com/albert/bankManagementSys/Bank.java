package com.albert.bankManagementSys;

import java.util.ArrayList;
import java.util.List;

public class Bank{
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public Account findAccount(int accountNum){
        for (Account acc : accounts){
            if (acc.getAccountNum() == accountNum){
                return acc;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    public void transferFund(int fromAccNum, int toAccNum, double amount){
        Account fromAcc = findAccount(fromAccNum);
        Account toAcc = findAccount(toAccNum);
        if (fromAcc != null && toAcc != null){
            fromAcc.withdraw(amount);
            toAcc.deposit(amount);
            System.out.println("Transferred $" + amount + " from " + fromAccNum + " to " + toAccNum + " successfully." );
        }
    }


}