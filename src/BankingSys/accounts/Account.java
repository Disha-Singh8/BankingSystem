package BankingSys.accounts;

import BankingSys.transactions.Transaction;

import java.util.List;

public interface Account{
    void withdraw(double amount);
    void deposit(double amount);
    int getAccountNumber();
    double getBalance();
    List<Transaction> getTransactions();
}

//public class Account {
//
//}
