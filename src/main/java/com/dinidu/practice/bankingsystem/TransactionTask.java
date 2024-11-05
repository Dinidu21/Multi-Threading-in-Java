package com.dinidu.practice.bankingsystem;

import com.dinidu.practice.bankingsystem.BankAccount;

public class TransactionTask implements Runnable {
    private BankAccount account;
    private BankAccount targetAccount;

    public TransactionTask(BankAccount account, BankAccount targetAccount) {
        this.account = account;
        this.targetAccount = targetAccount;
    }

    @Override
    public void run() {
        // Randomly perform deposit, withdrawal, or transfer
        double amount = Math.random() * 50000;  // Random amount between 0 and 500
        int action = (int) (Math.random() * 3); // Random action: 0=deposit, 1=withdraw, 2=transfer

        switch (action) {
            case 0: // Deposit
                account.deposit(amount);
                System.out.printf("\n[Transaction] Account %s: Deposited $%.2f%n", account.getAccountNumber(), amount);
                System.out.printf("[Result] New Balance: $%.2f%n", account.getBalance());
                break;
            case 1: // Withdraw
                try {
                    account.withdraw(amount);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.printf("\n[Transaction] Account %s: Withdrew $%.2f%n", account.getAccountNumber(), amount);
                System.out.printf("[Result] New Balance: $%.2f%n", account.getBalance());
                break;
            case 2: // Transfer
                try {
                    account.transfer(targetAccount, amount);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.printf("\n[Transaction] Account %s: Transferred $%.2f to Account %s%n",
                        account.getAccountNumber(), amount, targetAccount.getAccountNumber());
                System.out.printf("[Result] Account %s New Balance: $%.2f%n", account.getAccountNumber(), account.getBalance());
                System.out.printf("[Result] Account %s New Balance: $%.2f%n", targetAccount.getAccountNumber(), targetAccount.getBalance());
                break;
        }

        System.out.println("--------------------------------------------------");
    }
}
