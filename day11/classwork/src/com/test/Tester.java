package com.test;

import com.app.core.AccountType;
import com.app.core.BankAccount;
import cust_excs.AccountHandlingException;
import utils.CollectionUtils;

import static utils.CollectionUtils.*;
import static utils.ValidationUtils.*;

import java.text.ParseException;
import java.util.*;

public class Tester {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;

            Map<Integer, BankAccount> hashMap = populateMap();
            while(!exit) {
                try {
                    System.out.println("-------------MENU-------------");
                    System.out.println("1. Open an account.");
                    System.out.println("2. Display all account details.");
                    System.out.println("3. Fetch Account Summary");
                    System.out.println("4. Transfer funds");
                    System.out.println("5. Close account.");
                    System.out.println("6. Display accounts created after a certain date.");
                    System.out.println("7. Apply Simple Interest to all savings account.");
                    System.out.println("8. Sort accounts according to the account IDs[Natural Ordering]");
                    System.out.println("9. Sort accounts according to the account IDs[Custom Ordering- Descending]");
                    System.out.println("10. Sort accounts according to the account balance.");
                    System.out.println("-------------------------------");
                    System.out.println("0. Exit");
                    System.out.println("-------------------------------");

                    System.out.print("Please enter your choice:");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Please enter the details of the account to be created:");
                            System.out.print("First Name: ");
                            String firstName = sc.next();
                            System.out.print("Last Name: ");
                            String lastName = sc.next();
                            String name = firstName + " " + lastName;
                            System.out.print("Starting Balance: Rs ");
                            double balance = sc.nextDouble();
                            // Date to be used of today.
                            System.out.print("Account Type(SAVINGS, CURRENT, DMAT, NRE, FD): ");
                            String accountType = sc.next().toUpperCase();

                            BankAccount account = new BankAccount(name, balance, new Date(), validateAccountType(accountType));
                            hashMap.put(account.getAccountId(), account);
                            System.out.println("New account registration successful with account Id: " + account.getAccountId());
                            break;

                        case 2:
                            System.out.println("All the accounts registered are:");
                            for (int key: hashMap.keySet())
                                System.out.println(hashMap.get(key));
                            break;

                        case 3:
                            System.out.print("Please enter the accountId of your account:");
                            BankAccount bankAccount = hashMap.get(sc.nextInt());
                            System.out.println(bankAccount != null ? bankAccount : "There is no account with this ID registered.");
                            break;

                        case 4:
                            System.out.print("Source Account: ");
                            BankAccount sourceAccount = hashMap.get(sc.nextInt());
                            if (sourceAccount == null)
                                throw new AccountHandlingException("The is no account registered with this account ID. ");
                            System.out.print("Destination Account: ");
                            BankAccount destinationAccount = hashMap.get(sc.nextInt());
                            if (destinationAccount == null)
                                throw new AccountHandlingException("The is no account registered with this account ID. ");
                            System.out.print("Amount to be transferred: Rs ");
                            double amount = sc.nextDouble();
                            sourceAccount.transferFunds(destinationAccount, amount);
                            break;

                        case 5:
                            System.out.print("Enter account ID for closing the account: ");
                            if (hashMap.remove(sc.nextInt()) == null ) {
                                throw new AccountHandlingException("The account is not registered with this account ID.");
                            }
                            System.out.println("The account was closed.");
                            break;

                        case 6:
                            System.out.print("Date(dd/mm/yyyy): ");
                            Date date = sdf.parse(sc.next());
                            System.out.println("Account Holders' name whose accounts were created after the date " + sdf.format(date) + " : \n");
                            for (BankAccount acc: hashMap.values()) {
                                if (acc.getCreationDate().after(date))
                                    System.out.println(acc);
                            }
                            break;

                        case 7:
                            System.out.print("Enter the Rate of Interest:");
                            double rate = sc.nextDouble();
                            for (BankAccount acc: hashMap.values()) {

                                // equals and == are interchangeable as Enum equality is based on its ordinal equality.
                                if (acc.getType() == AccountType.SAVINGS)
                                    acc.applyInterest(rate);
                            }
                            System.out.println("Simple Interest applied.");
                            break;

                        case 8:
                            // Sorting based on BankAccount IDs
                            TreeMap<Integer, BankAccount> treeMap = new TreeMap<>(hashMap);
                            System.out.println("Sorted Map according to the Account ID:");
                            for (BankAccount account1: treeMap.values())
                                System.out.println(account1);
                            break;

                        case 9:
                            // Sorting based on BankAccount IDs- Descending
                            TreeMap<Integer, BankAccount> treeMap1 = new TreeMap<>(new Comparator<Integer>() {
                                @Override
                                public int compare(Integer o1, Integer o2) {
                                    return o2.compareTo(o1);
                                }
                            });
                            treeMap1.putAll(hashMap);
                            System.out.println("Sorted Map according to the Account IDs[Descending]:");
                            for (BankAccount account1: treeMap1.values())
                                System.out.println(account1);
                            break;

                        case 10:
                            // Sorting based on BankAccount Balance
                            ArrayList<BankAccount> list = new ArrayList<>(hashMap.values());
                            Collections.sort(list, new Comparator<BankAccount>() {
                                @Override
                                public int compare(BankAccount o1, BankAccount o2) {
                                    return ((Double) o1.getBalance()).compareTo((Double) o2.getBalance());
                                }
                            });
                            System.out.println("Sorted Map according to the Account Balances:");
                            for (BankAccount account1: list)
                                System.out.println(account1);
                            break;

                        case 0:
                            System.out.println("Exiting the execution of the program.");
                            exit = true;
                            break;

                        default:
                            System.out.println("Please type a valid choice.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The data entered is not a valid input.");
                    sc.nextLine();
                } catch (ParseException e) {
                    System.out.println("The parsing was not successful. Date not input in a correct format.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
