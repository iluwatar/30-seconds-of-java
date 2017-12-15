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
}
