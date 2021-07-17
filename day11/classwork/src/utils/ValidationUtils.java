package utils;

import com.app.core.AccountType;
import cust_excs.AccountHandlingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationUtils {

    private static final double MINIMUM_BALANCE;
    public static final SimpleDateFormat sdf;
    static {
        MINIMUM_BALANCE = 1000;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public static double validateBalance(double balance) throws AccountHandlingException {
        if (balance < MINIMUM_BALANCE)
            throw new AccountHandlingException("The balance cannot be less than the minimum balance");
        return balance;
    }

    public static Date validateDate(String date) throws ParseException {
        return sdf.parse(date);
    }

    public static AccountType validateAccountType(String accountType) throws IllegalArgumentException {
        return AccountType.valueOf(accountType);
    }
}
