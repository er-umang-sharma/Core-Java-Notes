package question2.utils;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import question2.core.Employee;
import question2.cust_excs.EmployeeHandlingException;
import static question2.utils.ValidationUtils.*;

public class CollectionUtils {
    
    public static Map<Integer, Employee> populateData() throws EmployeeHandlingException{

        Map<Integer, Employee> map = new HashMap<Integer, Employee>();

        map.put(Employee.getEmployeeIDGenerator(), new Employee("user1", validateSalary(10000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user2", validateSalary(20000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user3", validateSalary(30000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user4", validateSalary(40000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user5", validateSalary(50000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user6", validateSalary(60000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user7", validateSalary(70000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user8", validateSalary(80000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user9", validateSalary(90000)));
        map.put(Employee.getEmployeeIDGenerator(), new Employee("user10", validateSalary(100000)));
        return map;
    }

    public static List<Employee> getsortData(Map<Integer, Employee> map) {

        List<Employee> list = new ArrayList<Employee>(map.values());

        Collections.sort(list, (emp1, emp2) -> ((Double)emp1.getSalary()).compareTo(emp2.getSalary()));
        return list;
    }
}
