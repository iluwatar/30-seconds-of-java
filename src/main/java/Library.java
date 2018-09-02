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
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
			
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

    /**
     * Recursively list all the files in directory
     * @param path the path to start the search from
     * @return list of all files
     */
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

    /**
     * Generate random lottery numbers
     * @param numNumbers how many performLottery numbers are available (e.g. 49)
     * @param numbersToPick how many numbers the player needs to pick (e.g. 6)
     * @return array with the random numbers
     */
    public static Integer[] performLottery(int numNumbers, int numbersToPick) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < numNumbers; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
    }

    /**
     * Zip single file
     * @param srcFilename the filename of the source file
     * @param zipFilename the filename of the destination zip file
     * @throws IOException
     */
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

    /**
     * Zip multiples files
     * @param srcFilenames array of source file names
     * @param zipFilename the filename of the destination zip file
     * @throws IOException
     */
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

    /**
     * Sort an array with quicksort algorithm
     * @param arr array to sort
     * @param left left index where to begin sort (e.g. 0)
     * @param right right index where to end sort (e.g. array length - 1)
     */
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

    /**
     * Performs HTTP GET request
     * @param address the URL of the connection
     * @return HTTP status code
     * @throws IOException
     */
    public static int httpGet(URL address) throws IOException {
        HttpURLConnection con = (HttpURLConnection) address.openConnection();
        return con.getResponseCode();
    }
    
    /**
     * Checks if given number is a prime number
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
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
