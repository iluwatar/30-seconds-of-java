package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
public class CommonLettersSnippetTest {
    /**
     * Tests for {@link CommonLettersSnippet#getCommonLetters(String, String)}.
     */

    @Test
    public void testgetCommonLetters() {
        String str = "abfcd!?055bcxaz^fg#)";
        String str2 = "b45893fndg%+1vc";
        assertEquals("b c d f g", CommonLettersSnippet.getCommonLetters(str, str2));
    }

}
