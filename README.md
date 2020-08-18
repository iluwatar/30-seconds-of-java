# 30 Seconds of Java

![Java CI with Gradle](https://github.com/iluwatar/30-seconds-of-java/workflows/Java%20CI%20with%20Gradle/badge.svg)
[![Join the chat at https://gitter.im/iluwatar/30-seconds-of-java](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/iluwatar/30-seconds-of-java?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Inspired by [30 seconds of code](https://github.com/Chalarangelo/30-seconds-of-code), this is a collection of reusable 
tested Java 11 compatible code snippets that you can understand in 30 seconds or less.

## How to contribute

In general we are interested in well implemented standalone code snippets. There are some tasks that we would like to
see implemented in the [issue list](https://github.com/iluwatar/30-seconds-of-java/issues). Please raise a new issue
if there's an interesting snippet you would like to see in this library but can't implement yourself.

For new snippets the general implementation steps are:

* Update `Library.java` with the new code snippet. 
* Add a test for the new code snippet in `LibraryTest.java`.
* Finally insert the new snippet into this `README.md`.
* Submit pull request against `master` branch.

## Table of Contents

### Algorithm

* [Quicksort](#quicksort)
* [Bubblesort](#bubblesort)
* [Selectionsort](#selectionsort)

### Array

* [Generic two array concatenation](#generic-two-array-concatenation)
* [Generic N array concatenation](#generic-n-array-concatenation)
* [Check if all elements of array are equal](#check-if-all-elements-of-array-are-equal)
* [Find maximum integer from the array](#find-maximum-integer-from-the-array)

### File

* [List directories](#list-directories)
* [List files in directory](#list-files-in-directory)
* [List files in directory recursively](#list-files-in-directory-recursively)
* [Read lines from file to string list](#read-lines-from-file-to-string-list)
* [Zip file](#zip-file)
* [Zip multiple files](#zip-multiple-files)

### Math

* [Factorial](#factorial)
* [Fibonacci](#fibonacci)
* [Lottery](#lottery)
* [Euclid's algorithm for greatest common divisor](#greatest-common-divisor)
* [Prime](#prime)

### Media

* [Capture screen](#capture-screen)

### Networking

* [HTTP GET](#http-get)
* [HTTP POST](#http-post)

### String

* [Palindrome check](#palindrome-check)
* [Reverse string](#reverse-string)
* [String to date](#string-to-date)
* [Anagram check](#anagram-check)
* [Find Levenshtein distance](#find-levenshtein-distance)

### Class

* [Get methods name](#get-methods-name)
* [Get fields name](#get-fields-name)
* [Create object](#create-object)

### I/O
* [Read file by stream](#read-file-by-stream)
* [Convert InputStream to String](#inputstream-to-string)

## Algorithm

### Quicksort

```java
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
```

### Bubblesort

```java
  public static void bubbleSort(int[] arr) {
    var lastIndex = arr.length - 1;

    for(var j = 0; j < lastIndex; j++) {
      for(var i = 0; i < lastIndex - j; i++) {
        if(arr[i] > arr[i + 1]) {
          var tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
        }
      }
    }
  }
```

### Selectionsort

```java
    public static void selectionSort(int[] arr) {
        var len = arr.length;
        
        for (var i = 0; i < len - 1; i++) {
            var minIndex = i;
        
            for (var j = i + 1; j < len; j++) {
                if(arr[j] < arr[minIndex])
                  minIndex = j;
            }
        
            var tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }
```

## Array

### Generic two array concatenation

```java
    public static <T> T[] arrayConcat(T[] first, T[] second) {
        var result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
```

### Generic N array concatenation

```java
    public static <T> T[] nArrayConcat(T[] first, T[]... rest) {
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
```

### Check if all elements of array are equal

```java
  public static <T> boolean allEqual(T[] arr) {
    return Arrays.stream(arr).distinct().count() == 1;
  }
```

### Find maximum integer from the array

```java
   public static int findMax(int[] arr) {
      return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
    }
```

## File

### List directories

```java
    public static File[] listDirectories(String path) {
        return new File(path).listFiles(File::isDirectory);
    }
```

### List files in directory

```java
    public static File[] listFilesInDirectory(final File folder) {
        return folder.listFiles(File::isFile);
    }
```

### List files in directory recursively

```java
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
```

### Read lines from file to string list

```java
    public static List<String> readLines(String filename) throws IOException {
        return Files.readAllLines(new File(filename).toPath());
    }
```

### Zip file

```java
    public static void zipFile(String srcFilename, String zipFilename) throws IOException {
        var srcFile = new File(srcFilename);
        try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut);
            var fileIn = new FileInputStream(srcFile);
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
```

### Zip multiple files

```java
    public static void zipFiles(String[] srcFilenames, String zipFilename) throws IOException {
        try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut);
        ) {
            for (var i=0; i<srcFilenames.length; i++) {
                var srcFile = new File(srcFilenames[i]);
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
```

## Math

### Fibonacci

```java
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
```

### Factorial

```java
    public static int factorial(int number) {
        var result = 1;
        for (var factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
```

### Lottery

```java
    public static Integer[] performLottery(int numNumbers, int numbersToPick) {
        var numbers = new ArrayList<Integer>();
        for(var i = 0; i < numNumbers; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
    }
```

### Greatest Common Divisor

```java
    public static int gcd(int a, int b) { 
        if (b == 0) 
            return a; 
        return gcd(b, a % b);  
    }
```

### Prime

```java
	public static boolean isPrime(int number) {
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
```

## Media

### Capture screen

```java
    public static void captureScreen(String filename) throws AWTException, IOException {
        var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        var screenRectangle = new Rectangle(screenSize);
        var robot = new Robot();
        var image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(filename));
    }
```

## Networking

### HTTP GET

```java
    public static HttpResponse<String> httpGet(String uri) throws Exception {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        return client.send(request, BodyHandlers.ofString());
    }
```

### HTTP POST

```java
    public static HttpResponse<String> httpPost(String address, HashMap<String,String> arguments) throws IOException, InterruptedException{
        var sj = new StringJoiner("&");
        for(var entry : arguments.entrySet()) {
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
                 + URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        var out = sj.toString().getBytes(StandardCharsets.UTF_8);
        var request = HttpRequest.newBuilder()
                           .uri(URI.create(address))
                           .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                           .POST(BodyPublishers.ofByteArray(out))
                           .build();

        return HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
    }
```

## String

### Palindrome check

```java
    public static boolean isPalindrome(String s) {
        var sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        var forward = sb.toString().toLowerCase();
        var backward = sb.reverse().toString().toLowerCase();
        return forward.equals(backward);
    }
```

### Reverse string

```java
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
```

### String to date

```java
    public static Date stringToDate(String date, String format) throws ParseException {
        var simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }
```

### Anagram Check

```java
public boolean isAnagram(String s1, String s2) {
	var l1 = s1.length();
	var l2 = s2.length();
	var arr1 = new int[256];
	var arr2 = new int[256];
	if (l1 != l2) {
	  return false;
	}
	for (var i = 0; i < l1; i++) {
	  arr1[s1.charAt(i)]++;
	  arr2[s2.charAt(i)]++;
	}
	return Arrays.equals(arr1, arr2);
  }
```

## Class

### Get methods name

```java
    public static List<String> getAllMethods(final Class<?> cls) {
        var list = new ArrayList<String>();
        for (var method : cls.getDeclaredMethods()) {
          list.add(method.getName());
        }
        return list;
    }
```

### Get fields name

```java
  public static List<String> getAllFieldNames(final Class<?> cls) {
    return Arrays.stream(cls.getFields())
            .map(Field::getName)
            .collect(Collectors.toList());
  }
```

### Create object

```java
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
```

### Find Levenshtein distance

```java
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
```

## I/O

### Read file by stream

```java
  public static List<String> readFile(String fileName) throws FileNotFoundException {
    try (Stream<String> stream = new BufferedReader(new FileReader(fileName)).lines()) {
      return stream.collect(Collectors.toList());
    }
  }
```

### InputStream to String

```java
   public static String inputStreamToString(InputStream inputStream) throws IOException {
     try (var reader = new BufferedReader(new InputStreamReader(inputStream))) {
       var stringBuilder = new StringBuilder();
       var data = reader.read();
 
       while (data != -1) {
         stringBuilder.append((char) data);
         data = reader.read();
       }
       return stringBuilder.toString();
     }
   }
```
