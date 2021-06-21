package util;

import cust_excs.CustomerHandlingException;

public class ValidationRules {

    private static final int EMAILMINLEN, EMAILMAXLEN;
    static {
        EMAILMINLEN = 5;
        EMAILMAXLEN = 10;
    }

    public static String validateEmail(String email) throws CustomerHandlingException {
        if (email.length() < EMAILMINLEN || email.length() > EMAILMAXLEN)
            throw new CustomerHandlingException("The email is not of valid length. It should be between 5 and 10");
        return email;
    }

    public static String validatePassword(String password) throws CustomerHandlingException {
        if ( !password.contains("@"))
            throw new CustomerHandlingException("The password must contain @ and a special character.");
        return password;
    }

    public static double validateRegAmount(double regAmount) throws CustomerHandlingException {
        if (regAmount % 500 != 0 && regAmount < 500)
            throw new CustomerHandlingException("The registration amount should be a multiple of 500 and should be more than 500");
        return regAmount;
    }
}
