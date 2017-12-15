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
}
