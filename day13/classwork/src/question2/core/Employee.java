package question2.core;

public class Employee {

    private int employeeID;
    private String name;
    private double salary;
    private static int employeeIDGenerator;

    static {
        employeeIDGenerator = 1000;
    }

    public Employee(String name, double salary) {
        this.employeeID = employeeIDGenerator++;
        this.name = name;
        this.salary = salary;
    }

    public Employee(int employeeID, String name, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public static int getEmployeeIDGenerator() {
        return employeeIDGenerator;
    }

    @Override
    public String toString() {
        return employeeID + " " + name + " " + salary;
    }
}