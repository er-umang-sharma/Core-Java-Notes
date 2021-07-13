package utils;

import com.app.core.Customer;
import cust_excs.CustomerHandlingException;

import static utils.ValidationUtils.*;

import java.text.ParseException;
import java.util.ArrayList;

public class CollectionUtils {

    public static ArrayList<Customer> populateData() throws CustomerHandlingException, ParseException {
        ArrayList<Customer> list = new ArrayList<>();
        list.add(new Customer( validateEmail("email@1"), validatePassword("password@1"), validateRegAmount(1000), validateDateOfBirth("01/01/1990")));
        list.add(new Customer( validateEmail("email@3"), validatePassword("password@3"), validateRegAmount(3000), validateDateOfBirth("03/01/1990")));
        list.add(new Customer( validateEmail("email@5"), validatePassword("password@5"), validateRegAmount(5000), validateDateOfBirth("05/01/1990")));
        list.add(new Customer( validateEmail("email@2"), validatePassword("password@2"), validateRegAmount(2000), validateDateOfBirth("02/01/1990")));
        list.add(new Customer( validateEmail("email@4"), validatePassword("password@4"), validateRegAmount(4000), validateDateOfBirth("04/01/1990")));
        return list;
    }
}
