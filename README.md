# Java Snippets

[![Build status](https://travis-ci.org/iluwatar/java-snippets.svg?branch=master)](https://travis-ci.org/iluwatar/java-snippets)

Inspired by [30 seconds of code](https://github.com/Chalarangelo/30-seconds-of-code), this is a collection of reusable Java code snippets.

## How to contribute
Update the sample application with the snippet and add a test for it. After proving that it works update this README.md.

## Table of Contents

### Array
* [Generic two array concatenation](#generic-two-array-concatenation)

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
