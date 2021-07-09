package tester;

import com.app.core.Customer;
import cust_excs.CustomerHandlingException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static util.ValidationRules.*;

public class Test {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            boolean exit = false;
            ArrayList<Customer> customers = new ArrayList<>();
            boolean isPresent;

            while(!exit) {

                try {

                    System.out.println("-----------MENU------------");
                    System.out.println("1. Register a customer.");
                    System.out.println("2. Display the list of customers.");
                    System.out.println("10. Exit");
                    System.out.println("---------------------------");
                    System.out.println("Enter your choice:");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter email, password, registration amount and the date of birth(dd/mm/yyyy):");
                            Customer customer = new Customer(validateEmail(sc.next()), validatePassword(sc.next()), validateRegAmount(sc.nextDouble()), validateDateOfBirth(sc.next()));
                            isPresent = false;
                            for (int i = 0; i < customers.size(); i++) {
                                if (customer.equals(customers.get(i))) {
                                    isPresent = true;
                                    break;
                                }
                            }
                            if (isPresent) {
                                System.out.println("The customer is already registered.\nPlease enter your choice again.");
                                break;
                            }
                            customers.add(customer);
                            System.out.println("Registration successful");
                            break;

                        case 2:
                            System.out.println("The list of customers are:");
                            for (Customer c: customers)
                                System.out.println(c);
                            break;

                        case 10:
                            System.out.println("Exiting the program.\nThank you.");
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input");

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input.");
                    sc.nextLine();
                } catch (CustomerHandlingException e) {
                    e.printStackTrace();
                    sc.nextLine();
                } catch (ParseException e) {
                    System.out.println("The date entered is not in a valid format");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not a valid input.");
        }
    }
}
