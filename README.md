# Java Snippets

[![Build status](https://travis-ci.org/iluwatar/java-snippets.svg?branch=master)](https://travis-ci.org/iluwatar/java-snippets)

Inspired by [30 seconds of code](https://github.com/Chalarangelo/30-seconds-of-code), this is a collection of reusable tested Java code snippets.

## How to contribute
Update the sample application with the snippet and add a test for it. After proving that it works update this README.md.

## Table of Contents

### Algorithm
* [Quicksort](#quicksort)

### Array
* [Generic two array concatenation](#generic-two-array-concatenation)
* [Generic N array concatenation](#generic-N-array-concatenation)

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
* [Prime](#prime)

### Media
* [Capture screen](#capture-screen)

### Networking
* [HTTP GET](#http-get)

### String
* [Palindrome check](#palindrome-check)
* [Reverse string](#reverse-string)
* [String to date](#string-to-date)

## Algorithm

### Quicksort

```java
    public static void quickSort(int[] arr, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivotValue) {
                i++;
            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
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

[⬆ back to top](#table-of-contents)

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

### List directories

```java
    public static File[] listDirectories(String path) {
        return new File(path).listFiles(File::isDirectory);
    }
```

[⬆ back to top](#table-of-contents)

### List files in directory

```java
    public static File[] listFilesInDirectory(final File folder) {
        return folder.listFiles(File::isFile);
    }
```

[⬆ back to top](#table-of-contents)

### List files in directory recursively

```java
    public static List<File> listAllFiles(String path) {
        List<File> all = new ArrayList<>();
        File[] list = new File(path).listFiles();
        if (list != null) {  // In case of access error, list is null
            for (File f : list) {
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

[⬆ back to top](#table-of-contents)

### Read lines from file to string list

```java
    public static List<String> readLines(String filename) throws IOException {
        return Files.readAllLines(new File(filename).toPath());
    }
```

[⬆ back to top](#table-of-contents)

### Zip file

```java
    public static void zipFile(String srcFilename, String zipFilename) throws IOException {
        File srcFile = new File(srcFilename);
        try (
            FileOutputStream fileOut = new FileOutputStream(zipFilename);
            ZipOutputStream zipOut = new ZipOutputStream(fileOut);
            FileInputStream fileIn = new FileInputStream(srcFile);
        ) {
            ZipEntry zipEntry = new ZipEntry(srcFile.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
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
            FileOutputStream fileOut = new FileOutputStream(zipFilename);
            ZipOutputStream zipOut = new ZipOutputStream(fileOut);
        ) {
            for (int i=0; i<srcFilenames.length; i++) {
                File srcFile = new File(srcFilenames[i]);
                try (FileInputStream fileIn = new FileInputStream(srcFile)) {
                    ZipEntry zipEntry = new ZipEntry(srcFile.getName());
                    zipOut.putNextEntry(zipEntry);
                    final byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fileIn.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                }
            }
        }
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

### Lottery

```java
    public static Integer[] performLottery(int numNumbers, int numbersToPick) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < numNumbers; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
    }
```

[⬆ back to top](#table-of-contents)

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
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
```

[⬆ back to top](#table-of-contents)

## Media

### Capture screen

```java
    public static void captureScreen(String filename) throws AWTException, IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(filename));
    }
```

[⬆ back to top](#table-of-contents)

## Networking

### HTTP GET

```java
    public static int httpGet(URL address) throws IOException {
        HttpURLConnection con = (HttpURLConnection) address.openConnection();
        return con.getResponseCode();
    }
```

[⬆ back to top](#table-of-contents)

## String

### Palindrome check

```java
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();
        return forward.equals(backward);
    }
```

[⬆ back to top](#table-of-contents)

### Reverse string

```java
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
```

[⬆ back to top](#table-of-contents)

### String to date

```java
    public static Date stringToDate(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }
```

[⬆ back to top](#table-of-contents)
