package com.test;

import com.app.core.Customer;
import utils.CollectionUtils;
import static utils.ValidationUtils.*;

import java.util.*;

public class Tester {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            ArrayList<Customer> arrayList = CollectionUtils.populateData();
            boolean exit = false;
            int indexOfCustomer;
            Customer customerLoginObject;
            while (!exit) {
                try {
                    System.out.println("-------------MENU------------");
                    System.out.println("1. Register a customer");
                    System.out.println("2. Customer Login");
                    System.out.println("3. Change Password");
                    System.out.println("4. Unsubscribe customer.");
                    System.out.println("5. Display names of customers who were born after a specified date.");
                    System.out.println("6. Sort customers according to the email.");
                    System.out.println("7. Sort customers according to the date.");
                    System.out.println("8. Sort customers according to the registration amount.");
                    System.out.println("9. Sort customers according to both date of birth and reg amount.");
                    System.out.println("10. Display all the customers registered.");
                    System.out.println("11. Sort customers according to the email.[DESCENDING]");
                    System.out.println("12. Sort customers according to the date.[DESCENDING]");
                    System.out.println("13. Sort customers according to the registration amount.[DESCENDING]");
                    System.out.println("14. Sort customers according to both reg date and reg amount.[DESCENDING]");
                    System.out.println("------------------------------");
                    System.out.println("0. Exit");
                    System.out.println("------------------------------");

                    System.out.print("Please enter you choice;");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter your information: (name, email, password, registration amount, date of birth- dd/mm/yyyy)");
                            Customer customer = new Customer(validateEmail(sc.next()), validatePassword(sc.next()), validateRegAmount(sc.nextDouble()), validateDateOfBirth(sc.next()));
                            if (arrayList.indexOf(customer)>=0) {
                                System.out.println("The user with this email ID is already registered. If you are this user, change your password.");
                                break;
                            }
                            arrayList.add(customer);
                            break;

                        case 2:
                            System.out.print("EMAIL: ");
                            indexOfCustomer = arrayList.indexOf(new Customer(sc.next()));
                            if (indexOfCustomer < 0) {
                                System.out.println("This email is not registered with this.");
                                break;
                            }
                            customerLoginObject = arrayList.get(indexOfCustomer);
                            System.out.print("PASSWORD: ");
                            if (sc.next().equals(customerLoginObject.getPassword())) {
                                System.out.println("You are successfully logged in.");
                                break;
                            }
                            System.out.println("Password validation failed.");
                            break;

                        case 3:
                            System.out.print("EMAIL: ");
                            indexOfCustomer = arrayList.indexOf(new Customer(sc.next()));
                            if (indexOfCustomer < 0) {
                                System.out.println("This email is not registered with us.");
                                break;
                            }
                            customerLoginObject = arrayList.get(indexOfCustomer);
                            System.out.print("NEW PASSWORD: ");
                            String password = validatePassword(sc.next());
                            System.out.print("TYPE PASSWORD AGAIN: ");
                            if (!(password.equals(sc.next()))) {
                                System.out.println("Passwords don't match.");
                                break;
                            }
                            customerLoginObject.setPassword(password);
                            System.out.println("Password updated with the new one.");
                            break;

                        case 4:
                            System.out.print("EMAIL: ");
                            indexOfCustomer = arrayList.indexOf(new Customer(sc.next()));
                            if (indexOfCustomer < 0) {
                                System.out.println("This email is not registered with this.");
                                break;
                            }
                            customerLoginObject = arrayList.get(indexOfCustomer);
                            System.out.print("PASSWORD: ");
                            if (sc.next().equals(customerLoginObject.getPassword())) {
                                System.out.println("You have been unsubscribed.");
                                break;
                            }
                            System.out.println("Password validation failed.");
                            break;

                        case 5:
                            System.out.println("Enter the data you want to based upon");
                            Date dateOfInput = sdf.parse(sc.next());
                            System.out.println("The people who are born after " + sdf.format(dateOfInput) + " are; ");
                            for (Customer c: arrayList) {
                                if (c.getDateOfBirth().after(dateOfInput))
                                    System.out.println(c);
                            }
                            break;

                        case 6:
                            System.out.println("Sorting the list based on the basis of email.");
                            Collections.sort(arrayList);
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 7:
                            System.out.println("Sorting the list based on the basis of date.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 8:
                            System.out.println("Sorting the list based on registration amount.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer c1, Customer c2) {
                                    return ((Double)c1.getRegAmount()).compareTo((Double)c2.getRegAmount());
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 9:
                            System.out.println("Sorting the list based on registration amount and date of birth.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    int dateCompare = o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                                    int regAmountCompare = ((Double)o1.getRegAmount()).compareTo((Double)o2.getRegAmount());

                                    if (dateCompare == 1 && regAmountCompare == 1)
                                        return 1;
                                    return 0;
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 10:
                            System.out.println("The information of all the customers are:");
                            printElementsOfList(arrayList);
                            break;

                        case 11:
                            System.out.println("Sorting the list based on the basis of email- DESCENDING.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return o2.getEmail().compareTo(o1.getEmail());
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 12:
                            System.out.println("Sorting the list based on the basis of date.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return o2.getDateOfBirth().compareTo(o1.getDateOfBirth());
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 13:
                            System.out.println("Sorting the list based on registration amount.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer c1, Customer c2) {
                                    return ((Double)c2.getRegAmount()).compareTo((Double)c1.getRegAmount());
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 14:
                            System.out.println("Sorting the list based on registration amount and date of birth.");
                            Collections.sort(arrayList, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    int dateCompare = o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                                    int regAmountCompare = ((Double)o1.getRegAmount()).compareTo((Double)o2.getRegAmount());

                                    if (dateCompare == 1 && regAmountCompare == 1)
                                        return -1;
                                    return 0;
                                }
                            });
                            System.out.println("Sorted list:");
                            printElementsOfList(arrayList);
                            break;

                        case 0:
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Please enter valid data.");
                    sc.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsOfList(ArrayList<Customer> list) {
        for (Customer c: list) {
            System.out.println(c);
        }
    }
}
