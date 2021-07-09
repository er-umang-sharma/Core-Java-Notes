package com.tester;

import com.app.core.BankAccount;
import cust_excs.AccountHandlingException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.ValidationUtils.*;

public class CreateAccount {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            ArrayList<BankAccount> accounts = new ArrayList<>();

            boolean exit = false;
            while (!exit) {

                try {

                    System.out.println("----------------MENU-----------------");
                    System.out.println("1. Create an account.");
                    System.out.println("2. Display all accounts created");
                    System.out.println("0. Exit");
                    System.out.println("-------------------------------------");

                    System.out.print("Enter your choice: ");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter the info for creating a bank account: (name, balance, date of birth(dd/mm/yyyy) & account type(savings/current/dmat/fd/nre))");
                            accounts.add(new BankAccount(sc.next(), sc.nextDouble(), validateDate(sc.next()), validateAccountType(sc.next().toUpperCase())));
                            System.out.println("Your account has been created with the given information.");
                            break;

                        case 2:
                            System.out.println("All the bank accounts created are:");
                            for (BankAccount b: accounts)
                                System.out.println(b);
                            break;

                        case 0:
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input");
                    }
                } catch (AccountHandlingException e) {
                    e.printStackTrace();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter the correct data.");
                    sc.nextLine();
                }
            }
        }
    }
}
