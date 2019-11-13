/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;

/*
 * 30 Seconds of Java code library
 *
 */
public class Library {
  /**
   * Generic 2 array concatenation
   * Credits: Joachim Sauer https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
   * @param first is the first array (not null)
   * @param second is the second array (not null)
   * @param <T> the element type
   * @return concatenated array
   */
  public static <T> T[] arrayConcat(T[] first, T[] second) {
    var result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }

  /**
   * Generic N array concatenation
   * Credits: Joachim Sauer https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
   * @param first is the first array (not null)
   * @param rest the rest of the arrays (optional)
   * @param <T> the element type
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

  /**
   * Returns true if all elements in array are equal.
   * @param arr the array to check (not null)
   * @param <T> the element type
   * @return true if all elements in the array are equal
   */
  public static <T> boolean allEqual(T[] arr) {
    return Arrays.stream(arr).distinct().count() == 1;
  }

  /**
   * Recursive Fibonacci series.
   * Works only for small n and is spectacularly inefficient
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
   * Factorial.
   * Works only for small numbers
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
   * Reverse string.
   * @param s the string to reverse
   * @return reversed string
   */
  public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  /**
   * Read file as list of strings.
   * @param filename the filename to read from
   * @return list of strings
   * @throws IOException if an I/O error occurs
   */
  public static List<String> readLines(String filename) throws IOException {
    return Files.readAllLines(Paths.get(filename));
  }

  /**
   * Capture screenshot and save it to PNG file.
   * Credits: https://viralpatel.net/blogs/how-to-take-screen-shots-in-java-taking-screenshots-java/
   * @param filename the name of the file
   * @throws AWTException if the platform configuration does not allow low-level input control
   * @throws IOException if an I/O error occurs
   */
  public static void captureScreen(String filename) throws AWTException, IOException {
    var screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    var screenRectangle = new Rectangle(screenSize);
    var robot = new Robot();
    var image = robot.createScreenCapture(screenRectangle);
    ImageIO.write(image, "png", new File(filename));
  }

  /**
   * Convert string to date.
   * @param date the date string
   * @param format expected date format
   * @return Date
   * @throws ParseException in case of an unparseable date string
   */
  public static Date stringToDate(String date, String format) throws ParseException {
    var simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.parse(date);
  }

  /**
   * List directories.
   * @param path the path where to look
   * @return array of File
   */
  public static File[] listDirectories(String path) {
    return new File(path).listFiles(File::isDirectory);
  }

  /**
   * Checks if given string is palindrome (same forward and backward).
   * Skips non-letter characters
   * Credits: https://github.com/kousen/java_8_recipes
   * @param s string to check
   * @return true if palindrome
   */
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

  /**
  * Checks if two words are anagrams (contains same characters with same frequency in any order).
  * @param s1 The first string to be checked
  * @param s2 The second string to be checked
  * @return true if they are anagrams of each other
  */
  public static boolean isAnagram(String s1, String s2) {
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

  /**
   * List files in directory.
   * @param folder the path where to look
   * @return array of File
   */
  public static File[] listFilesInDirectory(File folder) {
    return folder.listFiles(File::isFile);
  }

  /**
   * Recursively list all the files in directory.
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

  /**
   * Generate random lottery numbers.
   * @param numNumbers how many performLottery numbers are available (e.g. 49)
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

  /**
   * Zip single file.
   * @param srcFilename the filename of the source file
   * @param zipFilename the filename of the destination zip file
   * @throws IOException if an I/O error occurs
   */
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

  /**
   * Zip multiples files.
   * @param srcFilenames array of source file names
   * @param zipFilename the filename of the destination zip file
   * @throws IOException if an I/O error occurs
   */
  public static void zipFiles(String[] srcFilenames, String zipFilename) throws IOException {
    try (
        var fileOut = new FileOutputStream(zipFilename);
        var zipOut = new ZipOutputStream(fileOut);
    ) {
      for (var i = 0; i < srcFilenames.length; i++) {
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

  /**
   * Sort an array with quicksort algorithm.
   * @param arr array to sort
   * @param left left index where to begin sort (e.g. 0)
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

  /**
   * Performs HTTP GET request.
   * @param uri the URI of the connection
   * @return response object
   * @throws Exception i/o error, interruption error, etc
   */
  public static HttpResponse<String> httpGet(String uri) throws Exception {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .build();
    return client.send(request, BodyHandlers.ofString());
  }

  /**
   * Performs HTTP POST request.
   * Credits https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java
   * @param address the URL of the connection in String format, like "http://www.google.com"
   * @param arguments the body of the POST request, as a HashMap
   * @return response object
   * @throws IOException if an I/O error occurs
   * @throws InterruptedException if the operation is interrupted
   */
  public static HttpResponse<String> httpPost(String address, HashMap<String, String> arguments)
      throws IOException, InterruptedException {
    var sj = new StringJoiner("&");
    for (var entry : arguments.entrySet()) {
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

  /**
   * Checks if given number is a prime number.
   * Prime number is a number that is greater than 1 and divided by 1 or itself only
   * Credits: https://en.wikipedia.org/wiki/Prime_number
   * @param number number to check prime
   * @return true if prime
   */
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

  /**
   * Greatest common divisor calculation.
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

  /**
   * Print all declared methods of the class
   * @param cls Tested class
   * @return list of methods name
   */
  public static List<String> getAllMethods(final Class<?> cls) {
    var list = new ArrayList<String>();
    for (var method : cls.getDeclaredMethods()) {
      list.add(method.getName());
    }
    return list;
  }
}
