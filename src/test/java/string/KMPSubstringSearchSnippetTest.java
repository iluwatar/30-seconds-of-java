package string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class KMPSubstringSearchSnippetTest {

    /**
     * Tests for {@link KMPSubstringSearchSnippet#kmpSearch(String, String)}.
     */
    @Test
    void testKmpSearch() {
        // Test cases for KMP substring search
        assertEquals(6, KMPSubstringSearchSnippet.kmpSearch("abxabcabcaby", "abcaby"));
        assertEquals(7, KMPSubstringSearchSnippet.kmpSearch("subash pandey", "pandey"));
        assertEquals(-1, KMPSubstringSearchSnippet.kmpSearch("abcd", "e"));
        assertEquals(0, KMPSubstringSearchSnippet.kmpSearch("aaaaa", "a"));
        assertEquals(2, KMPSubstringSearchSnippet.kmpSearch("abcdabcd", "cdab"));
    }
}
