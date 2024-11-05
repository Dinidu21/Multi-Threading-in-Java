## Thread Practice Question: Multi-threaded Bank Transaction System
Objective:

Simulate a banking system where multiple threads represent different users performing 
transactions (e.g., deposits, withdrawals, and transfers) concurrently on 
multiple bank accounts. The goal is to practice thread synchronization, 
race condition handling, and inter-thread communication.

Detailed Instructions:
Step 1: Design the Bank Account Class

    Create a class BankAccount that represents a bank account with:
        Fields: accountNumber, balance.
        Methods:
            deposit(double amount): Adds the amount to the balance.
            withdraw(double amount): Subtracts the amount from the balance (but only if sufficient funds exist).
            transfer(BankAccount targetAccount, double amount): Transfers money from one account to another.

    Thread Safety:
        Use synchronization to ensure that the deposit(), withdraw(), and transfer() methods are thread-safe, preventing race conditions when multiple threads access or modify the account's balance concurrently.

Step 2: Create Threads for Multiple Transactions

    Create a Runnable class TransactionTask:
        This class will simulate multiple banking transactions such as deposits, withdrawals, and transfers.
        Each instance of TransactionTask will receive a reference to a BankAccount and a list of transactions it needs to perform.

    Transactions to Simulate:
        Random deposits.
        Random withdrawals.
        Random transfers between two accounts.
        Ensure that multiple threads are accessing the same accounts simultaneously to simulate real-world concurrency issues.

Step 3: Simulate a Bank with Multiple Threads

    Create multiple bank accounts: (e.g., account1, account2, account3, etc.).

    Create multiple threads (at least 4-5):
        Each thread will simulate a different user, performing transactions (e.g., one thread might handle deposits, while another handles withdrawals, and another transfers between accounts).
        These threads should run concurrently and perform operations on shared bank account objects.

    Randomize transactions: For each thread, randomize the type of transaction (deposit, withdrawal, transfer) and the amounts.

Step 4: Synchronization & Data Integrity

    Avoid Race Conditions: Use synchronization (e.g., synchronized blocks or methods) to avoid race conditions when threads modify the balance of a BankAccount concurrently.
        For example, without synchronization, two threads might read the balance at the same time, causing one of the operations to lose updates.

    Deadlock Prevention: When implementing transfer(), ensure that you prevent deadlocks (e.g., when one thread is transferring money from account A to B, and another is transferring from B to A simultaneously).

Step 5: Test and Handle Edge Cases

    Insufficient Funds: Ensure that withdrawals and transfers handle cases where there are insufficient funds in the account.

    Overlapping Transactions: Test your system by running multiple threads at the same time to simulate real-world banking where multiple users are accessing the system simultaneously.

    Data Integrity: After all threads have finished, verify that the total sum of all account balances remains correct and that no money was lost or created due to concurrency issues.

Step 6: Use Thread Communication (Optional)

    Thread Coordination: Implement a situation where one thread waits for another to complete a transaction. For example:
        Use wait() and notify() to simulate one thread waiting for sufficient balance in an account before performing a withdrawal.

    Producer-Consumer: Simulate a producer-consumer problem where one thread represents a user depositing funds, and another thread waits to withdraw funds only after deposits have been made.

What to Focus On:

    Thread creation and starting multiple threads concurrently.
    Correct use of synchronization to prevent data inconsistency.
    Ensuring no deadlocks occur in the system.
    Managing inter-thread communication for better control and coordination.