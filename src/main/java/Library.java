import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 * Java Snippets code
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
        T[] result = Arrays.copyOf(first, first.length + second.length);
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

    /**
     * Recursive Fibonacci series
     * Works only for small n and is spectacularly inefficient
     * @param n
     * @return fibonacci number for given n
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * Factorial
     * Works only for small numbers
     * @param number for which factorial is to be calculated for
     * @return factorial
     */
    public static int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    /**
     * Reverse string
     * @param s the string to reverse
     * @return reversed string
     */
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Read file as list of strings
     * @param filename the filename to read from
     * @return list of strings
     * @throws IOException
     */
    public static List<String> readLines(String filename) throws IOException {
        return Files.readAllLines(new File(filename).toPath());
    }

    /**
     * Capture screenshot and save it to a file
     * Credits: https://viralpatel.net/blogs/how-to-take-screen-shots-in-java-taking-screenshots-java/
     * @param filename the name of the file
     * @throws AWTException
     * @throws IOException
     */
    public static void captureScreen(String filename) throws AWTException, IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(filename));
    }

    /**
     * Convert string to date
     * @param date the date string
     * @param format expected date format
     * @return Date
     * @throws ParseException
     */
    public static Date stringToDate(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }

    /**
     * List directories
     * @param path the path where to look
     * @return array of File
     */
    public static File[] listDirectories(String path) {
        return new File(path).listFiles(File::isDirectory);
    }

    /**
     * Checks if given string is palindrome (same forward and backward)
     * Skips non-letter characters
     * Credits: https://github.com/kousen/java_8_recipes
     * @param s string to check
     * @return true if palindrome
     */
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

    /**
     * List files in directory
     * @param folder the path where to look
     * @return array of File
     */
    public static File[] listFilesInDirectory(final File folder) {
        return folder.listFiles(File::isFile);
    }
}
