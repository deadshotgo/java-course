package org.example;
import java.util.ArrayList;

public class Main {
    private ArrayList<BankAccount> accounts;

    public Main() {
        accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountHolderName, double initialDeposit) throws BankAccount.NegativeAmountException {
        if (initialDeposit < 0) {
          throw new BankAccount.NegativeAmountException();
        }

        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws BankAccount.InsufficientFundsException, BankAccount.NegativeAmountException {
        if (amount < 0) {
            throw new BankAccount.NegativeAmountException();
        }

        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccount.getBalance() < amount) {
            throw new BankAccount.InsufficientFundsException();
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        return true;
    }

    private int generateAccountNumber() {
        return accounts.size() + 1;
    }
}
