package com.albert.bankManagementSys;

public class Account{

    private final int accountNum;
    private final String accountHolder;
    protected double balance;       // Protected because we want to use it in subclasses

    public Account(int accountNum, String accountHolder, double balance){
        this.accountNum = accountNum;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("$" + amount + " has been deposited and balance has been updated");
    }

    public void withdraw(double amount){
        if (amount > balance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        if (amount < 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance -= amount;
    }
    
    public double getBalance(){
        return balance;
    }

    public int getAccountNum(){
        return accountNum;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    @Override
    public String toString(){
        return "Account{" + "AccountNum=" + accountNum + ", accountHolder=" + accountHolder + ", balance=" + balance + "}";
    }
    
}