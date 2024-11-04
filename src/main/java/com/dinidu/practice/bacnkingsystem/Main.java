package com.dinidu.practice.bacnkingsystem;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("A001", 100000);
        BankAccount account2 = new BankAccount("A002", 200000);
        BankAccount account3 = new BankAccount("A003", 300000);


        Thread t1 = new Thread(new TransactionTask(account1, account2));
        Thread t2 = new Thread(new TransactionTask(account2, account3));
        Thread t3 = new Thread(new TransactionTask(account3, account1));
        t1.start();
        t2.start();
        t3.start();
    }
}