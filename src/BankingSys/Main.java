package BankingSys;

import BankingSys.accounts.Account;
import BankingSys.accounts.CurrentAccount;
import BankingSys.accounts.SavingsAccount;
import BankingSys.services.BankService;
import BankingSys.services.BankServiceImpl;
import BankingSys.exceptions.InsufficientBalanceException;
import BankingSys.transactions.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BankService f = new BankServiceImpl();
        Account Raj = new SavingsAccount(6000, 1);
        Account Siya = new CurrentAccount(10000, 2);
        f.createAccount(Raj);
        f.createAccount(Siya);
//        Account e = f.findAccount(1);
        f.deposit(1, 2000);
        f.deposit(1,344);
        f.withdraw(1, 60);
        f.withdraw(1, 40);
        f.deposit(2, 89);
//        for(Transaction acc : Raj.getTransactions()){
//            System.out.println(acc.getAmount());
//            System.out.println(acc.getTime());
//            System.out.println(acc.getType());
//        }

//        Transaction er = (Transaction) Siya.getTransactions();
//        System.out.println(er.getType());
//        System.out.println(er.getAmount());

        Account zero = f.findAccount(2);
        zero.withdraw(zero.getBalance());
f.closeAccount(2);
        System.out.println(f.findAccount(2));
BankServiceImpl.printStatement(Raj);
        /*
        BankService r = new BankServiceImpl();
        Account rajesh = new SavingsAccount(45555555,45);
        r.createAccount(rajesh);

        Account found = r.findAccount(45);
        System.out.printf("Balance is %.2f%n", found.getBalance());
         r.deposit(45, 5678);
         if(found instanceof SavingsAccount){
              ((SavingsAccount) found).applyInterest();
         }
         System.out.printf("Balance is %.2f%n", found.getBalance());

         */

         /*
         SavingsAccount rt =  (SavingsAccount) r.findAccount(45);
         rt.applyInterest();
          */



        /*
         Account Shanti = new CurrentAccount(4000, 3);
         r.createAccount(Shanti);

         Account finalAccount = r.findAccount(3);
        System.out.printf("The balance is %.2f%n" , finalAccount.getBalance());


         try {
//         Account find = r.findAccount(3);
             r.deposit(3, 700);
             r.deposit(3, -56);
             r.withdraw(3, 6000);
         }
         catch(IllegalArgumentException e){
             System.out.println("Invalid arguments " + e.getMessage());
         }
         catch(InsufficientBalanceException e){
             System.out.println("Insufficient balance " + e.getMessage());
         }
         catch(Exception e){
             System.out.println(e.getMessage());
             System.out.println(e.getStackTrace());
         }

         */
    }
}