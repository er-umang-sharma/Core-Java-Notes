package test;

import com.app.core.Customer;
import com.app.core.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MyConvertor {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String to find it's length:");
        String str = sc.nextLine();
        System.out.println("Converting from string to length:\nString: " + str + " Length: " + convert(str, string -> string.length()));

        System.out.print("Enter the String to convert the String into upper case:");
        str = sc.nextLine();
        System.out.println("Converting to the upper case:\nString: " + str + " Upper Case String: " + convert(str, string -> string.toUpperCase()));

        System.out.print("Enter the temperature in Celsius to convert to Fahrenheit: ");
        double celsius = sc.nextDouble();
        System.out.println("Celsius: " + celsius + " Fahrenheit: " + convert(celsius, cel -> cel * 9 /5 + 32));

        System.out.println("Enter the name and the marks in 5 subjects of the student:");
        Student student = new Student(sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("The GPA of " + student.getName() + " is: " + convert(student, ref -> (ref.getNumber1() + ref.getNumber2() + ref.getNumber3() + ref.getNumber4() + ref.getNumber5())/5));

        System.out.print("Enter a number to find it's square root:");
        double number = sc.nextDouble();
        System.out.println("The square root of " + number + " is: " + convert(number, num -> Math.sqrt(num)));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter the name, registration amount and the registration date:");
        Customer customer = new Customer(sc.next(), sc.nextDouble(), sdf.parse(sc.next()));
        System.out.println(customer.getName() + "'s registration date is: " + sdf.format(convert(customer, cust -> cust.getRegistrationDate())));

        if (sc != null)
            sc.close();
    }

    public static <F, T> T convert(F from, Convertable<F, T> ref) {
        return ref.convert(from);
    }
}
