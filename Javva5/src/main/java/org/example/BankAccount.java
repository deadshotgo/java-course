package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }

        if (balance < amount) {
            throw new InsufficientFundsException();
        }

        balance -= amount;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\n" +
                "Account Name: " + accountName + "\n" +
                "Balance: " + balance;
    }

    public double getBalance() {
        return balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException() {
            super("Insufficient funds to complete the transaction.");
        }
    }

    public static class NegativeAmountException extends Exception {
        public NegativeAmountException() {
            super("Negative amount is not allowed.");
        }
    }

    public static class AccountNotFoundException extends Exception {
        public AccountNotFoundException() {
            super("Account not found.");
        }
    }
}