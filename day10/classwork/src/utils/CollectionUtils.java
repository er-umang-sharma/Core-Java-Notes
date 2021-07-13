package utils;

import com.app.core.BankAccount;
import cust_excs.AccountHandlingException;

import static utils.ValidationUtils.*;

import java.util.ArrayList;

public class CollectionUtils {

    public static ArrayList<BankAccount> populateData() throws AccountHandlingException {

        ArrayList<BankAccount> list = new ArrayList<>();
        list.add(new BankAccount("abc",20000, validateDate("21/3/1990"), validateAccountType("savings")));
        list.add(new BankAccount("abc5", 10000, validateDate("1/2/1991"), validateAccountType("current")));
        list.add(new BankAccount("abc2",  120000, validateDate("1/5/1956"), validateAccountType("savings")));
        list.add(new BankAccount("abc4", 110000, validateDate("11/6/2000"), validateAccountType("fd")));
        return list;
    }
}
