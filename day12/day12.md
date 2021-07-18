# Contents

- [Type erasure with Generics](#type_erasure_with_generics)
- [Java 8 Features](#java_8_features)

## Type erasure with generics

<a name='type_erasure_with_generics'></a>

Generics was added to provide type-checking at compile time and it has no use at run time, so java compiler uses type erasure feature to remove all the generics type checking code in byte code and insert type-casting if necessary. Type erasure ensures that no new classes are created for parameterized types; thus unlike c++ templates , generics incur no code bloating.

For example if we have a generic class like below;

```java
public class Test<T> {

    private T data;
    public Test(T d) {
        this.data = d;
       
    }

    public T getData() { return this.data; }
}
```

-------------

```java
public class Test<T extends Comparable<T>> {

    private T data;
    public Test(T d) {
        this.data = d;
    }

    public T getData() { return this.data; }
}
```

### What will the above code be in byte code?

The Java compiler replaces the bounded type parameter T with the first bound interface, Comparable, as below code:

```java
public class Test {

    private Comparable data;
    public Test(Comparable d) {
        this.data = d;
    }

    public Comparable getData() { return data; }
}
```

## Java 8 Features

<a name='java_8_features'></a>

### Addition of `default` keyword to add default method implementation, in interfaces

Java 8 enables us to add non-abstract(concrete) method implementations to interfaces by utilizing the default keyword. This feature is also known as Extension Methods.

#### Why default keyword ?

1. To maintain backward compatibility with earlier Java SE versions, so the implementing class of this i/f doesn't have to provide the defination for every newly implemented functionality.
2. To avoid implementing new functionality in all implementation classes.
eg : Java added in `Iterable<T>` interface `default void forEach(Consumer<? super T> action)` as a default method implementation

eg :

```java
interface Formula {
    double calculate(double a);

    default double sqrt(double a,double b) {
        return Math.sqrt(a+b);
    }
}
```

__NOTE:__ The default method can be overriden as well, if a change to the defination is needed. In case of ambiguity or to refer to default implementation from i/f -> use `InterfaceName.super.methodName(...)` syntax.
e.g.:

```java
// Interface:
public interface Formula {

    //public abstract
    double calculateSquare(double number);
    //public
    default double calculateSquareRoot(double number) {
        return Math.sqrt(number);
    }
}

// Implementing Class:
public class MyFormula implements Formula {
    
    @Override
    public double calculateSquare(double number) {
        return number * number;
    }

    @Override
    public double calculateSquareRoot(double number) {
        System.out.println("Printing Square root using the default function.");

        // Calling the interface's default method using the super keyword.
        return Formula.super.calculateSquareRoot(number);
    }
}
```

__NOTE:__ When we have two duplicate default methods in two or more interfaces and are implemented by a class, then an ambiguity arises as to which method to choose. So, in this case the implementing class must override the method, and in the defination of the overridden method, it can call the intended default method.
e.g.:

```java
//Interface 1:
public interface Formula1 {

    //public abstract
    double calculateSquare(double number);

    // public
    default double calculateSquareRoot(double number) {
        System.out.println("Formula 1 default mehtod.");
        return Math.sqrt(number);
    }
}

//Interface 2:
public interface Formula2 {

    //public abstract
    double calculateSquare(double number);

    // public
    default double calculateSquareRoot(double number) {
        System.out.println("Formula 2 default mehtod.");
        return Math.sqrt(number);
    }
}

//Implementing class:
public class MyFormula implements Formula1, Formula2 {

    //Overriding it once works because, this method will work as implementation of both the abastract mehtods.
    @Override
    public double calculateSquare(double number) {
        return number * number;
    }

    //Mandatory to override this to remove ambiguity.
    @Override
    public double calculateSquareRoot(double number) {
        return Formula1.super.calculateSquareRoot(number);
    }
}

```

__NOTE:__ For two interfaces, if they have methods with same signature, we can override just one method, which will server as the implementation of both the methods. But if the signature is same, and the return type is different of those two methods, it will not work as they are incompatible.

### Can add static methods in Java Interfaces

- It's a better alternative to writing static library methods in helper class(e.g. Arrays or Collections).
- Such static methods can't be overridden in implementation class. BUT can be re-declared.
- They have to be invoked using interface ref , even in implementation or non implementation classes.

Example:

```java
//Interface:
public interface Formula {

    //public static final
    int data = 5;

    //public abstract
    double calculateSquare(double number);

    //public
    default double calculateSquareRoot(double number) {
        System.out.println("Default method impementation");
        return Math.sqrt(number);
    }

    //public
    static void show() {
        System.out.println("Interface's Static method invoded.");
    }
}

//Implementing class:
public class MyFormula {

    @Override
    public double calculateSquare(double number) {
        System.out.println("Overridden calculateSquare method");
        return number * number;
    }

    @Override
    public double calculateSquareRoot(double number) {
        System.out.println("Overridding Default method.");
        return Formula.super.calculateSquareRoot(number);
    }

    //@Override -> Error, as static method cannot be overrridden.
    //This is redeclaring the method.
    public static void show() {
        System.out.println("Class's static method invoked.");
    }
}
```

To use the above two static methods, we'll have to use: `<classname/interfacename>.<methodName>()`. Example:

```java
public class TestDefMethods {
    public static void main(String[] args) {
        Formula f = new MyFormula();    //Upcasting -> Interface's reference can store implmenting class' object.
        System.out.println(f.calculateSquare(10));
        /*
        O/P:
        Overridden calculateSquare method
        100
        */
        
        System.out.println(f.calculateSquareRoot(100));
        /*
        O/P:
        Overridding Defualt method.
        Default method implementation
        10
        */

        f.show();   //Compiler error, as we cannot call a static method as a reference to an object.

        MyFormula.show();
        /*
        O/P:
        Class's static method invoked.
        */

        Formula.show();
        /*
        O/P:
        Interface's Static method invoded.
        */
    }
}
```
