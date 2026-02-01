package BankingSys.services;

import BankingSys.accounts.Account;

public interface BankService {
    void createAccount(Account account );
        Account findAccount(int accountNumber);
        void deposit(int accountNumber, double amount);
        void withdraw(int accountNumber, double amount);
    void closeAccount(int accountNumber);
}
