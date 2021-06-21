# Classwork:
Implement an Employee management tool with proper exception handling and validation.

## Employee:  
### Attributes: name, email, department, basic.

## Validation Rules:
- The length of the name should be between 4 and 10 characters long
- The email should be of the same length and should also contain a '@' character.
- The department can be one of the below:
    - HR
    - RnD
    - Marketing
    - IT
- The basic pay should not be less than minimum pay.

## Implement a Tester class that implements the following:
- Write a menu driven program with menu items:
    - Hire an employee
    - Dislpay Info
    - Exit

# Assignment:
1. Create core class Customer in  package "com.app.core".
### Attributes: email, password, reg amount. constr/s, toString, equals method(email)
2. Create Custom exception class CustomerHandlingException , in package "cust_excs"
3. Create ValidationRules class under "util" package
    1. email id must be between 5 to 10 chars.                                      
    2. password must be alphanumeric & should contain sepcial char. (Hint : Use String class's public boolean matches(String r
    3. reg amount must be in the multiples of 500.                                  
4. Create a tester "TestCustomer" class in "tester" package
    Options:
    1. Register new customer-> Accept customer details , call validation rules & supply proper error handling.
    2. Display Customer list
    10. Exit