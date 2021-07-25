# Day 13

## Contents

- [Method reference in Java](#method_reference_in_java)
- [Java Streams](#java_streams)

## Method reference in Java

<a name='method_reference_in_java'></a>

Anonymous class's reduction form is lambdas, and in certain cases the lambda expressions can be further reduced to something called as **Method Reference**. A method reference is the shorthand syntax for a lambda expression that executes just ONE method. So, **Method references are a special type of lambda expressions.** They're often used to create simple lambda expressions by referencing existing methods.

General syntax of a method reference:

```output
Class/Object :: methodName
```

If the lambda expression is really just a call to some method, for example:

```java
List<String> l1=Arrays.asList("aa","bb","cc");
l1.forEach(s -> System.out.println(s));

```

Then, to make the code clearer, replace it by method reference:

```java
l1.forEach(System.out::println);
```

In a method reference, you place the object (or class) that contains the method before the :: operator and the name of the method after it without arguments.

There are four kinds of method references:

1. Static methods
2. Instance methods of particular objects
3. Instance methods of an arbitrary object of a particular type
4. Constructors

### 1. Static methods

We'll begin with a very simple example, capitalizing and printing a list of Strings:

```java
List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
```

We can achieve this by leveraging a simple lambda expression calling the StringUtils.capitalize() method directly:

```java
messages.forEach(word -> StringUtils.capitalize(word));
```

Or, we can use a method reference to simply refer to the capitalize static method:

```java
messages.forEach(StringUtils::capitalize);
```

### 2. Reference to an Instance Method of a Particular Object

To demonstrate this type of method reference, let's consider two classes:

```java
public class Bicycle {

    private String brand;
    private Integer frameSize;
    // standard constructor, getters and setters
}

public class BicycleComparator implements Comparator {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}
```

And, let's create a BicycleComparator object to compare bicycle frame sizes:

```java
BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
```

We could use a lambda expression to sort bicycles by frame size, but we'd need to specify two bikes for comparison:

```java
createBicyclesList().stream()
  .sorted((a, b) -> bikeFrameSizeComparator.compare(a, b));
```

Instead, we can use a method reference to have the compiler handle parameter passing for us:

```java
createBicyclesList().stream()
  .sorted(bikeFrameSizeComparator::compare);
```

The method reference is much cleaner and more readable, as our intention is clearly shown by the code. Another example of this is:

```java
list1.forEach(System.out::println);
```

### 3. Reference to an Instance Method of an Arbitrary Object of a Particular Type

This type of method reference is similar to the previous example, but without having to create a custom object to perform the comparison.

Let's create an Integer list that we want to sort:

```java
List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
```

If we use a classic lambda expression, both parameters need to be explicitly passed, while using a method reference is much more straightforward:

```java
// Using lambdas:
numbers.stream()
  .sorted((a, b) -> a.compareTo(b));

// Using method reference:
numbers.stream()
  .sorted(Integer::compareTo);
```

Even though it's still a one-liner, the method reference is much easier to read and understand.

### 4. Reference to a Constructor

We can reference a constructor in the same way that we referenced a static method in our first example. The only difference is that we'll use the new keyword.

Let's create a Bicycle array out of a String list with different brands:

```java
List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
```

First, we'll add a new constructor to our Bicycle class:

```java
public Bicycle(String brand) {
    this.brand = brand;
    this.frameSize = 0;
}
```

Next, we'll use our new constructor from a method reference and make a Bicycle array from the original String list:

```java
bikeBrands.stream()
  .map(Bicycle::new)
  .toArray(Bicycle[]::new);
```

Notice how we called both Bicycle and Array constructors using a method reference, giving our code a much more concise and clear appearance.

### Additional Examples and Limitations

As we've seen so far, method references are a great way to make our code and intentions very clear and readable. However, we can't use them to replace all kinds of lambda expressions since they have some limitations.

Their main limitation is a result of what's also their biggest strength: **the output from the previous expression needs to match the input parameters of the referenced method signature.**

Let's see an example of this limitation:

```java
createBicyclesList().forEach(b -> System.out.printf(
  "Bike brand is '%s' and frame size is '%d'%n",
  b.getBrand(),
  b.getFrameSize()));
```

This simple case can't be expressed with a method reference, because the printf method requires 3 parameters in our case, and using createBicyclesList().forEach() would only allow the method reference to infer one parameter (the Bicycle object).

**Finally, let's explore how to create a no-operation function that can be referenced from a lambda expression.**

In this case, we'll want to use a lambda expression without using its parameters.

First, let's create the doNothingAtAll method:

```java
private static <T> void doNothingAtAll(Object... o) {
}
```

As it is a varargs method, it will work in any lambda expression, no matter the referenced object or number of parameters inferred.

Now, let's see it in action:
freestar

```java
createBicyclesList()
  .forEach((o) -> MethodReferenceExamples.doNothingAtAll(o));
```

### Overview of the Method Reference

| Method Reference | Description | Example |
| ------ | ----- | ------- |
| Reference to **Static method** | Used to refer static methods from a Class | `Math:max` equivaluent to `Math.max(x, y)` |
| Reference to **instance method from instance** | Refer to an instance method using a reference to the supplied object | `System.out::println` is equivaluent to `System.out.println(x)` |
| Reference to **instance method from class type** | Invode the instance method on a reference to an object supplied by the context | `String::lenth` equivaluent to `str.length()` |
| Reference to **constructor of a class** | Refernce to a constructor | `ArrayList::new` equivaluent to `new ArrayList()` |

__NOTE:__ All Lambda expressions cannot be replaced by Method reference. The general rule is: If your lambda body is just calling another method by passing same arguments as lambda arguments, then we can convert Lambdas to Method References.

## Java Streams

<a name='java_streams'></a>

Since Java 8, there is a separate package added- `java.util.streams` which contain all the Streams. Collection refers to a collection of references which are stored or which exists in memory. Whereas in case of streams, it actually operates on data which is inflowing and the entire data to be operated upon is not in memory.

### Collections vs Streams

| Collections | Streams |
| ------ | ------- |
| Collections(Set/List/Map) actually stores the element(i.e., references) | Doesn't store all the elements(represents only sequece of operations to be performed on elements) |
| Suppert add/remove operations(API supports) | Stream API doesn't support add/remove operations |
| Eagerly Evaluated | Lazily Evaluated |
| Supports external iteration(using for-each/iterators) | Supports internal iteration |
| Doesn't support easy way of concurrent handling | Easy way of parallel processing |
| Can be iterated over multiple times | Can't be iterated over multiple time, i.e., can be processed only once |
| Doesn't support aggregate functionality(e.g. match, filter, count, limit, reduce, flatMap, ...) | Supports functional features like match, filter, ... |

### What is a Stream?

Out of the above, sum() is a terminal operation, rest are the intermedi

A sequence of elements from a source that supports data processing operations.

- Sequence of elements - Like a collection, a stream provides an interface to a sequenced set of values of a specific type.
- Source - Streams refer to collections, arrays, or I/O resources.
- Data processing operations:- Supports  common operations from functional programming languages. e.g. filter, map, reduce, find, match, sort, etc.

They have nothing to do with `java.io`: `InputStream` or `Outputstream`.

The Streams also support Pipelining and Internal Iterations. The Java 8 Streams are designed in such a way that most of its stream operations returns Streams only. This help us creating chain of various stream operations. This is called as __Pipelining of Streams__. The pipelined operations looks similar to a sql query.(or Hibernate Query API)

Concurrency is IMPORTANT. So, Java 8 goes one more step ahead and has developed a Streams API which allows us to use  multi cores easily.

Parallel processing = divide a larger task into smaller sub tasks (forking), then processing the sub tasks in parallel and then  combining the results together to get the final output (joining). The heart of parallel programming in Java is __Fork/Join Framework__.

Java 8 Streams API provides a similar mechanism to work with Java Collections.

The Java 8 Streams concept is based on converting Collections to a Stream (or arrays to a stream) , processing the elements in parallel and then gathering the resulting elements into a Collection.

Example of Streams:

```java
int sum = widgets.stream()
                  .filter(w -> w.getColor() == RED)
                  .mapToInt(w -> w.getWeight())
                  .sum();
```

Out of the above, `sum()` is the terminal operation, rest are the intermediate operation. `streams()` returns a stream from a collection, an array or an IO device. `filter()` method returns another stream. `mapToInt()` returns an interger stream to put aggeregation operations/functions on it.

The above chaining of streams is called __Pipelining of Streams__.

The `filter()`, `map()` & `reduce()` are primarily used in BigData operations, as it needs concurrent processing of high volumes of data.

__NOTE:__ When writing stream operations, we must keep in mind that unless and until we apply terminal operations to a pipeline, it'll not be processed by the JVM. This is called __Lazy Evaluation of Streams__.

### API of Streams

The starting point is `java.util.streams.Stream` interface. Different ways of creating streams:

1. Can be created of any type of Collection (Collections, List, Set):
  
    `java.util.Collection<E>` API:

    - `default Stream<E> stream()`
    - `public default Stream<E> parallelStream()`

    __NOTE:__ Java Streams cannot be re-used and will raise `IllegalStateException`. The same will happen if we try to use a Stream after a terminal operation.

    Example: Display all elements of an ArrayList using forEach streams method:

    ```java
    List<Integer> l1 = Arrays.asList(1, 23, 45, 2, 40, 4);
    System.out.println("Elements of the ArrayList:");
    l1.stream().forEach(System.out::println);
    ```

    The above code can also be divided into two different statements:

    ```java
    List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    Stream<Integer> strm1 = l1.stream();
    System.out.println("Printing elems via seq stream lambda ");
    strm1.forEach(i -> System.out.print(i + " "));
    ```

    After the above code operations, if we're using the streams again, it'll give us illegal state exception. So, after forEach in both the cases, we cannot put another forEach, as it's a terminal operation. Formal way of saying this:

    __Streams are Consumable, and thus cannot be re-used after it's termial operation is run.__

    __Difference between Sequential and Parallel Streams Execution:__

    ```java
    List<Integer> l1 = Arrays.asList(1, 23, 45, 2, 40, 4);
    System.out.println("Printing elements via sequential stream:");
    // Printing the name of the thread, which is executing the code
    l1.stream().forEach(i -> {
      System.out.println(Thread.currentThread().getName() + " " + i);
    });
    ```

    The output ot the above code:

    ```output
    Printing elements via sequential stream:
    main 1
    main 23
    main 45
    main 2
    main 40
    main 4
    ```

    ```java
    List<Integer> l1 = Arrays.asList(1, 23, 45, 2, 40, 4);
    System.out.println("Printing elements via parallel stream:");
    // Printing the name of the thread, which is executing the code
    l1.parallelStream().forEach(i -> {
      System.out.println(Thread.currentThread().getName() + " " + i);
    });
    ```

    The output of the above code:

    ```output
    Printing elements via parallel stream: 
    main 2
    ForkJoinPool.commonPool-worker-19 23
    ForkJoinPool.commonPool-worker-23 1
    ForkJoinPool.commonPool-worker-19 40
    ForkJoinPool.commonPool-worker-9 45
    ForkJoinPool.commonPool-worker-5 4
    ```

2. Stream of Array:

    How to create streams from Arrays? By using `java.util.Arrays` class API:

    `public static <T> Stream<T> stream(T[] array)`: Returns a sequential Stream with the specified array as its source.

3. Can be attached to Map, via entrySet method. The stream will be attached to the entrySet method:

    `map.entrySet().stream()`.

4. To create streams out of three primitive types: int, long and double. As `Stream<T>` is a generic interface , can't support primitives. So  IntStream, LongStream, DoubleStream are added.

    API of `java.util.stream.IntStream`:

    - `static IntStream of(int... values)`: Returns a sequential ordered stream whose elements are the specified values.

    - `static IntStream range(int startInclusive,int endExclusive)`: Returns a sequential ordered IntStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.

    - `static IntStream rangeClosed(int startInclusive,int endInclusive)`: Returns a sequential ordered IntStream from startInclusive (inclusive) to endInclusive (inclusive) by an incremental step of 1.

5. To perform a sequence of operations over the elements of the data source and aggregate their results, three parts are needed: the source, intermediate operation(s) and a terminal operation.

6. `java.util.stream.Stream<T>` interface API:

    - `Stream<T> skip(long n)`: Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream(stateful intermediate operation)

    - map:

      `<R> Stream<R> map(Function<? super T,? extends R> mapper)`: Returns a stream consisting of the results of applying the given function to the elements of this stream(intermediate stateless operation)

    - mapToInt:

      `IntStream mapToInt(ToIntFunction<? super T> mapper)`: Returns an IntStream consisting of the results of applying the given function to the elements of this stream.

    - filter:

      `Stream<T> filter(Predicate<? super T> predicate)`: Returns a stream consisting of the elements of this stream that match the given predicate.(intermediate stateless operation)

      Example:

      ```java
      List<BankAccount> l1 = populateData();

      System.out.println("Original List:");
      l1.forEach(System.out::println);

      System.out.println("Filtered List:");
      l1.stream().filter(account -> account.getType() == AccountType.SAVING).forEach(System.out::println);
      ```

      Another use:

      ```java
      List<BankAccount> l1 = populateData();
      System.out.println("Average of balances of all savings bank accounts: " + l1.stream().filter(a->a.getType()== AccountType.SAVING).mapToDouble(a->a.getBalance()).average().orElse(-1));
      ```

      `DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)` of `java.util.stream.Stream` interface: Returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.

      `OptionalDouble average()` of `java.util.stream.DoubleStream` interface: Returns an OptionalDouble describing the arithmetic mean of elements of this stream, or an empty optional if this stream is empty. Optional means that the value may be present or absent, and thus, getting rid of null checking. But his doesn't give a double value directly, so another terminal operation should be performed on this to get the value.

      `double orElse(double other)` of `java.util.stream.OptionalDouble` interface: Return the value if present, otherwise return other.

      Here we can use other methods of `java.util.stream.OptionalDouble` to operate on the value like:

      `double getAsDouble()`: If a value is present in this OptionalDouble, returns the value, otherwise throws NoSuchElementException.

      `boolean isPresent()`: Return true if there is a value present, otherwise false.

      So, the gist of the stream implementation is:

      - `.stream()`: create a stream from the list l1 of type BankAccount.
      - `.filter(a->a.getType()== AccountType.SAVING)`: filter the stream and return a new stream of type BankAccount with it's elements whose account types is SAVINGS.
      - `.mapToDouble(a->a.getBalance())`: extract the balances from the above stream and return a DoubleStream.
      - `.average()`: calculate the average of all the elements found in the above stream and return it.
      - `.orElse(-1)`: Returns the output from the previous operation  or if the previous operation returns nothing for some reason, return -1.

    - reduce:

      `Optional<T> reduce(BinaryOperator<T> accumulator)`: Performs a _reduction_ on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.

      __Reduction Operations:__ A reduction operation (also called a fold) takes a sequence of input elements and combines them into a single summary result by repeated application of a combining operation, such as finding the sum or maximum of a set of numbers, or accumulating elements into a list. The streams classes have multiple forms of general reduction operations, called reduce() and collect(), as well as multiple specialized reduction forms such as sum(), max(), or count().

### Summary of Streams

1. Streams are functional programming design pattern for processing sequence of elements sequentially or in parallel.(a.k.a Monad in functional programming).

2. Stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements.

3. Stream operations are either intermediate or terminal. Intermediate operations return a stream so we can chain multiple intermediate operations. Terminal operations are either void or return a non-stream result.

4. They can't be reused.

5. Collections vs Streams:
Collections are in-memory data structures which hold elements within it. Each element in the collection is computed before it actually becomes a part of that collection. On the other hand Streams are fixed data structures which computes the elements on-demand basis.

The Java 8 Streams- lazily constructed Collections, where the values are computed when user demands for it.

Actual Collections behave absolutely opposite to it and they are set of eagerly computed values (no matter if the user demands for a particular value or not).
