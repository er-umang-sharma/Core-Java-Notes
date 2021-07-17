package utils;

import com.app.core.Customer;
import cust_excs.CustomerHandlingException;
import static utils.ValidationUtils.*;

import java.text.ParseException;
import java.util.HashMap;

public class CollectionUtils {

    public static HashMap<String, Customer> populateData() throws CustomerHandlingException, ParseException {
        HashMap<String, Customer> hashMap = new HashMap<>();

        hashMap.put("email1@hotmail.com", new Customer(validateEmail("email1@hotmail.com"), validatePassword("Password@1"), validateRegAmount(1000), validateDateOfBirth("01/01/1990")));
        hashMap.put("email2@hotmail.com", new Customer(validateEmail("email2@hotmail.com"), validatePassword("Password@2"), validateRegAmount(2000), validateDateOfBirth("02/02/1990")));
        hashMap.put("email3@hotmail.com", new Customer(validateEmail("email3@hotmail.com"), validatePassword("Password@3"), validateRegAmount(3000), validateDateOfBirth("03/03/1990")));
        hashMap.put("email4@hotmail.com", new Customer(validateEmail("email4@hotmail.com"), validatePassword("Password@4"), validateRegAmount(4000), validateDateOfBirth("04/04/1990")));
        hashMap.put("email5@hotmail.com", new Customer(validateEmail("email5@hotmail.com"), validatePassword("Password@5"), validateRegAmount(5000), validateDateOfBirth("05/05/1990")));
        return hashMap;
    }
}
