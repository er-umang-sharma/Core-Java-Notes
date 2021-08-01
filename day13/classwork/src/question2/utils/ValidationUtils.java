package question2.utils;

import question2.cust_excs.EmployeeHandlingException;

public class ValidationUtils {

    private static final double MIN_SALARY;

    static {
        MIN_SALARY = 5000;
    }
    
    public static double validateSalary(double salary) throws EmployeeHandlingException {
        if (salary < MIN_SALARY)
            throw new EmployeeHandlingException("The salary must be more than 5000");
            return salary;
    }
}
