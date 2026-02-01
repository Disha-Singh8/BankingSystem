package BankingSys.accounts;

import BankingSys.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {
private double currentBalance;
private int accountNumber;
private List<Transaction> transactionList = new ArrayList<>();

 public CurrentAccount(double currentBalance, int accountNumber){
    this.currentBalance = currentBalance;
    this.accountNumber = accountNumber;
}
    @Override
    public double getBalance() {
        return currentBalance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void deposit(double amount) {
     if(amount >0){
        this.currentBalance += amount;
        Transaction re = new Transaction("DEPOSIT", amount, currentBalance);
        transactionList.add(re);
     }
    }

    @Override
    public void withdraw(double amount) {
    if(currentBalance >= amount && amount >0){
        this.currentBalance -= amount;
        Transaction re = new Transaction("WITHDRAW", amount, currentBalance);
        transactionList.add(re);
    }
    }

    public List<Transaction> getTransactions(){
//            Transaction e = new Transaction();
        return transactionList;

    }
}
