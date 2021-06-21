package com.app.tester;

import com.app.core.Employee;
import static com.app.util.ValidationUtils.*;
import cust_excps.EmployeeHandlingException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestEmployee {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Employee[] employees = new Employee[10];
            int counter = 0;
            boolean exit = false;

            while(!exit) {

                System.out.println("1 : Hire Emp 2 : Display Info 10:Exit");
                System.out.println("Choose option");

                try {
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter employee details : email, name,  dept & basic");
                            String email = sc.next();
                            String name = sc.next();
                            String dept = sc.next();
                            double basic = sc.nextDouble();
                            validateEmployeeEmail(email);
                            validateEmployeeName(name);
                            validateDepartment(dept);
                            validateBasic(basic);
                            employees[counter++] = new Employee(email, name, dept, basic);
                            break;

                        case 2:
                            for (int i = 0; i<counter; i++) {
                                System.out.println(employees[i]);
                            }
                            break;

                        case 10:
                            exit = true;
                            break;

                        default:
                            System.out.println("Please enter a valid input.");
                    }
                } catch (EmployeeHandlingException e) {
                    e.printStackTrace();
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input.");
                    sc.nextLine();
                }
            }
        }
    }
}
