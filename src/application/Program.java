package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main (String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();
            Account account = new Account(number, holder, balance, withdrawLimit, amount);
            account.updateAccount(amount);
            System.out.println("New balance: " + String.format("%.2f", account.updateAmount()));

        } catch (DomainException d) {
            System.out.print(d.getMessage());
        } catch (RuntimeException e) {
            System.out.print("Unexpected error");
        }

        sc.close();
    }
}
