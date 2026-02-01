package BankingSys.services;

import BankingSys.accounts.Account;
import BankingSys.exceptions.InsufficientBalanceException;
import BankingSys.transactions.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankServiceImpl implements BankService {

    private List<Account> accounts = new ArrayList<>();
    @Override
    public void createAccount(Account account){
    accounts.add(account);
    }

    @Override
    public Account findAccount(int accountNumber) {
        for(Account acc : accounts){
            if(acc.getAccountNumber() == accountNumber){
                return acc;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount){
        if(amount <=0) {throw new IllegalArgumentException("Amount should be greater than zero"); }
            Account r = this.findAccount(accountNumber);
        if(r == null){
            throw new IllegalArgumentException("Account not found");
        }
            r.deposit(amount);

    }
    public void withdraw(int accountNumber, double amount){
        if(amount <= 0){throw new IllegalArgumentException("Invalid amount, can only be a positive number other than zero"); }

        Account r = this.findAccount(accountNumber);
        if(r==null){ throw new IllegalArgumentException("Account not found");
        }
        double balance = r.getBalance();
        if(balance < amount) { throw new InsufficientBalanceException("Insufficient balance");
        }
            r.withdraw(amount);
    }

   public void closeAccount(int accountNumber){
       Iterator<Account> allAcc = accounts.iterator();

       while(allAcc.hasNext()){
           Account ac = allAcc.next();
           if(ac.getAccountNumber() == accountNumber){
               if(ac.getBalance() != 0){
                   throw new InsufficientBalanceException("The balance isn't zero");
               }
               allAcc.remove();
               System.out.println("Account no "+ accountNumber+ " removed" );
               return;
           }
       }
           System.out.println("Account not found");
    }
public static void printStatement(Account acc) {
    System.out.println("=======================================================");
    System.out.println("Account no: " + acc.getAccountNumber());
    System.out.println("time       type        amount         CurrentBalance");
    System.out.println("=======================================================");
    for (Transaction tr : acc.getTransactions()) {
        System.out.printf("%s           %8s        %8.f           %8.2f%n");
        tr.getTime();
        tr.getType();
        tr.getAmount();
        tr.getBalanceAfter();
    }
}
}
