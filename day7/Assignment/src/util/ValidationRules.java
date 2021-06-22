package util;

import cust_excs.CustomerHandlingException;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

public class ValidationRules {

    private static SimpleDateFormat sdf;
    private static final int EMAIL_MIN_LEN, EMAIL_MAX_LEN;

    static {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        EMAIL_MIN_LEN = 5;
        EMAIL_MAX_LEN = 10;
    }

    public static String validateEmail(String email) throws CustomerHandlingException {
        if (email.length() < EMAIL_MIN_LEN || email.length() > EMAIL_MAX_LEN)
            throw new CustomerHandlingException("The email is not of valid length. It should be between 5 and 10 characters long.");
        return email;
    }

    public static String validatePassword(String password) throws CustomerHandlingException {
        if (!password.contains("@"))
            throw new CustomerHandlingException("The password must contain a @ symbol.");
        return password;
    }

    public static double validateRegAmount(double regAmount) throws CustomerHandlingException {
        if (regAmount % 500 != 0)
            throw new CustomerHandlingException("The registration amount should be a multiple of 500.");
        return regAmount;
    }

    public static Date validateDateOfBirth(String dob) throws CustomerHandlingException, ParseException {
        Date dateOfBirth = sdf.parse(dob);
        Date date = new GregorianCalendar(2003, 01, 01).getTime();
        if (dateOfBirth.after(date))
            throw new CustomerHandlingException("The candidate should be more than 18 years old.");
        return dateOfBirth;
    }

}