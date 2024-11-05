package com.dinidu.practice.bankingsystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount("A001", 1000);
        BankAccount account2 = new BankAccount("A002", 2000);
        BankAccount account3 = new BankAccount("A003", 3000);
        BankAccount account4 = new BankAccount("A004", 4000);
        BankAccount account5 = new BankAccount("A005", 5000);


        System.out.println("|================ Banking System ==================");
        System.out.println("|"+account2.getAccountNumber()+" Balance is : "+account2.getBalance());
        System.out.println("|"+account1.getAccountNumber()+" Balance is : "+account1.getBalance());
        System.out.println("|"+account3.getAccountNumber()+" Balance is : "+account3.getBalance());
        System.out.println("|"+account4.getAccountNumber()+" Balance is : "+account4.getBalance());
        System.out.println("|"+account5.getAccountNumber()+" Balance is : "+account5.getBalance());
        System.out.println("|==================================================");

        System.out.println();
        Thread t1 = new Thread(new TransactionTask(account1, account2));
        Thread t2 = new Thread(new TransactionTask(account3, account4));
        Thread t3 = new Thread(new TransactionTask(account5, account1));
        Thread t4 = new Thread(new TransactionTask(account2, account3));
        Thread t5 = new Thread(new TransactionTask(account4, account5));
        t1.start();
        Thread.sleep(1000); // Delay to simulate real-world timing
        t2.start();
        Thread.sleep(1000); // Delay to simulate real-world timing
        t3.start();
        Thread.sleep(1000); // Delay to simulate real-world timing
        t4.start();
        Thread.sleep(1000); // Delay to simulate real-world timing
        t5.start();



/*        BankAccount account1 = new BankAccount("001", 100);

        // Create a thread to withdraw money (will wait for funds)
        Thread t1 = new Thread(() -> {
            try {
                account1.withdraw(500); // Trying to withdraw more than balance
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create a thread to deposit money
        Thread t2 = new Thread(() -> {
            account1.deposit(600); // Deposit enough to cover the withdrawal
        });

        t1.start();  // Start the withdraw thread (will go into wait)
        Thread.sleep(1000); // Delay to simulate real-world timing
        t2.start();  // Start the deposit thread (which will notify the waiting withdraw)*/

    }
}