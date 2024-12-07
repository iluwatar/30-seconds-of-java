---
title: "Essential Code Snippets Library for Java Developers"
shortTitle: Code Snippets Library
description: "Access a wide range of Java code snippets for implementing design patterns effectively. Our library offers ready-to-use examples to help you improve your coding and design skills."
language: en
---

## 30 Seconds of Java - Essential Code Snippets Library for Java Developers

Inspired by [30 seconds of code](https://github.com/Chalarangelo/30-seconds-of-code), this is a collection of reusable, tested, and copy-pasteable Java 17 compatible code snippets that you can understand in 30 seconds or less. If you're interested in contributing to this library, please see the [contribution guidelines](https://github.com/iluwatar/30-seconds-of-java/blob/master/CONTRIBUTE.md).

## Algorithm

### Binary Search In 2d Array

```java
public class BinarySearchIn2dArraySnippet {

  /**
  * Search an item with binarySearch algorithm.
  *
  * @param matrix should be sorted
  * @param target an item to search
  * @return if location of item is found, otherwise return {-1,-1}
  */
  public static int[] binarySearchIn2darr(int[][] matrix, int target) {
    int rows = matrix.length - 1;
    int cols = matrix[0].length - 1;

    if (rows == 1) {
      return binarySearch(matrix, target, 0, 0, cols);
    }

    int rstart = 0;
    int rend = rows;
    int cmid = cols / 2;

    while (rstart < rend - 1) {
      int rmid = rstart + (rend - rstart) / 2;
      if (matrix[rmid][cmid] > target) {
        rend = rmid;
      } else if (matrix[rmid][cmid] < target) {
        rstart = rmid;
      } else {
        return new int[]{rmid, cmid};
      }
    }
    if (matrix[rstart][cmid] == target) {
      return new int[]{rstart, cmid};
    }
    if (matrix[rend][cmid] == target) {
      return new int[]{rend, cmid};
    }
    if (target <= matrix[rstart][cmid - 1]) {
      return binarySearch(matrix, target, rstart, 0, cmid - 1);
    }
    if (target >= matrix[rstart][cmid + 1]) {
      return binarySearch(matrix, target, rstart, cmid + 1, cols);
    }
    if (target <= matrix[rend][cmid - 1]) {
      return binarySearch(matrix, target, rend, 0, cmid - 1);
    }
    if (target <= matrix[rend][cmid + 1]) {
      return binarySearch(matrix, target, rend, cmid + 1, cols);
    }
    return new int[]{-1, -1};
  }

  static int[] binarySearch(int[][] matrix, int target, int row, int cstart, int cend) {
    while (cstart <= cend) {
      int cmid = cstart + (cend - cstart) / 2;
      if (matrix[row][cmid] > target) {
        cend = cmid - 1;
      } else if (matrix[row][cmid] < target) {
        cstart = cend + 1;
      } else {
        return new int[]{row, cmid};
      }
    }
    return new int[]{-1, -1};
  }
}
```

### Binary Search

```java
public class BinarySearchSnippet {

  /**
   * Search an item with binarySearch algorithm.
   *
   * @param arr sorted array to search
   * @param item an item to search
   * @return if item is found, return the index position of the array item otherwise return -1
   */

  public static int binarySearch(int[] arr, int left, int right, int item) {
    if (right >= left) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == item) {
        return mid;
      }

      if (arr[mid] > item) {
        return binarySearch(arr, left, mid - 1, item);
      }

      return binarySearch(arr, mid + 1, right, item);
    }
    return -1;
  }   
}
```

### Bubble Sort

```java
public class BubbleSortSnippet {

  /**
   * Sort an array with bubbleSort algorithm.
   *
   * @param arr array to sort
   */
  public static void bubbleSort(int[] arr) {
    var lastIndex = arr.length - 1;

    for (var j = 0; j < lastIndex; j++) {
      for (var i = 0; i < lastIndex - j; i++) {
        if (arr[i] > arr[i + 1]) {
          var tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
        }
      }
    }
  }
}
```

### Counting Sort

```java
public class CountingSortSnippet {

  /**
   * Sort an array having zero or positive numbers with countingSort algorithm.
   *
   * @param arr array to sort
   */
  public static void countingSort(int[] arr) {
    var max = Arrays.stream(arr).max().getAsInt();

    var count = new int[max + 1];

    for (var num : arr) {
      count[num]++;
    }

    for (var i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    var sorted = new int[arr.length];
    for (var i = arr.length - 1; i >= 0; i--) {
      var cur = arr[i];
      sorted[count[cur] - 1] = cur;
      count[cur]--;
    }

    var index = 0;
    for (var num : sorted) {
      arr[index++] = num;
    }
  }
}
```

### Cycle Sort

```java
public class CycleSortSnippet {

  /**
   * Sort an array with cycleSort algorithm.
   *
   * @param arr array to sort
   */
  public static int[] cycleSort(int[] arr) {
    int n = arr.length;
    int i = 0;
    while (i < n) {
      int correctpos = arr[i] - 1;
      if (arr[i] != arr[correctpos]) {
        int temp = arr[i];
        arr[i] = arr[correctpos];
        arr[correctpos] = temp;
      } else {
        i++;
      }
    }
    return arr;
  }
}
```

### Insertion Sort

```java
public class InsertionSortSnippet {

  /**
   * Sort an array with insertionSort algorithm.
   *
   * @param arr array to sort
   */
  public static void insertionSort(int[] arr) {
    for (var i = 1; i < arr.length; i++) {
      var tmp = arr[i];
      var j = i - 1;

      while (j >= 0 && arr[j] > tmp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = tmp;
    }
  }
}
```

### Linear Search In 2d Array

```java
public class LinearSearchIn2dArraySnippet {

  /**
   * Search an item with linearSearch algorithm.
   *
   * @param arr    array to search
   * @param target an item to search
   * @return if location of target is found,otherwise return {-1,-1}
   */

  public static int[] linearSearch2dArray(int[][] arr, int target) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }
}
```

### Linear Search

```java
public class LinearSearchSnippet {

  /**
   * Search an item with linearSearch algorithm.
   *
   * @param arr array to search
   * @param item an item to search
   * @return if item is found, return the index position of the array item otherwise return -1
   */
  public static int linearSearch(int[] arr, int item) {
    for (int i = 0; i < arr.length; i++) {
      if (item == arr[i]) {
        return i;
      }
    }
    return -1;
  }
}
```

### Merge Sort

```java
public class MergeSortSnippet {
  /**
   * Sort an array with qmergesort algorithm.
   *
   * @param arr   array to sort
   * @low low index where to begin sort (e.g. 0)
   * @high high index where to end sort (e.g. array length - 1)
   */

  public static void mergeSort(int[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    var mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, high, mid);
  }

  private static void merge(int[] arr, int low, int high, int mid) {
    int[] temp = new int[(high - low + 1)];
    var i = low;
    var j = mid + 1;
    var k = 0;

    while (i <= mid && j <= high) {
      if (arr[i] < arr[j]) {
        temp[k++] = arr[i];
        i++;
      } else {
        temp[k++] = arr[j];
        j++;
      }
    }

    while (i <= mid) {
      temp[k++] = arr[i];
      i++;
    }

    while (j <= high) {
      temp[k++] = arr[j];
      j++;
    }

    for (int m = 0, n = low; m < temp.length; m++, n++) {
      arr[n] = temp[m];
    }
  }
}
```

### Quick Sort

```java
public class QuickSortSnippet {

  /**
   * Sort an array with quicksort algorithm.
   *
   * @param arr   array to sort
   * @param left  left index where to begin sort (e.g. 0)
   * @param right right index where to end sort (e.g. array length - 1)
   */
  public static void quickSort(int[] arr, int left, int right) {
    var pivotIndex = left + (right - left) / 2;
    var pivotValue = arr[pivotIndex];
    var i = left;
    var j = right;
    while (i <= j) {
      while (arr[i] < pivotValue) {
        i++;
      }
      while (arr[j] > pivotValue) {
        j--;
      }
      if (i <= j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
      if (left < i) {
        quickSort(arr, left, j);
      }
      if (right > i) {
        quickSort(arr, i, right);
      }
    }
  }
}
```

### Selection Sort

```java
public class SelectionSortSnippet {

  /**
   * Sort an array with selectionSort algorithm.
   *
   * @param arr array to sort
   */
  public static void selectionSort(int[] arr) {
    var len = arr.length;

    for (var i = 0; i < len - 1; i++) {
      var minIndex = i;

      for (var j = i + 1; j < len; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      var tmp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = tmp;
    }
  }
}
```

### Sieve of Eratosthenes

```java
public class SieveOfEratosthenesSnippet {
  /**
   * Search an item with binarySearch algorithm.
   *
   * @param n range of number.
   * @return isPrime boolean array where prime number 0 to n are mark true.
   */
  public static boolean[] sieveOfEratosthenes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    for (int i = 0; i < isPrime.length; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i] == true) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }

    return isPrime;
  }
}
```
### Verhoeff

```java
public class VerhoeffSnippet {

    private static final int[][] d = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 0, 3, 2, 5, 4, 7, 6, 9, 8},
            {2, 3, 0, 1, 6, 7, 4, 5, 8, 9},
            {3, 2, 1, 0, 7, 6, 5, 4, 9, 8},
            {4, 5, 6, 7, 0, 1, 2, 3, 8, 9},
            {5, 4, 7, 6, 1, 0, 3, 2, 9, 8},
            {6, 7, 4, 5, 2, 3, 0, 1, 8, 9},
            {7, 6, 5, 4, 3, 2, 1, 0, 9, 8},
            {8, 9, 8, 9, 8, 9, 8, 9, 0, 1},
            {9, 8, 9, 8, 9, 8, 9, 8, 1, 0}
    };

    private static final int[][] p = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
            {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
            {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
            {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
            {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
            {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
            {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
    };

    private static final int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

    /**
     * Validates a number using the Verhoeff checksum algorithm.
     *
     * @param num the numeric string to validate
     * @return true if the number is valid according to Verhoeff algorithm, false otherwise
     */
    public static boolean validateVerhoeff(String num) {
        int c = 0;
        int length = num.length();

        // Adjust index for validation of the full number (including check digit)
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(num.charAt(length - i - 1));
            c = d[c][p[(i + 1) % 8][digit]]; // Correct permutation index
        }

        return c == 0; // Final checksum must be zero
    }

    /**
     * Generates a Verhoeff check digit for a given numeric string.
     *
     * @param num the numeric string for which to generate the check digit
     * @return the generated Verhoeff check digit as a string
     */
    public static String generateVerhoeff(String num) {
        int c = 0;
        int length = num.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(num.charAt(length - i - 1));
            c = d[c][p[(i % 8)][digit]];
        }

        return Integer.toString(inv[c]);
    }

}
```

## Array

### All Equal

```java
public class AllEqualSnippet {

  /**
   * Returns true if all elements in array are equal.
   *
   * @param arr the array to check (not null)
   * @param <T> the element type
   * @return true if all elements in the array are equal
   */
  public static <T> boolean allEqual(T[] arr) {
    return Arrays.stream(arr).distinct().count() == 1;
  }
}
```

### Array Concat

```java
public class ArrayConcatSnippet {

  /**
   * Generic 2 array concatenation Credits: Joachim Sauer https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
   *
   * @param first  is the first array (not null)
   * @param second is the second array (not null)
   * @param <T>    the element type
   * @return concatenated array
   */
  public static <T> T[] arrayConcat(T[] first, T[] second) {
    var result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }
}
```

### Array Mean

```java
public class ArrayMeanSnippet {

  /**
   * Returns the mean of the integers in the array.
   *
   * @param arr the array of integers (not null)
   * @return a double representing the mean of the array
   */
  public static double arrayMean(int[] arr) {
    return (double) Arrays.stream(arr).sum() / arr.length;
  }
}
```

### Array Median

```java
public class ArrayMedianSnippet {

  /**
   * Returns the median of the array.
   *
   * @param arr the array of integers (not null)
   * @return a double representing the median of the array
   */
  public static double arrayMedian(int[] arr) {
    Arrays.sort(arr);
    var mid = arr.length / 2;
    return arr.length % 2 != 0 ? (double) arr[mid] : (double) (arr[mid] + arr[mid - 1]) / 2;
  }
}
```

### Array Mode In Place

```java
public class ArrayModeInPlaceSnippet {

  /**
  * Returns the mode of the array.
  *
  * @param arr array to find mode in it
  * @return mode of array
  */
  public static int modeArrayInPlace(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    Arrays.sort(arr);

    int mode = arr[0];
    int maxcount = 1;
    int count = 1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        count++;
      } else {
        if (count > maxcount) {
          maxcount = count;
          mode = arr[i - 1];
        }
        count = 1;
      }
    }
    if (count > maxcount) {
      mode = arr[arr.length - 1];
    }
    return mode;
  }
}
```

### Array Mode

```java
public class ArrayModeSnippet {

  /**
  * Returns the mode of the array.
  *
  * @param arr array to find mode in it
  * @return mode of array
  */
  public static int modeArray(int[] arr) {
    int mode = 0;
    int maxcount = 0;

    for (int i = 0; i < arr.length; i++) {
      int count = 0;

      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }
      if (count > maxcount) {
        maxcount = count;
        mode = arr[i];
      }
    }
    return mode;
  }
}
```

### Array Sum

```java
public class ArraySumSnippet {

  /**
   * Returns sum of the integers in the array.
   *
   * @param arr the array of integers (not null)
   * @return the sum of the elements from the array
   */
  public static int arraySum(int[] arr) {
    return Arrays.stream(arr).sum();
  }
}
```

### Find Max

```java
public class FindMaxSnippet {

  /**
   * Returns the maximum integer from the array using reduction.
   *
   * @param arr the array of integers (not null)
   * @return the maximum element from the array
   */
  public static int findMax(int[] arr) {
    return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
  }
}
```

### Find Min

```java
public class FindMinSnippet {
 
  /**
    * Returns the minimum integer from the array using reduction.
    *
    * @param arr the array of integers (not null)
    * @return the minimum element from the array
    */
  public static int findMin(int[] arr) {
    return Arrays.stream(arr).reduce(Integer.MAX_VALUE, Integer::min);
  }
}
```

### Multi Array Concatenation

```java
public class MultiArrayConcatenationSnippet {

  /**
   * Generic N array concatenation Credits: Joachim Sauer https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
   *
   * @param first is the first array (not null)
   * @param rest  the rest of the arrays (optional)
   * @param <T>   the element type
   * @return concatenated array
   */
  public static <T> T[] multiArrayConcat(T[] first, T[]... rest) {
    var totalLength = first.length;
    for (var array : rest) {
      totalLength += array.length;
    }
    var result = Arrays.copyOf(first, totalLength);
    var offset = first.length;
    for (var array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }
}
```

### Reverse Array

```java
public class ReverseArraySnippet {

  /**
   * The function then reverses the elements of the array between the starting and ending
   * indices using a while loop and a temporary variable `temp`. Finally, the function returns
   * the reversed array.
   *
   * @param array a array
   * @param start start index array
   * @param end end index array
   * @return reverses elements in the array
   * @throws IllegalArgumentException if the [start] index is greater
   *         than the [end] index or if the array is null
   **/
  public static <T> T[] reverseArray(T[] array, int start, int end) {
    if (start > end || array == null) {
      throw new
              IllegalArgumentException("Invalid argument!");
    }
    int minimumSizeArrayForReversal = 2;
    if (start == end || array.length < minimumSizeArrayForReversal) {
      return array;
    }
    while (start < end) {
      T temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
    return array;
  }
}
```

## Class

### Creating Object

```java
public class CreatingObjectSnippet {

  /**
   * Create object using reflection.
   *
   * @param cls fully qualified name of class includes the package name as String
   * @return object
   * @throws NoSuchMethodException if a method that does not exist at runtime.
   * @throws IllegalAccessException <p>if an currently executing method does not have access to
   *     the definition of the specified class, field, method or constructor</p>
   * @throws InvocationTargetException <p>InvocationTargetException is a checked exception
   *     that wraps an exception thrown by an invoked method or constructor.</p>
   * @throws InstantiationException <p>when an method tries to create an instance of a class
   *     using the newInstance method in class Class.</p>
   * @throws ClassNotFoundException <p>when an application tries to load in a class
   *     through its string name.</p>
   */
  public static Object createObject(String cls)
          throws NoSuchMethodException,
          IllegalAccessException,
          InvocationTargetException,
          InstantiationException,
          ClassNotFoundException {
    var objectClass = Class.forName(cls);
    var objectConstructor = objectClass.getConstructor();
    return objectConstructor.newInstance();
  }
}
```

### Get All Field Names

```java
public class GetAllFieldNamesSnippet {

  /**
   * Print all declared field names of the class or the interface the class extends.
   *
   * @param clazz Tested class
   * @return list of names of all fields
   */
  public static List<String> getAllFieldNames(final Class<?> clazz) {
    var fields = new ArrayList<String>();
    var currentClazz = clazz;
    while (currentClazz != null) {
      fields.addAll(
          Arrays.stream(currentClazz.getDeclaredFields())
              .filter(field -> !field.isSynthetic())
              .map(Field::getName)
              .collect(Collectors.toList()));
      currentClazz = currentClazz.getSuperclass();
    }
    return fields;
  }
}
```

### Get All Methods

```java
public class GetAllMethodsSnippet {

  /**
   * Print all declared methods of the class.
   *
   * @param cls Tested class
   * @return list of methods name
   */
  public static List<String> getAllMethods(final Class<?> cls) {
    return Arrays.stream(cls.getDeclaredMethods())
        .map(Method::getName)
        .collect(Collectors.toList());
  }
}
```

### Get All Public Field Names

```java
public class GetAllPublicFieldNamesSnippet {

  /**
   * Print all declared public field names of the class or the interface the class extends.
   *
   * @param clazz Tested class
   * @return list of name of public fields
   */
  public static List<String> getAllPublicFieldNames(final Class<?> clazz) {
    return Arrays.stream(clazz.getFields())
        .map(Field::getName)
        .collect(Collectors.toList());
  }
}
```

## Date

### Add Days To Date

```java
public class AddDaysToDateSnippet {

  /**
   * Add days to given date.
   *
   * @param date given date
   * @param noOfDays number of days to add
   * @return modified date
   */
  public static Date addDaysToDate(Date date, int noOfDays) {
    if (date != null) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DAY_OF_MONTH, noOfDays);
      return cal.getTime();
    }
    return null;
  }

  /**
   * Add days to local date.
   *
   * @param date given local date
   * @param noOfDays number of days to add
   * @return modified date
   */
  public static LocalDate addDaysToLocalDate(LocalDate date, long noOfDays) {
    return date != null ? date.plusDays(noOfDays) : null;
  }
}
```

### Date Difference

```java
public class DateDifferenceSnippet {

  /**
  * This function calculates the number of years between two LocalDate objects.
  * If the result is negative, it returns the absolute value of the difference.
  *
  * @param firstTime  The first LocalDate object representing the starting date
  * @param secondTime The second LocalDate object representing the ending date
  * @return The number of years between the two LocalDate objects as a long data type
  */
  public static long getYearsDifference(LocalDate firstTime, LocalDate secondTime) {
    var yearsDifference = ChronoUnit.YEARS.between(firstTime, secondTime);
    return Math.abs(yearsDifference);
  }

  /**
   * This function calculates the number of months between two LocalDate objects.
   * If the result is negative, it returns the absolute value of the difference.
   *
   * @param firstTime  The first LocalDate object representing the starting date
   * @param secondTime The second LocalDate object representing the ending date
   * @return The number of months between the two LocalDate objects as a long data type
   */
  public static long getMonthsDifference(LocalDate firstTime, LocalDate secondTime) {
    var monthsDifference = ChronoUnit.MONTHS.between(firstTime, secondTime);
    return Math.abs(monthsDifference);
  }

  /**
   * This function calculates the number of days between two LocalDate objects.
   * If the result is negative, it returns the absolute value of the difference.
   *
   * @param firstTime  The first LocalDate object representing the starting date
   * @param secondTime The second LocalDate object representing the ending date
   * @return The number of days between the two LocalDate objects as a long data type
   */
  public static long getDaysDifference(LocalDate firstTime, LocalDate secondTime) {
    var daysDifference = ChronoUnit.DAYS.between(firstTime, secondTime);
    return Math.abs(daysDifference);
  }
}
```

## Encoding

### Base64Decode

```java
public class Base64DecodeSnippet {

  /**
   * Decodes a Base64 encoded string to the actual representation.
   *
   * @param input base64 encoded string
   * @return decoded string
   */
  public static String decodeBase64(String input) {
    return new String(Base64.getDecoder().decode(input.getBytes()));
  }
}
```

### Base64Encode

```java
public class Base64EncodeSnippet {
  /**
   * Encodes the input string to a Base64 encoded string.
   *
   * @param input string to be encoded
   * @return base64 encoded string
   */
  public static String encodeBase64(String input) {
    return Base64.getEncoder().encodeToString(input.getBytes());
  }
}
```

## File

### List All Files

```java
public class ListAllFilesSnippet {

  /**
   * Recursively list all the files in directory.
   *
   * @param path the path to start the search from
   * @return list of all files
   */
  public static List<File> listAllFiles(String path) {
    var all = new ArrayList<File>();
    var list = new File(path).listFiles();
    if (list != null) {  // In case of access error, list is null
      for (var f : list) {
        if (f.isDirectory()) {
          all.addAll(listAllFiles(f.getAbsolutePath()));
        } else {
          all.add(f.getAbsoluteFile());
        }
      }
    }
    return all;
  }
}
```

### List Directories

```java
public class ListDirectoriesSnippet {

  /**
   * List directories.
   *
   * @param path the path where to look
   * @return array of File
   */
  public static File[] listDirectories(String path) {
    return new File(path).listFiles(File::isDirectory);
  }
}
```

### List Files In Directory

```java
public class ListFilesInDirectorySnippet {

  /**
   * List files in directory.
   *
   * @param folder the path where to look
   * @return array of File
   */
  public static File[] listFilesInDirectory(String folder) {
    return new File(folder).listFiles(File::isFile);
  }
}
```

### Read Lines

```java
public class ReadLinesSnippet {

  /**
   * Read file as list of strings.
   *
   * @param filename the filename to read from
   * @return list of strings
   * @throws IOException if an I/O error occurs
   */
  public static List<String> readLines(String filename) throws IOException {
    return Files.readAllLines(Paths.get(filename));
  }
}
```

### Zip Directory

```java
public class ZipDirectorySnippet {

  /**
   * Zip a complete directory.
   *
   * @param srcDirectoryName The path to the directory to be zipped
   * @param zipFileName The location and name of the zipped file.
   * @throws IOException if an I/O error occurs
   * */
  public static void zipDirectory(String srcDirectoryName, String zipFileName) throws IOException {
    var srcDirectory = new File(srcDirectoryName);
    try (
        var fileOut = new FileOutputStream(zipFileName);
        var zipOut = new ZipOutputStream(fileOut)
    ) {
      zipFile(srcDirectory, srcDirectory.getName(), zipOut);
    }
  }

  /**
   * Utility function which either zips a single file, or recursively calls itself for 
   * a directory to traverse down to the files contained within it.
   *
   * @param fileToZip The file as a resource
   * @param fileName The actual name of the file
   * @param zipOut The output stream to which all data is being written
   * */
  public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) 
      throws IOException {
    if (fileToZip.isHidden()) { // Ignore hidden files as standard
      return;
    }
    if (fileToZip.isDirectory()) {
      if (fileName.endsWith("/")) {
        zipOut.putNextEntry(new ZipEntry(fileName)); // To be zipped next
        zipOut.closeEntry();
      } else {
        // Add the "/" mark explicitly to preserve structure while unzipping action is performed
        zipOut.putNextEntry(new ZipEntry(fileName + "/"));
        zipOut.closeEntry();
      }
      var children = fileToZip.listFiles();
      for (var childFile : children) { // Recursively apply function to all children
        zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
      }
      return;
    }
    try (
        var fis = new FileInputStream(fileToZip) // Start zipping once we know it is a file
    ) {
      var zipEntry = new ZipEntry(fileName);
      zipOut.putNextEntry(zipEntry);
      var bytes = new byte[1024];
      var length = 0;
      while ((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }
}
```

### Zip File

```java
public class ZipFileSnippet {

  /**
   * Zip single file.
   *
   * @param srcFilename the filename of the source file
   * @param zipFilename the filename of the destination zip file
   * @throws IOException if an I/O error occurs
   */
  public static void zipFile(String srcFilename, String zipFilename) throws IOException {
    var srcFile = new File(srcFilename);
    try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut);
            var fileIn = new FileInputStream(srcFile)
    ) {
      var zipEntry = new ZipEntry(srcFile.getName());
      zipOut.putNextEntry(zipEntry);
      final var bytes = new byte[1024];
      int length;
      while ((length = fileIn.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }
}
```

### Zip Files

```java
public class ZipFilesSnippet {

  /**
   * Zip multiples files.
   *
   * @param srcFilenames array of source file names
   * @param zipFilename  the filename of the destination zip file
   * @throws IOException if an I/O error occurs
   */
  public static void zipFiles(String[] srcFilenames, String zipFilename) throws IOException {
    try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut)
    ) {
      for (String srcFilename : srcFilenames) {
        var srcFile = new File(srcFilename);
        try (var fileIn = new FileInputStream(srcFile)) {
          var zipEntry = new ZipEntry(srcFile.getName());
          zipOut.putNextEntry(zipEntry);
          final var bytes = new byte[1024];
          int length;
          while ((length = fileIn.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
          }
        }
      }
    }
  }
}
```

## I/O

### InputStream To String

```java
public class InputStreamToStringSnippet {

  /**
   * Convert InputStream to String.
   *
   * @param inputStream InputStream to convert
   * @return String
   */
  public static String inputStreamToString(InputStream inputStream) {
    return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
            .lines().collect(Collectors.joining(System.lineSeparator()));
  }
}
```

### Read File Snippet

```java
public class ReadFileSnippet {

  /**
   * Read file using stream and return list of string lines.
   *
   * @param fileName file to read
   * @throws FileNotFoundException if an I/O error occurs
   */
  public static List<String> readFile(String fileName) throws FileNotFoundException {
    try (Stream<String> stream = new BufferedReader(new FileReader(fileName)).lines()) {
      return stream.collect(Collectors.toList());
    }
  }
}
```

## Math

### Dice Throw

```java
public class DiceThrow {

  private static Random random = new Random();

  /**
  * Enum for standardized sided dice (4,6,8,10,12 and 20).
  */
  public enum DiceSides {

    FOUR(4), SIX(6), EIGHT(8), TEN(10), TWELVE(12), TWENTY(20);

    private final int diSides;

    DiceSides(int diceSides) {
      this.diSides = diceSides;
    }

    /**
     * Returns the number of sides of a dice.
     *
     * @return int denoting number of sides of a dice
     */
    public int getDiceSides() {
      return this.diSides;
    }

  }

  /**
  * Returns the sum of sides for the given number of sides of each dice.
  *
  * @param noOfDice number of dice
  * @param sides sides of a dice
  * @return int sum of sides for number of dice
  */
  public static int throwDice(int noOfDice, DiceSides sides) {

    int sum = 0;
    for (int i = 0; i < noOfDice; i++) {
      sum = sum + (1 + random.nextInt(sides.getDiceSides()));
    }
    return sum;
  }
}
```

### Elo Rating

```java
public class EloRatingSnippet {

  static final int BASE = 400; //Two types are popular - 400 and 480. We will choose 400 here
  static final int RATING_ADJUSTMENT_FACTOR = 32; //32 is the standard for Beginner Games

  /**
   * Elo Rating Snippet to calculate result after a single match.
   *
   * @param firstPlayerRating Rating of the first player.
   * @param secondPlayerRating Rating of the second player.
   * @param result Result of the match, always considered with respect to the first player.
   *               1 indicates a win, 0.5 indicates a draw and 0 indicates a loss.
   * @return Returns the new rating of the first player.
   */
  public static double calculateMatchRating(double firstPlayerRating, double secondPlayerRating,
      double result) {
    double ratingDiff = ((secondPlayerRating - firstPlayerRating) * 1.0) / BASE;
    double logisticDiff = Math.pow(10, ratingDiff);
    double firstPlayerExpectedScore = 1.0 / (1 + logisticDiff);
    double firstPlayerActualScore = result;
    double newRating = firstPlayerRating + RATING_ADJUSTMENT_FACTOR * (firstPlayerActualScore 
                       - firstPlayerExpectedScore);
    return newRating;
  }
}
```

### Even Odd

```java
public class EvenOdd {

  /**
   * Returns string denoting number is odd or even.
   *
   * @param num To check whether its even or odd
   * @return string denoting its even or odd
   */
  public static String evenodd(int num) {
    if (num % 2 == 0) {
      return "even";
    } else {
      return "odd";
    }
  }
}
```

### Factorial

```java
public class FactorialSnippet {

  /**
   * Factorial. Works only for small numbers
   *
   * @param number for which factorial is to be calculated for
   * @return factorial
   */
  public static int factorial(int number) {
    var result = 1;
    for (var factor = 2; factor <= number; factor++) {
      result *= factor;
    }
    return result;
  }

  /**
   * Factorial. Example of what the recursive implementation looks like.
   *
   * @param number for which factorial is to be calculated for
   * @return factorial
   */
  public static int recursiveFactorial(int number) {
    var initial = 0;
    if (number == initial) {
      return initial + 1;
    }
    return number * recursiveFactorial(number - 1);
  }
}
```

### Fibonacci

```java
public class FibonacciSnippet {

  /**
   * Recursive Fibonacci series. Works only for small n and is spectacularly inefficient
   *
   * @param n given number
   * @return fibonacci number for given n
   */
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  /**
   * Fibonacci series using dynamic programming. Works for larger ns as well.
   *
   * @param n given number
   * @return fibonacci number for given n
   */
  public static int fibonacciBig(int n) {
      int previous = 0;
      int current = 1;
      for (int i = 0; i < n - 1; i++) {
          int t = previous + current;
          previous = current;
          current = t;
      }

      return current;
  }

  /**
   * Example of what an iterative implementation of Fibonacci looks like.
   *
   * @param number given number
   * @return fibonacci number for given n
   */
  public static int iterativeFibonacci(int number) {
    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(1);
    for (int i = 2; i < number + 1; i++) {
      list.add(list.get(i - 2) + list.get(i - 1));
    }
    return list.get(number);
  }
}
```

### Greatest Common Divisor

```java
public class GreatestCommonDivisorSnippet {

  /**
   * Greatest common divisor calculation.
   *
   * @param a one of the numbers whose gcd is to be computed
   * @param b other number whose gcd is to be computed
   * @return gcd of the two numbers
   */
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
```

### Haversine Formula

```java
public class HaversineFormulaSnippet {

  // Radius of sphere on which the points are, in this case Earth.
  private static final double SPHERE_RADIUS_IN_KM = 6372.8;

  /**
   * Haversine formula for calculating distance between two latitude, longitude points.
   *
   * @param latA Latitude of point A
   * @param longA Longitude of point A
   * @param latB Latitude of point B
   * @param longB Longitude of point B
   * @return the distance between the two points.
   */
  public static double findHaversineDistance(double latA, double longA, double latB, double longB) {
    if (!isValidLatitude(latA)
        || !isValidLatitude(latB)
        || !isValidLongitude(longA)
        || !isValidLongitude(longB)) {
      throw new IllegalArgumentException();
    }

    // Calculate the latitude and longitude differences
    var latitudeDiff = Math.toRadians(latB - latA);
    var longitudeDiff = Math.toRadians(longB - longA);

    var latitudeA = Math.toRadians(latA);
    var latitudeB = Math.toRadians(latB);

    // Calculating the distance as per haversine formula
    var a = Math.pow(Math.sin(latitudeDiff / 2), 2)
            + Math.pow(Math.sin(longitudeDiff / 2), 2) * Math.cos(latitudeA) * Math.cos(latitudeB);
    var c = 2 * Math.asin(Math.sqrt(a));
    return SPHERE_RADIUS_IN_KM * c;
  }

  // Check for valid latitude value
  private static boolean isValidLatitude(double latitude) {
    return latitude >= -90 && latitude <= 90;
  }

  // Check for valid longitude value
  private static boolean isValidLongitude(double longitude) {
    return longitude >= -180 && longitude <= 180;
  }
}
```

### Least Common Multiple

```java
public class LeastCommonMultipleSnippet {
  /**
   * Least common multiple  calculation.
   *
   * @param a one of the numbers whose lcm is to be computed
   * @param b other number whose lcm is to be computed
   * @return lcm of the two numbers
   */
  public static int lcm(int a, int b) {
    int max = a > b ? a : b;
    int min = a < b ? a : b;
    for (int i = 1; i <= min; i += 1) {
      int prod = max * i;
      if (prod % min == 0) {
        return prod;
      }
    }
    return max * min;
  }
}
```

### Luhn

```java
public class LuhnSnippet {

  /**
   * Calculates checksum for a given number with Luhn's algorithm. Works only on non-negative
   * integers not greater than {@link Long#MAX_VALUE} i.e., all numbers with a maximum of 18
   * digits, plus 19-digit-long numbers start with 1..8 (also some with 9, too). For
   * demonstration purposes, algorithm is not optimized for efficiency.
   *
   * @param num number whose checksum is to be calculated
   * @return checksum value for num
   * @see <a href="https://patents.google.com/patent/US2950048A">Hans P. LUHN's patent US2950048A</a>
   * @see <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm on Wikipedia</a>
   */
  public static int calculateLuhnChecksum(long num) {
    if (num < 0) {
      throw new IllegalArgumentException("Non-negative numbers only.");
    }
    final var numStr = String.valueOf(num);

    var sum = 0;
    var isOddPosition = true;
    // Loop on digits of numStr from right to left.
    for (var i = numStr.length() - 1; i >= 0; i--) {
      final var digit = Integer.parseInt(Character.toString(numStr.charAt(i)));
      final var substituteDigit = (isOddPosition ? 2 : 1) * digit;

      final var tensPlaceDigit = substituteDigit / 10;
      final var onesPlaceDigit = substituteDigit % 10;
      sum += tensPlaceDigit + onesPlaceDigit;

      isOddPosition = !isOddPosition;
    }
    final var checksumDigit = (10 - (sum % 10)) % 10;
    // Outermost modulus handles edge case `num = 0`.
    return checksumDigit;
  }
}
```

### Natural Number Binary Conversion

```java
public class NaturalNumberBinaryConversionSnippet {

  /**
   * Convert natural number to binary string. Only supports positive integers.Throws exception
   * for negative integers
   *
   * @param naturalNumber given number
   * @return Binary string representation of naturalNumber
   */
  public static String toBinary(long naturalNumber) {
    if (naturalNumber < 0) {
      throw new NumberFormatException("Negative Integer, this snippet only accepts "
              + "positive integers");
    }
    if (naturalNumber == 0) {
      return "0";
    }
    final Stack<Long> binaryBits =
            Stream.iterate(naturalNumber, n -> n > 0, n -> n / 2).map(n -> n % 2)
                    .collect(Stack::new, Stack::push, Stack::addAll);
    return Stream.generate(binaryBits::pop)
            .limit(binaryBits.size()).map(String::valueOf).collect(Collectors.joining());
  }

  /**
   * Convert binary string representation to Long valued Integer. Throws exception if input
   * string contains characters other than '0' and '1'
   *
   * @param binary given number
   * @return Unsigned Long value for the binary number
   */
  public static Long fromBinary(String binary) {
    binary.chars().filter(c -> c != '0' && c != '1').findFirst().ifPresent(in -> {
      throw new NumberFormatException(
              "Binary string contains values other than '0' and '1'");
    });
    return IntStream.range(0, binary.length())
            .filter(in -> binary.charAt(binary.length() - 1 - in) == '1')
            .mapToLong(in -> ((long) 0b1) << in).sum();
  }
}
```

### Perform Lottery

```java
public class PerformLotterySnippet {

  /**
   * Generate random lottery numbers.
   *
   * @param numNumbers    how many performLottery numbers are available (e.g. 49)
   * @param numbersToPick how many numbers the player needs to pick (e.g. 6)
   * @return array with the random numbers
   */
  public static Integer[] performLottery(int numNumbers, int numbersToPick) {
    var numbers = new ArrayList<Integer>();
    for (var i = 0; i < numNumbers; i++) {
      numbers.add(i + 1);
    }
    Collections.shuffle(numbers);
    return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
  }
}
```

### Prime Number

```java
public class PrimeNumberSnippet {

  /**
   * Checks if given number is a prime number. Prime number is a number that is greater than 1 and
   * divided by 1 or itself only Credits: https://en.wikipedia.org/wiki/Prime_number
   *
   * @param number number to check prime
   * @return true if prime
   */
  public static boolean isPrime(int number) {
    //if number < 2 its not a prime number
    if (number < 2) {
      return false;
    }
    // 2 and 3 are prime numbers
    if (number < 3) {
      return true;
    }
    // check if n is a multiple of 2
    if (number % 2 == 0) {
      return false;
    }
    // if not, then just check the odds
    for (var i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
```

### Random Number

```java
public class RandomNumber {

  private RandomNumber() {}

  private static Random random = new Random();

  /**
  * Return a random number between two given numbers.
  *
  * @param start Starting point to find the random number
  * @param end Ending point to find the random number
  * @return Number denoting the random number generated
  */
  public static <T extends Number> Number getRandomNumber(T start, T end) {

    if ((start instanceof Byte && end instanceof Byte)) {
      return (byte) (start.byteValue() + random.nextInt(end.byteValue() - start.byteValue() + 1));
    } else if ((start instanceof Byte && end instanceof Byte) 
            || (start instanceof Short && end instanceof Short)) {
      return (short) (start.shortValue() 
              + random.nextInt(end.shortValue() - start.shortValue() + 1));
    } else if ((start instanceof Integer && end instanceof Integer)) {
      return (int) (start.intValue() 
              + random.nextInt(end.intValue() - start.intValue() + 1));
    } else if (start instanceof Long && end instanceof Long) {
      return (long) (start.longValue() 
              + random.nextLong(end.longValue() - start.longValue() + 1));
    } else if (start instanceof Float && end instanceof Float) {
      return (float) (start.floatValue() 
              + random.nextFloat(end.floatValue() - start.floatValue() + 1));
    } else if (start instanceof Double && end instanceof Double) {
      return (double) (start.doubleValue() 
              + random.nextDouble(end.doubleValue() - start.doubleValue() + 1));
    } else {
      throw new IllegalArgumentException("Invalid Numbers As Arguments " 
              + start.getClass() + " and " + end.getClass());
    }
  }
}
```

### Square Root

```java
public class SquareRoot {

  /**
   * Returns square root of a number.
   *
   * @param num To find SquareRoot
   * @param p   precision till how many decimal numbers we want accurate ans
   */
  public static double sqrt(int num, int p) {
    int start = 0;
    int end = num;
    double root = 0.0;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if ((mid * mid) > num) {
        end = mid - 1;
      } else if ((mid * mid) < num) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    double incr = 0.1;
    for (int i = 0; i < p; i++) {
      while (root * root < num) {
        root = root + incr;
      }
      root = root - incr;
      incr = incr / 10;
    }
    return root;
  }
}
```

## Media

### Capture Screen

```java
public class CaptureScreenSnippet {

  /**
   * Capture screenshot and save it to PNG file. Credits: https://viralpatel.net/blogs/how-to-take-screen-shots-in-java-taking-screenshots-java/
   *
   * @param filename the name of the file
   * @throws AWTException if the platform configuration does not allow low-level input control
   * @throws IOException  if an I/O error occurs
   */
  public static void captureScreen(String filename) throws AWTException, IOException {
    var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    var screenRectangle = new Rectangle(screenSize);
    var robot = new Robot();
    var image = robot.createScreenCapture(screenRectangle);
    ImageIO.write(image, "png", new File(filename));
  }
}
```

## Network

### HTTP GET

```java
public class HttpGetSnippet {

  /**
   * Performs HTTP GET request.
   *
   * @param uri the URI of the connection
   * @return response object
   * @throws Exception i/o error, interruption error, etc
   */
  public static HttpResponse<String> httpGet(String uri) throws Exception {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build();
    return client.send(request, HttpResponse.BodyHandlers.ofString());
  }
}
```

### HTTP POST

```java
public class HttpPostSnippet {

  /**
   * Performs HTTP POST request. Credits https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java
   *
   * @param address   the URL of the connection in String format, like "http://www.google.com"
   * @param arguments the body of the POST request, as a HashMap
   * @return response object
   * @throws IOException          if an I/O error occurs
   * @throws InterruptedException if the operation is interrupted
   */
  public static HttpResponse<String> httpPost(String address, HashMap<String, String> arguments)
          throws IOException, InterruptedException {
    var sj = new StringJoiner("&");
    for (var entry : arguments.entrySet()) {
      sj.add(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "="
              + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
    }

    var out = sj.toString().getBytes(StandardCharsets.UTF_8);
    var request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .POST(HttpRequest.BodyPublishers.ofByteArray(out))
            .build();

    return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
  }
}
```

## String

### Anagram

```java
public class AnagramSnippet {

  /**
   * Checks if two words are anagrams (contains same characters with same frequency in any order).
   *
   * @param s1 The first string to be checked
   * @param s2 The second string to be checked
   * @return true if they are anagrams of each other
   */
  public static boolean isAnagram(String s1, String s2) {
    var l1 = s1.length();
    var l2 = s2.length();

    if (l1 != l2) {
      return false;
    }

    var arr1 = new int[256];
    var arr2 = new int[256];
    
    for (var i = 0; i < l1; i++) {
      arr1[s1.charAt(i)]++;
      arr2[s2.charAt(i)]++;
    }
    return Arrays.equals(arr1, arr2);
  }
}
```

### Common Letters

```java
public class CommonLettersSnippet {

  /**
   * Find Common Characters inside given two strings.
   *
   * @param firstStr  first string
   * @param secondStr second string
   * @return Common Characters.
   */
  public static String getCommonLetters(String firstStr, String secondStr) {
    Set<String> commonLetters = new HashSet<>();
    for (Character currentCharacter : firstStr.toCharArray()) {
      if (isCommonLetter(secondStr, currentCharacter)) {
        commonLetters.add(currentCharacter.toString());
      }
    }
    return String.join(" ", commonLetters);
  }

  private static boolean isCommonLetter(String str, Character character) {
    return str.contains(character.toString()) && Character.isLetter(character);
  }
}
```

### Compare Version

```java
public class CompareVersionSnippet {

  private static final String EXTRACT_VERSION_REGEX = ".*?((?<!\\w)\\d+([.-]\\d+)*).*";

  /**
   * Compares two version strings.
   * Credits: https://stackoverflow.com/a/6702000/6645088 and https://stackoverflow.com/a/44592696/6645088
   *
   * @param v1 the first version string to compare
   * @param v2 the second version string to compare
   * @return the value {@code 0} if the two strings represent same versions;
   *     a value less than {@code 0} if {@code v1} is greater than {@code v2}; and
   *     a value greater than {@code 0} if {@code v2} is greater than {@code v1}
   */
  public static int compareVersion(String v1, String v2) {
    var components1 = getVersionComponents(v1);
    var components2 = getVersionComponents(v2);
    int length = Math.max(components1.length, components2.length);
    for (int i = 0; i < length; i++) {
      Integer c1 = i < components1.length ? Integer.parseInt(components1[i]) : 0;
      Integer c2 = i < components2.length ? Integer.parseInt(components2[i]) : 0;
      int result = c1.compareTo(c2);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }

  private static String[] getVersionComponents(String version) {
    return version.replaceAll(EXTRACT_VERSION_REGEX, "$1").split("\\.");
  }
}
```

### Duplicate Character

```java
public class DuplicateCharacterSnippet {

  /**
   * Remove Duplicate Characters from a string.
   *
   * @param str The string to be processed
   * @return A string with no duplicate characters
   */

  public static String removeDuplicateCharacters(String str) {
    char[] charsOfStr = str.toCharArray();
    Set<String> uniqueCharacters = new HashSet<>();
    for (char character : charsOfStr) {
      uniqueCharacters.add(String.valueOf(character));
    }
    return String.join("", uniqueCharacters);
  }
}
```

### Levenshtein Distance

```java
public class LevenshteinDistanceSnippet {

  /**
   * Find the Levenshtein distance between two words. https://en.wikipedia.org/wiki/Levenshtein_distance
   *
   * @param word1 first word
   * @param word2 second word
   * @return distance
   */
  public static int findLevenshteinDistance(String word1, String word2) {
    // If word2 is empty, removing
    int[][] ans = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      ans[i][0] = i;
    }
    // if word1 is empty, adding
    for (int i = 0; i <= word2.length(); i++) {
      ans[0][i] = i;
    }
    // None is empty
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        int min = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
        ans[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? ans[i - 1][j - 1] : min + 1;
      }
    }
    return ans[word1.length()][word2.length()];
  }
}
```

### Lindenmayer System 

```java
public class LindenmayerSystemSnippet {
  /**
   * Generates an L-system string based on axiom, production rules, and a number of iterations.
   *
   * @param axiom           initial string to begin the L-system
   * @param productionRules map of character rules where each symbol can be replaced with a string
   * @param iterations      number of iterations to apply the production rules
   * @return the generated string after all iterations
   */
  public static String generateLindenmayerSystem(
          String axiom,
          Map<Character, String> productionRules,
          int iterations
  ) {
    String current = axiom;

    for (int i = 0; i < iterations; i++) {
      StringBuilder nextIteration = new StringBuilder(current.length() * 2);

      // Replace each symbol with the corresponding production rule or the symbol itself
      current.chars()
          .mapToObj(c -> (char) c)
          .forEach(symbol ->
                  nextIteration.append(
                          productionRules.getOrDefault(symbol, String.valueOf(symbol))
                  )
          );

      current = nextIteration.toString();
    }
    return current;
  }
}
```

### Max Character Count

```java
public class MaxCharacterCountSnippet {

  /**
   * The maximum count of times a specific character appears in a string.
   *
   * @param str َA specific string
   * @param character A specific character
   * @return the maximum count of one character
   */

  public static int getMaxCharacterCount(String str, char character) {
    int characterCount = 0;
    int maxCharacterCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if ((str.charAt(i)) == character) {
        characterCount++;
        maxCharacterCount = Math.max(maxCharacterCount, characterCount);
      } else {
        characterCount = 0;
      }
    }
    return maxCharacterCount;
  }
}
```

### Palindrome Check

```java
public class PalindromCheckSnippet {

  /**
   * Checks if given string is palindrome (same forward and backward). Skips non-letter characters
   * Credits: https://github.com/kousen/java_8_recipes
   *
   * @param s string to check
   * @return true if palindrome
   */
  public static boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      while (i < j && !Character.isLetter(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetter(s.charAt(j))) {
        j--;
      }

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
    }

    return true;
  }
}
```

### Reverse String

```java
public class ReverseStringSnippet {

  /**
   * Reverse string.
   *
   * @param s the string to reverse
   * @return reversed string
   */
  public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}
```

### String To Date

```java
public class StringToDateSnippet {

  /**
   * Convert string to date.
   *
   * @param date   the date string
   * @param format expected date format
   * @return Date
   * @throws ParseException in case of an unparseable date string
   */
  public static Date stringToDate(String date, String format) throws ParseException {
    var simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.parse(date);
  }
}
```


### KMP Substring Search Algorithm

```java
public class KMPSubstringSearchSnippet {

    /**
     * Implements the Knuth-Morris-Pratt (KMP) algorithm to find the index of the first occurrence of a substring in a given text.
     *
     * @param text The text in which the substring is to be searched.
     * @param pattern The substring pattern to search for.
     * @return The index of the first occurrence of the pattern in the text, or -1 if the pattern is not found.
     */
    public static int kmpSearch(String text, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0; // Trivial case: empty pattern
        }

        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i - j; // Found pattern at index (i - j)
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use the LPS array to skip characters
                } else {
                    i++; // If no match and j is 0, move to the next character in text
                }
            }
        }
        return -1; // Pattern not found
    }

    /**
     * Computes the LPS (Longest Prefix Suffix) array for the pattern, which indicates the longest proper prefix which is also a suffix.
     *
     * @param pattern The pattern for which the LPS array is to be computed.
     * @return The LPS array.
     */
    private static int[] computeLPSArray(String pattern) {
        int length = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0; // LPS for the first character is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Fall back to the previous LPS value
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
```

## Thread

### Thread Pool

### Thread

```java
public class ThreadSnippet {

  /**
   * Creates and returns a new thread with the task assigned to it (task will be performed parallel to the main thread).
   *
   * @param task the task to be executed by this thread
   * @return new thread with task assigned to it.
   */
  public static Thread createThread(Runnable task) {
    return new Thread(task);
  }
}
```

```java
public class ThreadPool {

  /**
   * <p>Creates pool of threads. Where the pool is the size of the number of processors
   * available to the Java virtual machine.</p>
   *
   * @return the newly created thread pool
   */
  public static ExecutorService createFixedThreadPool() {
    return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  }
}
```
