package com.dinidu.practice.bacnkingsystem;

import java.util.Map;

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
        double amount = Math.random() * 1000;  // Random amount between 0 and 1000
        int action = (int) (Math.random() * 3); // Random action: 0=deposit, 1=withdraw, 2=transfer

        switch (action) {
            case 0:
                account.deposit(amount);
                System.out.printf("Deposited %.2f%n", amount); // Format amount to 2 decimal places
                break;
            case 1:
                account.withdraw(amount);
                System.out.printf("Withdrew %.2f%n", amount); // Format amount to 2 decimal places
                break;
            case 2:
                account.transfer(targetAccount, amount);
                System.out.printf("Transferred %.2f amount to %s%n", amount, targetAccount.getAccountNumber());
                break;
        }
    }
}
