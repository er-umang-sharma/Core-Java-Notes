# Classwork:
- Create an Enum of type AccountType. The attributes of the enum are: SAVINGS, CURRENT, DMAT, FD, NRE
- Create the base class of Bank Account. Data members
    - accId - int
    - name - String
    - balance - double
    - dateOfBirth - Date
    - type - AccountType
- Create a custom exception class for account handling
- Create a utility class with validation utility functions that include:
    - validateBalance() - balance should be more than the minimum balance of 1000
    - validateDate() - the age should be more than 18 years of age
    - validateAccountType() - the account type should be one of the account types listed above
- Create a tester class to create a new account.

# Assignment:
Continue with Day 7 Customer class , ValidationRules & custom exception.
Write a Tester for customer registration
I/P --email , password , reg amount & reg date.
O/P -- Success mesg or error message via catch block.
(In case of no validation errs , add customer info to the suitable ArrayList)