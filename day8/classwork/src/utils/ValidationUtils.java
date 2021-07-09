package utils;

import com.app.core.AccountType;
import cust_excs.AccountHandlingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ValidationUtils {

    private static final int MIN_BALANCE;
    private static final SimpleDateFormat sdf;
    static {
        MIN_BALANCE = 1000;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public static double validateBalance(double balance) throws AccountHandlingException {
        if (balance < MIN_BALANCE)
            throw new AccountHandlingException("The account balance cannot be less than Rs 1000");
        return balance;
    }

    public static Date validateDate(String dob) throws AccountHandlingException {
        try {
            Date dateOfBirth = sdf.parse(dob);
            Date dateToCheck = new GregorianCalendar(2003, 1, 1).getTime();
            if (dateOfBirth.after(dateToCheck))
                throw new AccountHandlingException("The candidate should be more than 18 years old.");
            return dateOfBirth;
        } catch (ParseException e) {
            throw new AccountHandlingException("The date entered is not parsable, ie., in not a valid format.");
        }
    }

    public static AccountType validateAccountType(String accType) throws AccountHandlingException{
        try {
            AccountType accountType = AccountType.valueOf(accType);
            return accountType;
        } catch (IllegalArgumentException e) {
            throw new AccountHandlingException("The bank Account Type specified is not present");
        }
    }
}
