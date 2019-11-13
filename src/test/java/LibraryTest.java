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
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
public class LibraryTest {
  /**
   * Tests for {@link Library#arrayConcat(Object[], Object[])}.
   */
  @Test
  public void testArrayConcat() {
    var integers = Library.arrayConcat(new Integer[5], new Integer[5]);
    assertEquals(integers.length, 10);
    var strings = Library.arrayConcat(new String[0], new String[0]);
    assertEquals(strings.length, 0);
    try {
      var doubles = Library.arrayConcat(null, null);
      fail("Did not throw NPE as expected");
    } catch (NullPointerException e) {
      // expected behaviour, everything is fine
    }
  }

  /**
   * Tests for {@link Library#multiArrayConcat(Object[], Object[][])}.
   */
  @Test
  public void testNArrayConcat() {
    var single = Library.multiArrayConcat(new Integer[1]);
    assertEquals(single.length, 1);
    var multiple
        = Library.multiArrayConcat(new String[5], new String[12], new String[3], new String[8]);
    assertEquals(multiple.length, 28);
    try {
      var doubles = Library.multiArrayConcat(null, null, null, null);
      fail("Did not throw NPE as expected");
    } catch (NullPointerException e) {
      // expected behaviour, everything is fine
    }
  }

  /**
   * Tests for {@link Library#allEqual(Object[])}.
   */
  @Test
  public void testAllEqual() {
    var intArray = new Integer[5];
    assertTrue(Library.allEqual(intArray));
    intArray[0] = 1;
    assertFalse(Library.allEqual(intArray));
    var stringArray = new String[10];
    Arrays.fill(stringArray, "Hello World");
    assertTrue(Library.allEqual(stringArray));
    stringArray[3] = "Bye World";
    assertFalse(Library.allEqual(stringArray));
    var doubleArray = new Double[1];
    assertTrue(Library.allEqual(doubleArray));
    try {
      var res = Library.allEqual(null);
      fail("Did not throw NPE as expected");
    } catch (NullPointerException e) {
      // expected behaviour, everything is fine
    }
  }

  /**
   * Tests for {@link Library#fibonacci(int)}.
   */
  @Test
  public void testFibonacci() {
    assertEquals(0, Library.fibonacci(0));
    assertEquals(1, Library.fibonacci(1));
    assertEquals(1, Library.fibonacci(2));
    assertEquals(2, Library.fibonacci(3));
    assertEquals(3, Library.fibonacci(4));
    assertEquals(5, Library.fibonacci(5));
    assertEquals(8, Library.fibonacci(6));
    assertEquals(13, Library.fibonacci(7));
    assertEquals(21, Library.fibonacci(8));
    assertEquals(34, Library.fibonacci(9));
    assertEquals(55, Library.fibonacci(10));
  }

  /**
   * Tests for {@link Library#factorial(int)}.
   */
  @Test
  public void testFactorial() {
    assertEquals(1, Library.factorial(0));
    assertEquals(1, Library.factorial(1));
    assertEquals(2, Library.factorial(2));
    assertEquals(6, Library.factorial(3));
    assertEquals(24, Library.factorial(4));
    assertEquals(120, Library.factorial(5));
    assertEquals(720, Library.factorial(6));
    assertEquals(5040, Library.factorial(7));
    assertEquals(40320, Library.factorial(8));
    assertEquals(362880, Library.factorial(9));
    assertEquals(3628800, Library.factorial(10));
  }

  /**
   * Tests for {@link Library#reverseString(String)}.
   */
  @Test
  public void testReverseString() {
    assertEquals("oof", Library.reverseString("foo"));
    assertEquals("ÖÄÅ321FED cba", Library.reverseString("abc DEF123ÅÄÖ"));
  }

  /**
   * Tests for {@link Library#readLines(String)}.
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testReadLines() throws IOException {
    var somelines = Library.readLines("src/test/resources/somelines.txt");
    assertEquals(3, somelines.size());
    assertEquals("foo", somelines.get(0));
    assertEquals("bar", somelines.get(1));
    assertEquals("baz", somelines.get(2));
    try {
      Library.readLines("some/nonexistent/filename.txt");
      fail("Did not throw IOException as expected");
    } catch (IOException e) {
      // catched the expected exception
    }
  }

  /**
   * Tests for {@link Library#captureScreen(String)}.
   */
  @Test
  public void testCaptureScreen() throws IOException, AWTException {
    final var filename = "src/test/resources/screenshot.png";
    try {
      Library.captureScreen(filename);
      var f = new File(filename);
      assertTrue(f.exists() && !f.isDirectory());
    } catch (HeadlessException e) {
      // the test runs on a computer without a screen, it is ok to fail
    } finally {
      Files.deleteIfExists(new File(filename).toPath());
    }
  }

  /**
   * Tests for {@link Library#stringToDate(String, String)}.
   */
  @Test
  public void testStringToDate() throws ParseException {
    var calendar = Calendar.getInstance();
    calendar.setTime(Library.stringToDate("2017-08-18", "yyyy-MM-dd"));
    assertEquals(2017, calendar.get(Calendar.YEAR));
    assertEquals(8, calendar.get(Calendar.MONTH) + 1);
    assertEquals(18, calendar.get(Calendar.DAY_OF_MONTH));
  }

  /**
   * Tests for {@link Library#listDirectories(String)}.
   */
  @Test
  public void testListDirectories() {
    var files = Library.listDirectories("src/test/resources");
    Arrays.stream(files).allMatch(f -> f.isDirectory());
    assertTrue(Arrays.stream(files).anyMatch(new File("src/test/resources/dir1")::equals));
    assertTrue(Arrays.stream(files).anyMatch(new File("src/test/resources/dir2")::equals));
  }

