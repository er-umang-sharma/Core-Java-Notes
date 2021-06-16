# Contents:
* [Interfaces](#interfaces)
* [Overriding 'equals()' method](#overriding_equals_method)
* [Abstract Classes vs Interfaces](#abstract_classes_vs_interfaces)

# Interfaces in Java:
<a name='interfaces'></a>

## What is interface ?
An interface in java is a blueprint of a class.  
It has `public static final` data members and `public abstract` methods only. Even if we don't write these while defining interfaces, the compiler will add these automatically.  

The interface in java is a mechanism to achieve abstraction fully. There can be only abstract methods in the java interface not method body(true till JDK 1.7). It is used to achieve full abstraction and multiple inheritance in Java.  
Java Interface also represents IS-A relationship.  
It cannot be instantiated just like abstract class.    

## Why Java Interfaces?
1. It is used to achieve full abstraction.  
2. By interface, we can support the functionality of multiple inheritance.  
3. It can be used to achieve loose coupling- Interfaces allow complete separation between WHAT(specification or a contract) is to be done Vs HOW (implementation details) it's to be done.  

__Example:__  
In JDBC (java db connectivity)  
java.sql.Connection i/f -> Sun Microsystems  
Implementing classes -> DB vendors:  
Oracle -> Oracle DB engine -> Implementation cls for Comnection i/f  
Red Hat -> Mysql -> Implementation cls for Connection i/f  

__NOTE:__ The java compiler adds public and abstract keywords before the interface method and public, static and final keywords before data members.  

__NOTE:__ The root of all interfaces is not the `java.lang.Object` class, as an interface cannot extend a class. But the interface has implicit access to all Object Class APIs.

# Syntax of interface:
```javascript
default(no modifier)/public interface <Name> extends <comma separated list of super i/fs> {
   //data members --- public static final
   int data=100;
   //methods -- public abstract
   double calc(double d1,double d2);
}
// Implementing class syntax:
default(no modifier)/public class <Name> extends <SuperCls> implements <comma separated list of  i/fs> {
   //Mandatory for imple class to be non-abstract(concrete): MUST define/imple all abstract methods from all i/fs.
}
```

## Example of implementing Interfaces:
1. Relationship between classes and interfaces:  
    A class extends another class, an interface extends another interface but a class implements an interface.  

2. Multiple inheritance in Java by interface: 
    If a class implements multiple interfaces, or an interface extends multiple interfaces i.e. known as multiple inheritance. Example:
    
```java
    interface Printable{  
        void print();  
    }  
    
    interface Showable{  
        void show();  
    }  
    
    class A implements Printable,Showable {
    
        @Override
        public void print() {
            System.out.println("Hello");
        }  
        
        @Override
        public void show() {
            System.out.println("Welcome");
        }  
        
        public static void main(String args[]) {
            A obj = new A();  
            obj.print();  
            obj.show();  
        }  
    }
```

__NOTE:__ Multiple inheritance is not supported through class in java but it is possible by interface, why?  
Multiple inheritance is not supported in case of class, since it can create an ambiguity. But it is supported in case of interface because there is no ambiguity as implementation is provided by the implementation class.  

__NOTE:__ In order to access a data member of the interface, the implementing class can directly access it, and a non-implementing class need to access it as it does for a Static data-member of a class.(<interface_name>.<data-member_name>). A lot of examples can be seen in the classwork of Day-5 and can be viewed here: [day-5 examples](https://github.com/er-umang-sharma/Core-Java-Notes/tree/master/day5/Classwork/src)  

__NOTE:__ If a class that is implementing an interface, it has to implement all the functions, or else it'll give a compiler error. To fix this, you have to make the implementing class as abstract class.  

__NOTE:__ When implementing more than one interfaces, we have to give the implementations of all the functions in all the implementing interfaces. And if we have the same constant data members in different interfaces, to reduce the ambiguity we have to use it by the syntax: `<interface name>.<data member name>`.  

__NOTE:__ When implementing more than one interfaces, if the signature of the function is different in those interfaces but with the same name, you will have to implement all those functions as overloaded functions in your implementing class. Example:
```java
// Interface 1
public interface Printable {
	double SIZE=10;
	void print();
}

//Interface 2
public interface Sortable {
		double SIZE=100;
		void print(int data);
}

//Implementing class
public class MyImpleClass implements Printable, Sortable {
	@Override
	public void print() {
		System.out.println("in my print " + Sortable.SIZE);
	}
	@Override
	public void print(int data) {
		System.out.println("in overloaded print with int");	
	}	
}
```

__NOTE:__ When implementing more than one interfaces, if the signature and the name of the function is same in those interfaces but with different return types, the implementing class will show a compiler error, as the compiler cannot differentiate between those. 
```java
// Interface 1
public interface Printable {
	double SIZE=10;
	void print();
}

//Interface 2
public interface Sortable {
		double SIZE=100;
		int print();
}

//Implementing class
public class MyImpleClass implements Printable, Sortable {
	@Override
	public void print() {
		System.out.println("in my print " + Sortable.SIZE);
	}
}
```
This cannot be done and the error is:
```output
.\p4\MyImpleClass.java:3: error: MyImpleClass is not abstract and does not override abstract method print() in Printable
public class MyImpleClass implements Printable, Sortable {
       ^
.\p4\MyImpleClass.java:7: error: print() in MyImpleClass cannot implement print() in Printable
        public void print() {
                    ^
  return type void is not compatible with int
2 errors
```
__NOTE:__ If an interface extends another interface and you're implementing the sub-interface, you have to implement the definition of all the methods in the sub-interface as well as super-interface. Example:
```java
//Interface 1
public interface A {
	double calc(double d1,double d2);
}

//Interface 2
public interface B extends A{
	void show();
}

//Implementing class
public class C implements B{

	@Override
	public double calc(double d11, double d12) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub	
	}
}
```

__NOTE:__ In java, a single class can extend only one class, but an interface can extend more than one interfaces. Example:
```java
//Interface 1
public interface A {
	double calc(double d1,double d2);
}

//Interface 2
public interface B {
	void show();
}

//Interface 3
public interface B1 extends A, B {
  void test();
}

//Implementing class
public class C implements B1{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calc(double d1, double d2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub	
	}
}
```
## Marker or tagged interface:
An interface that have no member is known as marker or tagged interface. For example: Serializable, Cloneable, Remote etc.. They are used to provide some essential information to the JVM(Run time marker)  so that JVM may perform some useful operation.  
```java
//How Serializable interface is written?  
public interface Serializable{  
}  
```
## Nested Interface in Java:
Note: An interface can have another interface i.e. known as nested interface. 

```java
interface printable{  
 void print();  
 interface MessagePrintable{  
   void msg();  
 }  
}  
```
# Overriding `equals()` method:
<a name='overriding_equals_method'></a>

- `equals()` method is another important API from the Object class that needs to be overridden.  
- The need for that is that when comparing two objects for equality, we want the objects to be compared on the basis of the parameters we define which by default compares hashcode of the two objects, and even though the two objects' contents are same, it'll show them as not equal.  
- Here `@Override` annotation has to be given or else the compiler will think this is an overloaded method since the signature is different compared to the definition given in the class definition and the compiler doesn't implement co-variance directly, and matches more to the `equals()` method of `java.lang.Object`.  
- __Important meaning:__ Returns true in case of reference equality. Syntax:
```java
class Employee {
    //... Rest of the employee class defination

    /** Compare two Employees based on their IDs and Employee IDs
    ID: int
    empID: String
    */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee)o;
        return id == e.id && empID.equals(e.empID);
    }
}
```

## Use case:
Modify the Event Organizer class(done in day4 assignment) to check whenever a person registers, is this a duplicate entry, or a new one. And give the message appropriate to that. The equality comparison should be done on first name and last name.  
The code implementation for that is:  
__Core Classes:__  

- [Person.java](./Classwork/src/com/cdac/core/Person.java)  
- [Faculty.java](./Classwork/src/com/cdac/core/Faculty.java) extending Person class from [Person.java](./Classwork/src/com/cdac/core/Person.java)  
- [Student.java](./Classwork/src/com/cdac/core/Student.java) extending Person class from [Person.java](./Classwork/src/com/cdac/core/Person.java)  

__EventOrganizer Class:__  
- [EventOrganizer.java](./Classwork/src/com/cdac/tester/EventOrganizer.java)  

# Abstract Classes vs Interfaces:
<a name='abstract_classes_vs_interfaces'></a>

Abstract class and interface both are used to achieve abstraction where we can declare the abstract methods.  
Abstract class and interface both can't be instantiated.  
But there are many differences between abstract class and interface:  

1. Abstract class can have abstract and non-abstract methods.	Interface can have only abstract methods.  
2. Abstract class doesn't support multiple inheritance.	Interface supports multiple inheritance.  
3. Abstract class can have final, non-final, static and non-static variables.	Interface has only public,static and final variables.  
4. Abstract class can have static methods, main method and constructor.	Interface can't have static methods, main method or constructor.  
5. Abstract class can provide the implementation of interface.	Interface can't provide the implementation of abstract class.  
6. The abstract keyword is used to declare abstract class. The interface keyword is used to declare interface.  
7. Example:
```java
public abstract class Shape{
public abstract void draw();
}	Example:
public interface Drawable{
void draw();
}
```
Simply, abstract class achieves partial abstraction (0 to 100%) whereas interface achieves abstraction fully(100%).  

__NOTE:__ In order for a class to implement an interface, it must implement all its declared methods. However, a class may not implement all declared methods of an abstract class. Though, in this case, the sub-class must also be declared
as abstract. Abstract classes can implement interfaces without even providing the implementation of interface methods.  