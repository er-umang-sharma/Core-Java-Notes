package tester;

import com.app.core.Customer;
import cust_excs.CustomerHandlingException;
import utils.CollectionUtils;

import java.util.*;

import static utils.ValidationUtils.*;
import static utils.ValidationUtils.validateDateOfBirth;

public class Test {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            HashMap<String, Customer> hashMap = CollectionUtils.populateData();
            boolean exit = false;
            System.out.println(hashMap);

            Customer customer;
            ArrayList<Customer> list;
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
                    list = new ArrayList<>(hashMap.values());

                    System.out.print("Please enter you choice:");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter your information: (4" +
                                    "email, password, registration amount, date of birth- dd/mm/yyyy)");
                            String email = sc.next();
                            if (hashMap.get(email) != null)
                                throw new CustomerHandlingException("The email is already registered, please enter a valid input.");
                            hashMap.put(email, new Customer(validateEmail(email), validatePassword(sc.next()), validateRegAmount(sc.nextDouble()), validateDateOfBirth(sc.next())));
                            System.out.println("Customer registered with email: " + email);
                            break;

                        case 2:
                            customer = validateCustomer(hashMap);
                            System.out.println("Login Successful.");
                            break;

                        case 3:
                            customer = validateCustomer(hashMap);
                            System.out.println("Login Successful.");
                            System.out.print("Enter the new password:");
                            String password = sc.next();
                            System.out.print("Enter the same password again: ");
                            if (!password.equals(sc.next()))
                                throw new CustomerHandlingException("Passwords don't match.");
                            customer.setPassword(password);
                            System.out.println("Password change successful");
                            break;

                        case 4:
                            customer = validateCustomer(hashMap);
                            hashMap.remove(customer.getEmail());
                            System.out.println("Customer with email ID: " + customer.getEmail() + "  unsubscribed.");
                            break;

                        case 5:
                            System.out.print("Date[dd/mm/yyyy]: ");
                            Date date = sdf.parse(sc.next());
                            System.out.printf("People born after %s are: %n", sdf.format(date));
                            for (String key: hashMap.keySet()) {
                                customer = hashMap.get(key);
                                if (customer.getDateOfBirth().after(date))
                                    System.out.println(customer);
                            }
                            break;

                        case 6:
                            // Sort Customers according to the emails
                            TreeMap<String, Customer> treeMap = new TreeMap<>(hashMap);
                            System.out.println("Values sorted based on the emails: ");
                            for (Customer c: treeMap.values())
                                System.out.println(c);
                            break;

                        case 7:
                            // Sort Customers according to the date
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                                }
                            });
                            System.out.println("Sorted list according to the date of birth:");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 8:
                            // Sort Customers according to the registration amount
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return ((Double) o1.getRegAmount()).compareTo((Double) o2.getRegAmount());
                                }
                            });
                            System.out.println("Sorted list according to the registration amount:");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 9:
                            // Sort Customers according to the date of birth and registration amount.
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    int dateCompare = o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                                    int regAmountCompare = ((Double)o1.getRegAmount()).compareTo((Double)o2.getRegAmount());

                                    if (dateCompare == 1 && regAmountCompare == 1)
                                        return 1;
                                    return 0;
                                }
                            });
                            System.out.println("Sorted list according to the date of birth and registration amount: ");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 10:
                            System.out.println("All registered customers: ");
                            for (String key: hashMap.keySet())
                                System.out.println(hashMap.get(key));
                            break;

                        case 11:
                            // Sort Customers according to the email- Descending
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return o2.getEmail().compareTo(o1.getEmail());
                                }
                            });
                            System.out.println("Sorted list according to the email[DESCENDING]: ");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 12:
                            // Sort Customers according to the date- Descending
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return o2.getDateOfBirth().compareTo(o1.getDateOfBirth());
                                }
                            });
                            System.out.println("Sorted list according to the date of birth [DESCENDING]:");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 13:
                            // Sort Customers according to the registration amount- Descendign
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return ((Double) o2.getRegAmount()).compareTo((Double) o1.getRegAmount());
                                }
                            });
                            System.out.println("Sorted list according to the registration amount [DESCENDING]:");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 14:
                            // Sort Customers according to the date of birth and registration amount- Descending
                            Collections.sort(list, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    int dateCompare = o2.getDateOfBirth().compareTo(o1.getDateOfBirth());
                                    int regAmountCompare = ((Double)o2.getRegAmount()).compareTo((Double)o1.getRegAmount());

                                    if (dateCompare == 1 && regAmountCompare == 1)
                                        return 1;
                                    return 0;
                                }
                            });
                            System.out.println("Sorted list according to the date of birth and registration amount [DESCENDING]: ");
                            for (Customer c: list)
                                System.out.println(c);
                            break;

                        case 0:
                            System.out.println("Exiting the program");
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid choice.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input.");
                    sc.nextLine();
                } catch (CustomerHandlingException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Customer validateCustomer(HashMap<String, Customer> hashMap) throws CustomerHandlingException{
        Scanner sc = new Scanner(System.in);
        System.out.print("EMAIL: ");
        Customer customer = hashMap.get(sc.next());
        if (customer == null)
            throw new CustomerHandlingException("There is no user with this email ID registered.");
        System.out.print("PASSWORD: ");
        if (!customer.getPassword().equals(sc.next()))
            throw new CustomerHandlingException("The Password validation falied.");
        return customer;
    }
}
