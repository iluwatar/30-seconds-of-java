/**
 * MIT License
 *
 * Copyright (c) 2017-2018 Ilkka Seppälä
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
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/*
 * Java Snippets tests
 *
 */
public class LibraryTest {
    /**
     * Tests for {@link Library#arrayConcat(Object[], Object[])}
     */
    @Test
    public void testArrayConcat() {
        Integer[] integers = Library.arrayConcat(new Integer[5], new Integer[5]);
        assertEquals(integers.length, 10);
        String[] strings = Library.arrayConcat(new String[0], new String[0]);
        assertEquals(strings.length, 0);
        try {
            Double[] doubles = Library.arrayConcat(null, null);
            fail();
        } catch (NullPointerException e) {
            // expected behaviour, everything is fine
        }
    }

    /**
     * Tests for {@link Library#nArrayConcat(Object[], Object[][])}
     */
    @Test
    public void testNArrayConcat() {
        Integer[] single = Library.nArrayConcat(new Integer[1]);
        assertEquals(single.length, 1);
        String[] multiple = Library.nArrayConcat(new String[5], new String[12], new String[3], new String[8]);
        assertEquals(multiple.length, 28);
        try {
            Double[] doubles = Library.nArrayConcat(null, null, null, null);
            fail();
        } catch (NullPointerException e) {
            // expected behaviour, everything is fine
        }
    }

    /**
     * Tests for {@link Library#fibonacci(int)}
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
     * Tests for {@link Library#factorial(int)}
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
     * Tests for {@link Library#reverseString(String)}
     */
    @Test
    public void testReverseString() {
        assertEquals("oof", Library.reverseString("foo"));
        assertEquals("ÖÄÅ321FED cba", Library.reverseString("abc DEF123ÅÄÖ"));
    }

    /**
     * Tests for {@link Library#readLines(String)}
     * @throws IOException
     */
    @Test
    public void testReadLines() throws IOException {
        List<String> somelines = Library.readLines("src/test/resources/somelines.txt");
        assertEquals(3, somelines.size());
        assertEquals("foo", somelines.get(0));
        assertEquals("bar", somelines.get(1));
        assertEquals("baz", somelines.get(2));
        try {
            Library.readLines("some/nonexistent/filename.txt");
            fail();
        } catch (IOException e) {
            // catched the expected exception
        }
    }
    /**
     * Tests for {@link Library#captureScreen(String)}
     */
    @Test
    public void testCaptureScreen() throws IOException, AWTException {
        final String filename = "src/test/resources/screenshot.png";
        try {
            Library.captureScreen(filename);
            File f = new File(filename);
            assertTrue(f.exists() && !f.isDirectory());
        } catch (HeadlessException e) {
            // the test runs on computer without a screen, it is ok to fail
        } finally {
            Files.deleteIfExists(new File(filename).toPath());
        }
    }
    /**
     * Tests for {@link Library#stringToDate(String, String)}
     */
    @Test
    public void testStringToDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Library.stringToDate("2017-08-18", "yyyy-MM-dd"));
        assertEquals(2017, calendar.get(Calendar.YEAR));
        assertEquals(8, calendar.get(Calendar.MONTH) + 1);
        assertEquals(18, calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Tests for {@link Library#listDirectories(String)}
     */
    @Test
    public void testListDirectories() {
        File[] files = Library.listDirectories("src/test/resources");
        Arrays.stream(files).allMatch(f -> f.isDirectory());
        assertTrue(Arrays.stream(files).anyMatch(new File("src/test/resources/dir1")::equals));
        assertTrue(Arrays.stream(files).anyMatch(new File("src/test/resources/dir2")::equals));
    }

    /**
     * Tests for {@link Library#isPalindrome(String)}
     */
    @Test
    public void testIsPalindrome() {
        assertTrue(Library.isPalindrome("saippuakauppias"));
        assertTrue(Library.isPalindrome("111 Saippua - Kauppias 321"));
        assertFalse(Library.isPalindrome("Type O Negative"));
        assertFalse(Library.isPalindrome("Foo12121Bar"));
    }

    /**
     * Tests for {@link Library#listFilesInDirectory(File)}
     */
    @Test
    public void testListFilesInDirectory() {
        File[] files = Library.listFilesInDirectory(new File("src/test/resources"));
        assertEquals(2, files.length);
        assertEquals("src/test/resources/somelines.txt", files[0].toString());
        assertEquals("src/test/resources/someotherlines.txt", files[1].toString());
    }

    /**
     * Tests for {@link Library#listAllFiles(String)}
     */
    @Test
    public void testListAllFiles() {
        List<File> files = Library.listAllFiles("src/test/resources");
        assertEquals(4, files.size());
    }

    /**
     * Tests for {@link Library#performLottery(int, int)}
     */
    @Test
    public void testPerformLottery() {
        Integer[] numbers0 = Library.performLottery(0, 0);
        assertArrayEquals(new Integer[]{}, numbers0);
        Integer[] numbers1 = Library.performLottery(1, 1);
        assertArrayEquals(new Integer[]{1}, numbers1);
        Integer[] numbers2 = Library.performLottery(2, 2);
        assertEquals(2, numbers2.length);
        assertTrue(numbers2[0] == 1 || numbers2[0] == 2);
        assertTrue(numbers2[1] == 1 || numbers2[1] == 2);
    }

    /**
     * Tests for {@link Library#zipFile(String, String)}
     */
    @Test
    public void testZipFile() throws IOException {
        final String src = "src/test/resources/somelines.txt";
        final String dst = "src/test/resources/somelines.zip";
        try {
            Library.zipFile(src, dst);
            assertTrue(Files.exists(Paths.get(dst)));
        } finally {
            Files.deleteIfExists(new File(dst).toPath());
        }
    }

    /**
     * Tests for {@link Library#zipFiles(String[], String)}
     */
    @Test
    public void testZipFiles() throws IOException {
        final String[] srcFilenames = {"src/test/resources/somelines.txt", "src/test/resources/someotherlines.txt"};
        final String dst = "src/test/resources/multiple.zip";
        try {
            Library.zipFiles(srcFilenames, dst);
            assertTrue(Files.exists(Paths.get(dst)));
        } finally {
            Files.deleteIfExists(new File(dst).toPath());
        }
    }

    /**
     * Tests for {@link Library#quickSort(int[], int, int)}
     */
    @Test
    public void testQuickSort() {
        int[] arr = new int[] {7, 13, 3, 1, 8, 5};
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
     * Tests for {@link Library#httpGet(URL)}
     */
    @Test
    public void testHttpGet() throws IOException {
        int responseCode = Library.httpGet(new URL("http://www.google.com"));
        assertEquals(200, responseCode);
    }
    
    /**
     * Tests for {@link Library#isPrime(int)}
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
}
