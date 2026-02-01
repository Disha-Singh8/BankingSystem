package BankingSys.transactions;
import BankingSys.accounts.Account;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timeStamp;
private double balanceAfter;

   public Transaction(String type, double amount, double balanceAfter){
    this.type = type;
    this.amount = amount;
    this.timeStamp = LocalDateTime.now();
    this.balanceAfter = balanceAfter;


}

    public double getAmount(){
        return amount;
    }

    public String getType(){
     return type; }

    public LocalDateTime getTime(){
        return timeStamp;
    }
    public double getBalanceAfter(){
       return balanceAfter;
    }
}
