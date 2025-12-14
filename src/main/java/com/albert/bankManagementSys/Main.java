package com.albert.bankManagementSys;

public class Main{
    public static void main(String[] args){
        Bank bank = new Bank();

        Account savings = new SavingsAccount(123, "Alice", 0, 5);
        Account current = new CurrentAccount(456, "Bob", 200, 2000);

        bank.addAccount(savings);
        bank.addAccount(current);

        savings.deposit(1000);
        current.withdraw(100);

        bank.transferFund(123, 456, 500);
        System.out.println(savings);
        System.out.println(current);
    }
}
