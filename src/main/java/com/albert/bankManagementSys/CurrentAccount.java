package com.albert.bankManagementSys;

public class CurrentAccount extends Account{

    private double overdraftLimit;

    public CurrentAccount(int accountNum, String accountHolder, double balance, double overdraftLimit){
        super(accountNum, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void withdraw(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (amount > balance + overdraftLimit){
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("$" + amount + " withdrawn. Your new balance is $" + balance);
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    @Override
    public String toString(){
        return "Current Account{" + "accountNum=" + this.getAccountNum() + ", accountHolder=" + this.getAccountHolder() + ", balance=" + this.getBalance() + ", overdraftLimit=" + getOverdraftLimit() + "}";
    }
}