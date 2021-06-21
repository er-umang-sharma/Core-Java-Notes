package com.app.util;

import cust_excps.EmployeeHandlingException;

public class ValidationUtils {

    private static final int MIN_LENGTH, MAX_LENGTH;
    private static final double MIN_BASIC;

    static {
        MIN_LENGTH = 4;
        MAX_LENGTH = 10;
        MIN_BASIC = 5000;
    }

    public static void validateEmployeeName(String name) throws EmployeeHandlingException {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH)
            throw new EmployeeHandlingException("The length of the name is not of valid length.");
        System.out.println("Name validated.");
    }

    public static void validateEmployeeEmail(String email) throws EmployeeHandlingException {
        if (email.length() < MIN_LENGTH || email.length() > MAX_LENGTH || !email.contains("@"))
            throw new EmployeeHandlingException("The email you entered is not valid.");
        System.out.println("Email validated.");
    }

    public static void validateDepartment(String deptId) throws EmployeeHandlingException {
        switch (deptId) {
            case "RND":
            case "HR":
            case "MKTG":
            case "IT":
                System.out.println("Department validated.");
                break;
            default:
                throw new EmployeeHandlingException("The department entered is not valid.");
        }
    }

    public static void validateBasic(double basic) throws EmployeeHandlingException {
        if (basic < MIN_BASIC)
            throw new EmployeeHandlingException("The basic entered is not valid.");
        System.out.println("Basic validate.");
    }
}
