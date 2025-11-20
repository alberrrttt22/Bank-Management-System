package com.albert.bankManagementSys;

public class SavingsAccount extends Account{

    private final double interestRate; 

    public SavingsAccount(int accountNum, String accountHolder, double balance, double interestRate){
        super(accountNum, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = balance * (interestRate/100);
        balance += interest;
        System.out.println("Interest has been deposited. Interest added: $" + interest);
    }

    public double getInterestRate(){
        return interestRate;
    }

    @Override
    public String toString(){
        return "Savings Account{" + "accountNum=" + this.getAccountNum() + ", accountHolder=" + this.getAccountHolder() + ", balance=" + this.getBalance() + ", interestRate=" + getInterestRate() + "}";
    }
}

