import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
        assertEquals(1, files.length);
        assertEquals("src/test/resources/somelines.txt", files[0].toString());
    }
}
