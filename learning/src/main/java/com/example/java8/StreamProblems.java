package com.example.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProblems {
    public static void main(String[] args) {


        // 1. lazy evaluation and incorrect expectations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Intermediate operation (doesn't execute yet)
        Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 0);


        //2. Using forEach in Streams (Side Effects) - not ideal for accumulating or mutating external states
        List<Integer> result = new ArrayList<>();

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(result::add);


        //3. Handling null values in steam
        List<String> words = Arrays.asList("apple", null, "banana");
        List<String> nonNullWords = words.stream()
              .filter(Objects::nonNull)
                .collect(Collectors.toList());

        //4. Incorrect use of parallel Stream
        numbers.parallelStream()
                .forEach(result::add);



        //5. Not using collectors.toMap() correctly duplicate key
        List<String> names = Arrays.asList("Alice", "Bob", "Alice");
        Map<String, Integer> map =  names.stream()
                .collect(Collectors.toMap(key -> key, String::length, (v1, v2) -> v1));   //need merge functionality
        System.out.println(map);


        //6. Infinite Streams (Using Stream.iterate() and Stream.generate())
    }
}










/*
*
* Java 8 introduced the **Streams API**, which provides a powerful way to process collections of objects in a functional style. With the Streams API, you can perform complex data transformations and computations in a declarative manner. However, like any feature, it comes with its own set of challenges, especially when you're new to the concept. Below are some common problems or pitfalls developers face when working with Java 8 Streams API, along with solutions and explanations.

### 1. **Lazy Evaluation and Incorrect Expectations**
   **Problem:** One of the key features of streams is **lazy evaluation**. This means that intermediate operations (like `map`, `filter`, `distinct`) do not actually process the data until a terminal operation (like `collect`, `forEach`, `reduce`) is invoked.

   Developers sometimes expect intermediate operations to execute immediately, which can lead to confusion.

   **Solution:** Be aware that stream operations are evaluated lazily. Only when a terminal operation is invoked will the stream be processed.

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

   // Intermediate operation (doesn't execute yet)
   Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 0);

   // Terminal operation (triggers processing)
   List<Integer> evenNumbers = stream.collect(Collectors.toList());
   ```

   In the above code, the filtering doesn't actually happen until `collect()` is called. If you're not getting the expected result, it could be because you're not invoking a terminal operation.

---

### 2. **Using `forEach` in Streams (Side Effects)**
   **Problem:** A common mistake is using `forEach` inside a stream, which is generally not ideal for accumulating or mutating external states, as it can lead to unintended side effects.

   **Solution:** Avoid using `forEach` when side effects are involved. If the goal is to accumulate or perform actions that are better suited to mutable states (like adding to a collection), use the `Collectors` or reduce operations.

   **Bad Example (Side Effects):**
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   List<Integer> result = new ArrayList<>();

   numbers.stream()
          .filter(n -> n % 2 == 0)
          .forEach(result::add);  // Side effect: modifying external state
   ```

   **Better Example:**
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

   List<Integer> result = numbers.stream()
                                  .filter(n -> n % 2 == 0)
                                  .collect(Collectors.toList());
   ```

---

### 3. **Handling Null Values in Streams**
   **Problem:** Streams don't handle `null` values well. If the stream contains `null`, operations like `filter`, `map`, or `reduce` can throw `NullPointerException`.

   **Solution:** You should always handle `null` explicitly when working with streams.

   ```java
   List<String> words = Arrays.asList("apple", null, "banana");

   // Safe handling of nulls
   List<String> nonNullWords = words.stream()
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toList());
   ```

   Another option is using `Optional` in case of potential `null` values inside streams:

   ```java
   List<String> words = Arrays.asList("apple", "banana", null, "cherry");

   Optional<String> firstNonNull = words.stream()
                                        .filter(Objects::nonNull)
                                        .findFirst();
   ```

---

### 4. **Incorrect Use of Parallel Streams**
   **Problem:** Parallel streams are a powerful tool for performance, but they can lead to subtle bugs if not used carefully. Using parallel streams improperly (e.g., with non-thread-safe operations or shared mutable state) can cause unexpected behavior.

   **Solution:** Be cautious when using parallel streams. Always ensure that operations on the stream are thread-safe.

   **Example of Bad Parallel Stream Usage:**
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   List<Integer> result = new ArrayList<>();

   numbers.parallelStream()
          .forEach(result::add);  // Modifying shared state (result) in parallel, leads to issues
   ```

   **Proper Usage with Parallel Streams:**
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

   List<Integer> result = numbers.parallelStream()
                                  .map(n -> n * 2)
                                  .collect(Collectors.toList());
   ```

   Ensure operations are **stateless** and **side-effect-free** when using parallel streams.

---

### 5. **Not Using `Collectors.toMap` Correctly**
   **Problem:** Using `Collectors.toMap()` can lead to `IllegalStateException` if there are duplicate keys. This happens when the `keyMapper` generates duplicate keys for the same value in the stream.

   **Solution:** You can handle duplicates by providing a **merge function** to resolve conflicts when duplicate keys are found.

   **Example of Problematic Usage:**
   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Alice");
   Map<String, Integer> nameLengthMap = names.stream()
                                             .collect(Collectors.toMap(name -> name, String::length));  // Will throw exception
   ```

   **Solution: Handle Duplicate Keys:**
   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Alice");

   Map<String, Integer> nameLengthMap = names.stream()
                                             .collect(Collectors.toMap(
                                                 name -> name,
                                                 String::length,
                                                 (existing, replacement) -> existing)); // Handle duplicates
   ```

   The merge function `(existing, replacement) -> existing` will simply keep the first occurrence and discard subsequent duplicates.

---

### 6. **Infinite Streams (Using `Stream.iterate()` and `Stream.generate()`)**
   **Problem:** Both `Stream.iterate()` and `Stream.generate()` can generate infinite streams. If used carelessly, they can lead to **infinite loops** or memory issues.

   **Solution:** Always use **termination conditions** like `limit()` when creating infinite streams.

   ```java
   // Infinite stream of integers
   Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);

   // Ensure it stops at some point
   List<Integer> firstTenNumbers = infiniteStream.limit(10)
                                                .collect(Collectors.toList());
   ```

   Without `limit()`, the stream will never end and cause a problem.

---

### 7. **Using `reduce()` Incorrectly**
   **Problem:** The `reduce()` operation can be tricky to use correctly, especially with null values or incorrect associative functions. If not properly designed, it can produce incorrect results or fail with an exception.

   **Solution:** Make sure that the identity value (the initial value) is suitable and that the accumulator function is **associative** and **commutative** (can be rearranged without changing the result).

   ```java
   // Correct usage of reduce
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int sum = numbers.stream()
                    .reduce(0, Integer::sum);  // Identity value is 0, associative function Integer::sum
   ```

   A common issue occurs when using non-commutative operations like subtraction or division inside `reduce()`.

---

### 8. **Unintended State Changes in Streams**
   **Problem:** Streams should ideally be **stateless**. If your stream operation changes the state of variables or the objects being processed, it can result in **non-thread-safe behavior** or incorrect results.

   **Solution:** Ensure that operations on streams do not have side effects that modify shared state.

   **Bad Example (State Change in a Stream):**
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int[] sum = {0};  // Array used to simulate a mutable state

   numbers.stream()
          .forEach(n -> sum[0] += n);  // Modifying state inside the stream (side effects)
   ```

   **Good Example (No State Change):**
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int sum = numbers.stream()
                    .mapToInt(Integer::intValue)
                    .sum();  // Using stream correctly without side effects
   ```

---

### Conclusion

The **Streams API** in Java 8 is a powerful tool for functional-style programming, but it comes with some common pitfalls and challenges. To avoid these issues, you need to:

- Be aware of **lazy evaluation** and how it works.
- Use **parallel streams** carefully to avoid concurrency issues.
- Handle **null values** and other edge cases properly.
- Understand the nuances of **reducing operations** and how to safely combine results.
- Avoid **side effects** in streams.

By following best practices and using the Streams API correctly, you can write clean, efficient, and bug-free code that works well with collections.
*
*
* */