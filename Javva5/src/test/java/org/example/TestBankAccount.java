package org.example;

class TestBankAccount {
    public static void main(String[] args) {
        Main bank = new Main();

        try {
            BankAccount account1 = bank.createAccount("Customer1", 4233);
            BankAccount account2 = bank.createAccount("Customer2", 421);

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 122);

            System.out.println("Balance account 1: " + account1.getBalance());
            System.out.println("Balance account 2: " + account2.getBalance());
        } catch (BankAccount.NegativeAmountException | BankAccount.InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        BankAccount foundAccount = bank.findAccount(1);
        if (foundAccount != null) {
            System.out.println("Found account: " + foundAccount.getAccountName());
            System.out.println(foundAccount.getAccountSummary());
        } else {
            System.out.println("Account not found.");
        }

        try {
            BankAccount nonExistentAccount = bank.findAccount(100);
            if (nonExistentAccount == null) {
                throw new BankAccount.AccountNotFoundException();
            }
        } catch (BankAccount.AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}