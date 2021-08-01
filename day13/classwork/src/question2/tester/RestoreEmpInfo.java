package question2.tester;

import java.util.Scanner;
import java.util.List;

import question2.core.Employee;
import static question2.utils.IOUtils.*;

public class RestoreEmpInfo {
    
    public static void main(String[] args) {

        System.out.print("Enter the filename to read data from: ");
        try (Scanner sc = new Scanner(System.in)) {
            String filename = sc.next();
            List<Employee> list = restoreDataFromFile(filename);
            System.out.println("The employees info:");
            for (Employee employee : list) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
