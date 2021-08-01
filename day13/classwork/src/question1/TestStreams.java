package question1;

/**
 * Program to copy data from one file to another file.
 * */

import java.util.Scanner;
import java.util.InputMismatchException;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class TestStreams {

    public static void main(String[] args) {

        System.out.print("Enter the absolute path of the source file and destination file from where the data is to be read from and copied to: ");
        try (Scanner sc = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader(sc.next()));
            PrintWriter writer = new PrintWriter(new FileWriter(sc.next(), true), true)) {

            String str = "";
            while ( (str = reader.readLine()) != null) {
                writer.println(str);
            }

            System.out.println("Writing to file complete.");

        } catch (FileNotFoundException e) {

            System.out.println("The file entered is not found.");
        } catch (IOException e) {

            System.out.println("An error occurred during the I/O operation.");
        } catch (InputMismatchException e) {

            System.out.println("The data entered is not in the right format.");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
