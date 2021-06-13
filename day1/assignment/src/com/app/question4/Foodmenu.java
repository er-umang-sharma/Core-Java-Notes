// Write a program in java to display a food menu to the user, and calculate the total bill according to the input from the user
package com.app.question4;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;
public class Foodmenu {

    public static void main(String[] args) {

        double total=0;
        int choice, quantity, price=0, itemsAlreadyPresent=0;
        boolean exit=false;
        String item="";
        HashMap<String, Integer> itemsChosen = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (!exit) {
            try {
                System.out.println("---------------MENU------------");
                System.out.println("1. Dosa                 Rs 45.");
                System.out.println("2. Samosa               Rs 10.");
                System.out.println("3. Chart                Rs 20.");
                System.out.println("4. Dahi bada            Rs 20.");
                System.out.println("5. Gulab Jamun          Rs 10.");
                System.out.println("6. Ras Malai            Rs 25.");
                System.out.println("7. Gup Choop            Rs 20.");
                System.out.println("8. Jhaal Mudi           Rs 20.");
                System.out.println("9. Panner Roll          Rs 40.");
                System.out.println("10. Medu wada           Rs 20.");
                System.out.println("-------------------------------");

                System.out.println("Enter 0 to exit.\n\n");
                System.out.print("Enter you choice:");
                choice = sc.nextInt();

                switch(choice) {

                    case 1: 
                        System.out.println("Item chosen: DOSA");
                        item = "DOSA";     
                        price = 45; 
                        break;

                    case 2: 
                        System.out.println("Item chosen: SAMOSA");
                        item = "SAMOSA";
                        price = 10;
                        break;

                    case 3:
                        System.out.println("Item chosen: CHART");   
                        item = "CHART"; 
                        price = 20;
                        break;

                    case 4:
                        System.out.println("Item chosen: DAHI BADA");
                        item = "DAHI BADA";
                        price = 20;
                        break;

                    case 5:
                        System.out.println("Item chosen: GULAB JAMUN");
                        item = "GULAB JAMUN";
                        price = 10;
                        break;

                    case 6:
                        System.out.println("Item chosen: RAS MALAI");
                        item = "RAS MALAI";
                        price = 25;
                        break;

                    case 7:
                        System.out.println("Item chosen: GUP CHOOP");
                        item = "GUP CHOOP";
                        price = 20;
                        break;

                    case 8:
                        System.out.println("Item chosen: JHAAL MUDI");
                        item = "JHAAL MUDI";
                        price = 20;
                        break;

                    case 9:
                        System.out.println("Item chosen: PANEER ROLL");
                        item = "PANEER ROLL";
                        price = 40;
                        break;

                    case 10:
                        System.out.println("Item chosen: MEDU WADA");
                        item = "MEDU WADA";
                        price = 20;
                        break;

                    case 0:
                        System.out.println("Chosen to exit the program.");
                        exit = true;
                        break;

                    default: 
                        System.out.println("Please choose a valid input.");
                }
                if (exit) {
                    break;
                }
                System.out.print("Enter the quantity:");
                quantity = sc.nextInt();
                total += quantity * price;
                if (itemsChosen.containsKey(item)) {
                    itemsAlreadyPresent = itemsChosen.get(item);
                    itemsChosen.put(item, (itemsAlreadyPresent + quantity));
                } else {
                    itemsChosen.put(item, quantity);
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
            }
        }
        System.out.println("\n\n----FINAL BILL----");
        for (String i: itemsChosen.keySet()) {
            System.out.println(i + " -- : -- " + itemsChosen.get(i));
        }
        System.out.println("Total = Rs" + total);

        if (sc != null) {
            sc.close();
        }
    }
}
