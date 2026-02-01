package BankingSys.accounts;

import BankingSys.services.BankServiceImpl;
import BankingSys.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount implements Account,Interest {
    private double currentBalance;
   private int accountNumber;
   private final int interestRate = 4;
   List<Transaction> transactionList = new ArrayList<>();

   public SavingsAccount(double currentBalance, int accountNumber){
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
    public void withdraw(double amount) {
       if(currentBalance >= amount && amount > 0){
        this.currentBalance -= amount;
        transactionList.add(new Transaction("WITHDRAW", amount, currentBalance));
       }
    }

    @Override
    public void deposit(double amount) {
if(amount >0) {
        this.currentBalance += amount; }
transactionList.add(new Transaction("DEPOSIT", amount, currentBalance));
    }

    public void applyInterest(){
       double interest = (this.interestRate * this.currentBalance)/100;
       this.currentBalance += interest;
       transactionList.add(new Transaction("INTEREST", interest, currentBalance));

    }

    public List<Transaction> getTransactions(){
       return transactionList;
    }
}
