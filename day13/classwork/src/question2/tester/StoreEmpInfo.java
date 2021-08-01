package question2.tester;

import java.util.Scanner;
import java.util.Map;

import question2.core.Employee;
import static question2.utils.IOUtils.*;
import static question2.utils.CollectionUtils.*;

public class StoreEmpInfo {
    
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("The data of the users:");

            Map<Integer, Employee> map = populateData();

            for (Employee employee : map.values()) {
                System.out.println(employee);
            }

            System.out.print("Enter the filename to store this data:");
            String filename = scanner.next();

            if (storeDataToFile(filename, map)) {
                System.out.println("The data store process complete.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
