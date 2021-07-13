package com.tester;

import com.app.core.BankAccount;
import cust_excs.AccountHandlingException;
import utils.CollectionUtils;
import static utils.ValidationUtils.*;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false, isPresent = false;
            ArrayList<BankAccount> bankAccounts = CollectionUtils.populateData();
            Iterator<BankAccount> itr;

            while(!exit) {
                try {
                    System.out.println("-----------------MENU----------------");
                    System.out.println("1. Register an account");
                    System.out.println("2. Display all the registered accounts.");
                    System.out.println("3. Close Account");
                    System.out.println("4. Sort according to the accountId.(natural ordering)");
                    System.out.println("5. Sort according to the name(custom ordering)");
                    System.out.println("6. Sort according to the balance(custom ordering)");
                    System.out.println("7. Sort according to the date of birth(custom ordering)");
                    System.out.println("10. Exit");
                    System.out.println("-------------------------------------\n");

                    System.out.print("Enter your choice:");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter the info for creating a bank account: (name, balance, date of birth(dd/mm/yyyy) & account type(savings/current/dmat/fd/nre))");
                            BankAccount account = new BankAccount(sc.next(), validateBalance(sc.nextDouble()), validateDate(sc.next()), validateAccountType(sc.next()));
                            itr  = bankAccounts.iterator();
                            isPresent = false;
                            while (itr.hasNext()) {
                                BankAccount acc = itr.next();
                                if (account.equals(acc)) {
                                    isPresent = true;
                                }
                            }
                            if (isPresent) {
                                System.out.println("The data entered is already present");
                                break;
                            }
                            bankAccounts.add(account);
                            break;

                        case 2:
                            System.out.println("The bank accounts registered are:");
                            itr = bankAccounts.iterator();
                            while (itr.hasNext()) {
                                System.out.println(itr.next());
                            }
                            break;

                        case 3:
                            System.out.println("Please enter the account number for closing the account.");
                            BankAccount acc = new BankAccount(sc.nextInt());
                            int indexOfAccount = bankAccounts.indexOf(acc);
                            if (indexOfAccount < 0) {
                                System.out.println("The bank account is not registered with this bank account");
                                break;
                            }
                            System.out.println("The bank account that was closed was: " + bankAccounts.remove(indexOfAccount));
                            break;

                        case 4:
                            System.out.println("Sorting according to the account ID.");
                            Collections.sort(bankAccounts);
                            System.out.println("Sorted list:");
                            for (BankAccount b: bankAccounts)
                                System.out.println(b);
                            break;

                        case 5:
                            System.out.println("Sorting according to the name.");
                            Collections.sort(bankAccounts, new Comparator<BankAccount>() {
                                @Override
                                public int compare(BankAccount o1, BankAccount o2) {
                                    return o1.getName().compareTo(o2.getName());
                                }
                            });
                            System.out.println("Sorted list");
                            for (BankAccount b: bankAccounts)
                                System.out.println(b);
                            break;

                        case 6:
                            System.out.println("Sorting according to the balance.");
                            Collections.sort(bankAccounts, new Comparator<BankAccount>() {
                                @Override
                                public int compare(BankAccount o1, BankAccount o2) {
                                    double balance1 = o1.getBalance();
                                    double balance2 = o2.getBalance();
                                    if (balance1 > balance2)
                                        return 1;
                                    else if (balance1 < balance2)
                                        return -1;
                                    return 0;
                                    // Body of compare() can be replaced with:
                                    // return Double(01.getBalance()).compareTo(Double(o2.getBalance()));
                                }
                            });
                            System.out.println("Sorted list");
                            for (BankAccount b: bankAccounts)
                                System.out.println(b);
                            break;

                        case 7:
                            System.out.println("Sorting according to the date of birth.");
                            Collections.sort(bankAccounts, new Comparator<BankAccount>() {
                                @Override
                                public int compare(BankAccount o1, BankAccount o2) {
                                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                                }
                            });
                            System.out.println("Sorted list");
                            for (BankAccount b: bankAccounts)
                                System.out.println(b);
                            break;

                        case 10:
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input");
                    }
                } catch (AccountHandlingException e) {
                    e.printStackTrace();
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                    System.out.println("Please enter valid data.");
                    sc.nextLine();
                }
            }
        } catch (AccountHandlingException e) {
            e.printStackTrace();
        }
    }
}
