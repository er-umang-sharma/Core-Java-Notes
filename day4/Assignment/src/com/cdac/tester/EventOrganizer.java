package com.cdac.tester;

import com.cdac.core.Person;
import com.cdac.core.Student;
import com.cdac.core.Faculty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventOrganizer {

    public static int totalSeats;

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of the Hall:");
            int capacity = sc.nextInt();
            if (capacity < 0) {
                System.out.println("Hall cannot be of the given size.");
                System.exit(0);
            }
            Person[] totalSeatsAvailable = new Person[capacity];

            totalSeats = totalSeatsAvailable.length;
            int lastSeatBooked = 0, seatInput;
            boolean exit = false;
            while (!exit) {
                try {
                    System.out.println("----------------------MENU------------------");
                    System.out.println("1. Register Faculty");
                    System.out.println("2. Register Student");
                    System.out.println("3. Display info of all registered members");
                    System.out.println("4. Introduce yourself.");
                    System.out.println("5. Submit Feedback or Evaluation report");
                    System.out.println("---------------------------------------------");
                    System.out.println("\n10. Exit\n");

                    System.out.print("Enter your choice:");
                    switch (sc.nextInt()) {
                        case 1 -> {
                            if (isSeatNotAvailable(lastSeatBooked)) {
                                System.out.println("There are no more totalSeatsAvailable left. Sorry for the inconvenience");
                                break;
                            }
                            System.out.println("Enter the Firstname, Lastname, Years of Experience & Working domain of the faculty: ");
                            totalSeatsAvailable[lastSeatBooked++] = new Faculty(sc.next(), sc.next(), sc.nextInt(), sc.nextLine());
                            System.out.println("Registration successful. Seat: " + lastSeatBooked + ". The data entered is:");
                            System.out.println(totalSeatsAvailable[lastSeatBooked - 1]);
                        }
                        case 2 -> {
                            if (isSeatNotAvailable(lastSeatBooked)) {
                                System.out.println("There are no more totalSeatsAvailable left. Sorry for the inconvenience");
                                break;
                            }
                            System.out.println("Enter the Firstname, Lastname, Graduation Year & Course Name of the student: ");
                            totalSeatsAvailable[lastSeatBooked++] = new Student(sc.next(), sc.next(), sc.nextInt(), sc.nextLine());
                            System.out.println("Registration successful. Seat: " + lastSeatBooked + ". The data entered is:");
                            System.out.println(totalSeatsAvailable[lastSeatBooked - 1]);
                        }
                        case 3 -> {
                            if (lastSeatBooked == 0) {
                                System.out.println("No one's registered for the event. Sorry!!");
                                break;
                            }
                            System.out.println("All the registered users are:");
                            for (int i = 0; i < lastSeatBooked; i++) {
                                System.out.println(totalSeatsAvailable[i] + "\n----------------------\n");
                            }
                        }
                        case 4 -> {
                            System.out.print("Enter the seat number you want to be introduced:");
                            seatInput = sc.nextInt() - 1;
                            if (seatInput < 0 || seatInput >= lastSeatBooked) {
                                System.out.println("The seat number you're asking is either not available or not registered");
                                break;
                            }
                            totalSeatsAvailable[seatInput].introduce();
                        }
                        case 5 -> {
                            System.out.print("Enter the seat number you want to be introduced:");
                            seatInput = sc.nextInt() - 1;
                            if (seatInput < 0 || seatInput >= lastSeatBooked) {
                                System.out.println("The seat number you're asking is either not available or not registered");
                                break;
                            }
                            if (totalSeatsAvailable[seatInput] instanceof Faculty) {
                                Faculty f = (Faculty) totalSeatsAvailable[seatInput];
                                f.evaluate();
                            } else {
                                Student s = (Student) totalSeatsAvailable[seatInput];
                                s.feedback();
                            }
                        }
                        case 10 -> {
                            System.out.println("Chosen to exit the program. Good Bye!!");
                            exit = true;
                        }
                        default -> System.out.println("Please enter a valid input.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Data entered wrong. Please enter again.");
                    sc.nextLine();
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("The data entered is not a valid type.");
        }
    }

    public static boolean isSeatNotAvailable(int lastSeatBooked) {
        return lastSeatBooked >= totalSeats;
    }
}
