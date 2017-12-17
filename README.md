# Java Snippets

[![Build status](https://travis-ci.org/iluwatar/java-snippets.svg?branch=master)](https://travis-ci.org/iluwatar/java-snippets)

Inspired by [30 seconds of code](https://github.com/Chalarangelo/30-seconds-of-code), this is a collection of reusable tested Java code snippets.

## How to contribute
Update the sample application with the snippet and add a test for it. After proving that it works update this README.md.

## Table of Contents

### Array
* [Generic two array concatenation](#generic-two-array-concatenation)
* [Generic N array concatenation](#generic-N-array-concatenation)

### File
* [Read lines from file to string list](#read-lines-from-file-to-string-list)

### Math
* [Factorial](#factorial)
* [Fibonacci](#fibonacci)

### String
* [Reverse string](#reverse-string)

## Array

### Generic two array concatenation

```java
    public static <T> T[] arrayConcat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
```

[⬆ back to top](#table-of-contents)

### Generic N array concatenation

```java
    public static <T> T[] nArrayConcat(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
```

[⬆ back to top](#table-of-contents)

## File

### Read lines from file to string list

```java
    public static List<String> readLines(String filename) throws IOException {
        return Files.readAllLines(new File(filename).toPath());
    }
```

[⬆ back to top](#table-of-contents)

## Math

### Fibonacci

```java
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
```

[⬆ back to top](#table-of-contents)

### Factorial

```java
    public static int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
```

[⬆ back to top](#table-of-contents)

## String

### Reverse string

```java
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
```

[⬆ back to top](#table-of-contents)
