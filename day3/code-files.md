# ClassWork:

1. Write a program to enter n elements of primitive data in an array and print it.

2. Write a program to enter n elements of reference data in an array and print it.

3. Create a core class called Person with attributes- fname, and lname and add a toString() method to that class. Extend it with a class called Student with it's own attribute- gradYear and a toString(). Test it by creating a Tester class and creating a Student class Object.

# Assignment: 


1. Create Point class Point2D  in package "drawing.basic" : for representing a point in x-y co-ordinate system.

    * Create a parameterized constructor to accept x & y co-ords.
    Add show method to Point2D class : to return  the x & y coords .(public String show())

    * Add isEqual method to Point2D class : boolean returning method : must ret. true if both points are having same x,y co-ords or false otherwise. : 

    * Add a method to Point2D class -- to create and return new point having given x & y offset. (eg Point2D createNewPoint(int xOffset,int yOffset))

    * Add calculateDistance method to calculate distance between current point & specified point & return the distance to the caller. (eg double  calcDistance(Point2D p2)) Hint : API of java.lang.Math class --pow & sqrt

    * Write TestPoints class with a main method, in "drawing.tester". Accept how many points to create from  user (Scanner) & create suitable array.

    * Populate array by accepting point co ordinates.

    * Use show method to display point details of all created points

    * I/P from User -- 1st & 2nd point eg : Enter 2 points 

    * Invoke isEqual & display if 1st point & 2nd point are having same co ordinates or different

    * I/P from User -- 1st & 2nd point. Display distance between 2 points.