package com.dinidu.practice.bacnkingsystem;

public class BankAccount {
        private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }


    public synchronized void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
        }else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    public synchronized void transfer(BankAccount targetAccount,double amount) {
        synchronized (this) {
            synchronized (targetAccount){
                if(balance >= amount){
                    this.withdraw(amount);
                    targetAccount.deposit(amount);
                }else {
                    throw new RuntimeException("Insufficient balance to transfer");
                }
            }
        }

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
