package com.dinidu.practice.bankingsystem;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Use Thread Communication
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        // Notify all threads waiting on this object
        notifyAll();
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        // Wait until the balance is sufficient for withdrawal
        while (balance < (int) amount) {
            System.out.println("Waiting to withdraw: " + (int) amount + " | Current Balance: " + balance);
            wait();  // Wait for deposit to happen
        }
        balance -= amount;
        System.out.println("Withdrew: " + (int) amount + " | New Balance: " + balance);
        // Notify other threads after balance has changed
        notifyAll();
    }

    //Avoid Nested Synchronization for wait and notify
/*    public synchronized void transfer(BankAccount targetAccount,double amount) throws InterruptedException {
        synchronized (this) {
            synchronized (targetAccount){
                if(balance >= amount){
                    this.withdraw(amount);
                    targetAccount.deposit(amount);
                }else {
                    throw new InterruptedException("Insufficient balance to transfer.");
                }
            }
        }
    }*/

    public void transfer(BankAccount targetAccount, double amount) throws InterruptedException {
        synchronized (this) {
            // Ensure that there are enough funds in the source account to transfer
            while (balance < amount) {
                System.out.println("Waiting to transfer: " + amount + " from " + accountNumber + " to " + targetAccount.getAccountNumber() + " | Current Balance: " + balance);
                wait();  // Wait until sufficient funds are available in this account
            }
            // Withdraw the amount from this account
            withdraw(amount);
        }

        // Deposit the amount into the target account (synchronized on the target account)
        synchronized (targetAccount) {
            targetAccount.deposit(amount);
            System.out.println("Transferred: " + amount + " from " + accountNumber + " to " + targetAccount.getAccountNumber());
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

    public double getBalance() {
        return balance;
    }
}
