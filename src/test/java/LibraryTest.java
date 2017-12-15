import org.junit.Test;
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
}
