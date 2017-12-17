import java.util.Arrays;

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
}
