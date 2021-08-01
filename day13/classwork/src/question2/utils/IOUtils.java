package question2.utils;

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import question2.core.Employee;
import question2.cust_excs.EmployeeHandlingException;

public class IOUtils {
    
    public static boolean storeDataToFile(String fileName, Map<Integer, Employee> data) throws IOException {

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            data.values().forEach(writer::println);
        }
        return true;
    }

    public static List<Employee> restoreDataFromFile(String fileName) throws FileNotFoundException, EmployeeHandlingException {
        List<Employee> list = new ArrayList<Employee>();

        File file = new File(fileName);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            throw new EmployeeHandlingException("The file with this name is not present");
        }
        try (Scanner fileScanner = new Scanner(file)) {

            while(fileScanner.hasNextLine()) {

                try (Scanner lineScanner = new Scanner(fileScanner.nextLine())) {
                    Employee emp = new Employee(lineScanner.nextInt(), lineScanner.next(), lineScanner.nextDouble());
                    list.add(emp);
                }
            }
        }
        return list;
    }
}
