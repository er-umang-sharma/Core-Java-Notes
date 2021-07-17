package utils;

import com.app.core.BankAccount;
import static utils.ValidationUtils.*;

import java.util.HashMap;

public class CollectionUtils {

    public static HashMap<Integer, BankAccount> populateMap() {
        HashMap<Integer, BankAccount> map = new HashMap<>();

        try {

            map.put(BankAccount.accountIdGenerator, new BankAccount( "name1", 10000, validateDate("01/01/2001"), validateAccountType("SAVINGS")));
            map.put(BankAccount.accountIdGenerator, new BankAccount("name2", 20000, validateDate("02/02/2002"), validateAccountType("CURRENT")));
            map.put(BankAccount.accountIdGenerator, new BankAccount("name3", 30000, validateDate("03/03/2003"), validateAccountType("DMAT")));
            map.put(BankAccount.accountIdGenerator, new BankAccount( "name4", 40000, validateDate("04/04/2004"), validateAccountType("NRE")));
            map.put(BankAccount.accountIdGenerator, new BankAccount( "name5", 50000, validateDate("05/05/2005"), validateAccountType("FD")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
