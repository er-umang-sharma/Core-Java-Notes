# Classwork:

1. Create an abstract class called Employee with attributes: ID(auto-generated), name, dept, basic. Add toString, an abstract method- computeNetSalary(), and a getter for basic pay.

2. Create an extending class called Manager with it's own attributes- perfBonus. Override toString(), computeNetSalary() and a setter for perfBonus.

3. Create an extending class called Worker with it's own attributes- noOfHours & hourlyRate. Override toString(), computeNetSalary() and a setter for hourlyRate.

4. Create a tester which takes an employee array and stores either Manager or a Worker and depending on either, print perfBonus or hourlyRate.

# Assignment:

1. Design classes for the following requirement & add them  under the package "com.cdac.core"
    
    - Person: first name & last name'
    - Student: first name , last name ,graduation year, course name. 
        - Add introduce() method -> To Display only fName , grad year. 
        - Add feedback() a NEW method specific to Studentto display feedback (just display a standard mesg "Feedback submitted")

    - Faculty --first name , last name , yrs of experience, working domain
        - Add introduce() method -> To display last name & yrs of experience 
        - Add a NEW method evaluate()  -> To display student evaluation (just display "students evaluated")

    - Add suitable parameterized constrs & toString(to return complete details) to all of above classes.

    - Create EventOrganizer application (class) under "com.cdac.tester" package.
        - Allocate fixed capacity hall to org the event
        - Arrange an event for all faculties & students
        - Allocate Seat no whenever a person registers.

## Options: 
1. Register Faculty.
2. Register Student.
3. Display info of all registered members. 
4. Introduce yourself -> I/P Seat number O/P introduction mesg or error message (invalid seat no)
5. Submit Feedback or evaluation report -> I/P seat no , O/P if a student invoke feedback() method or
if its a faculty invoke evaluate() or err mesg (invalid seat no)
10. Exit