  /**
   * Tests for {@link Library#isPalindrome(String)}.
   */
  @Test
  public void testIsPalindrome() {
    assertTrue(Library.isPalindrome("saippuakauppias"));
    // non-letter characters are skipped
    assertTrue(Library.isPalindrome("111 Saippua - Kauppias 321"));
    assertFalse(Library.isPalindrome("Type O Negative"));
    assertFalse(Library.isPalindrome("Foo12121Bar"));
  }

  /**
   * Tests for {@link Library#listFilesInDirectory(File)}.
   */
  @Test
  public void testListFilesInDirectory() {
    var files = Library.listFilesInDirectory(new File("src/test/resources"));
    assertEquals(2, files.length);
    var filenames = new HashSet<>(Arrays.asList(files[0].toString(), files[1].toString()));
    assertTrue(filenames.contains("src/test/resources/somelines.txt"));
    assertTrue(filenames.contains("src/test/resources/someotherlines.txt"));
  }

  /**
   * Tests for {@link Library#listAllFiles(String)}.
   */
  @Test
  public void testListAllFiles() {
    var files = Library.listAllFiles("src/test/resources");
    assertEquals(4, files.size());
  }

  /**
   * Tests for {@link Library#performLottery(int, int)}.
   */
  @Test
  public void testPerformLottery() {
    var numbers0 = Library.performLottery(0, 0);
    assertArrayEquals(new Integer[]{}, numbers0);
    var numbers1 = Library.performLottery(1, 1);
    assertArrayEquals(new Integer[]{1}, numbers1);
    var numbers2 = Library.performLottery(2, 2);
    assertEquals(2, numbers2.length);
    assertTrue(numbers2[0] == 1 || numbers2[0] == 2);
    assertTrue(numbers2[1] == 1 || numbers2[1] == 2);
  }

  /**
   * Tests for {@link Library#zipFile(String, String)}.
   */
  @Test
  public void testZipFile() throws IOException {
    final var src = "src/test/resources/somelines.txt";
    final var dst = "src/test/resources/somelines.zip";
    try {
      Library.zipFile(src, dst);
      assertTrue(Files.exists(Paths.get(dst)));
    } finally {
      Files.deleteIfExists(new File(dst).toPath());
    }
  }

  /**
   * Tests for {@link Library#zipFiles(String[], String)}.
   */
  @Test
  public void testZipFiles() throws IOException {
    final String[] srcFilenames =
        {"src/test/resources/somelines.txt", "src/test/resources/someotherlines.txt"};
    final var dst = "src/test/resources/multiple.zip";
    try {
      Library.zipFiles(srcFilenames, dst);
      assertTrue(Files.exists(Paths.get(dst)));
    } finally {
      Files.deleteIfExists(new File(dst).toPath());
    }
  }

  /**
   * Tests for {@link Library#quickSort(int[], int, int)}.
   */
  @Test
  public void testQuickSort() {
    var arr = new int[]{7, 13, 3, 1, 8, 5};
    Library.quickSort(arr, 0, arr.length - 1);
    assertEquals(arr.length, 6);
    assertEquals(arr[0], 1);
    assertEquals(arr[1], 3);
    assertEquals(arr[2], 5);
    assertEquals(arr[3], 7);
    assertEquals(arr[4], 8);
    assertEquals(arr[5], 13);
  }

  /**
   * Tests for {@link Library#httpGet(String)}.
   */
  @Test
  public void testHttpGet() throws Exception {
    var response = Library.httpGet("http://www.google.com");
    assertEquals(200, response.statusCode());
  }

  /**
   * Tests for {@link Library#httpPost(String, HashMap)}.
   */
  @Test
  public void testHttpPost() throws IOException, InterruptedException {
    HashMap<String, String> arguments = new HashMap<>();
    arguments.put("data", "Hello World");
    var result = Library.httpPost("https://postman-echo.com/post", arguments);
    //This postman endpoint echoes the HTTP headers, request parameters, the contents
    //of the request body and the complete URI requested.
    var echoedData = "\"data\":\"Hello World\"";
    assertThat(result.body(), containsString(echoedData));
  }

  /**
   * Tests for {@link Library#isPrime(int)}.
   */
  @Test
  public void testIsPrime() {
    assertTrue(Library.isPrime(2));
    assertTrue(Library.isPrime(3));
    assertTrue(Library.isPrime(17));
    assertTrue(Library.isPrime(97));
    assertFalse(Library.isPrime(4));
    assertFalse(Library.isPrime(100));
  }

  /**
   * Tests for {@link Library#gcd(int, int)}.
   */
  @Test
  public void testGcd() {
    assertEquals(Library.gcd(2, 4), 2);
    assertEquals(Library.gcd(2, 5), 1);
    assertEquals(Library.gcd(18, 24), 6);
    assertEquals(Library.gcd(7, 7), 7);
  }

  /**
   * Tests for {@link Library#isAnagram(String, String)}.
   */
  @Test
  public void testIsAnagram() {
    assertTrue(Library.isAnagram("Aditya","aytdiA"));
    assertFalse(Library.isAnagram("Aditya","aytida"));
    assertTrue(Library.isAnagram("~~# @!","~@!#~ "));
    assertTrue(Library.isAnagram("Mother In Law","hIt Ler woMan"));
    assertFalse(Library.isAnagram("aa","aaa"));
  }

  /**
   * Tests for {@link Library#getAllMethods(Class)}.
   */
  @Test
  public void testGetAllMethods() {
    var list = Library.getAllMethods(Library.class);
    assertEquals("arrayConcat", list.get(0));
    assertEquals("multiArrayConcat", list.get(1));
    assertNotEquals("multiArrayConcat", list.get(0));
    assertNotEquals("arrayConcat", list.get(1));
  }
}
