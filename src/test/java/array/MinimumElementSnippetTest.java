package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for finding minimum element of an array
 */

public class MinimumElementSnippetTest {

    @Test
    void findMinTest() {
        assertEquals(MinimumElementSnippet.findMin(new int[]{5, 11, 3, 6, 8}), 3);
        assertEquals(MinimumElementSnippet.findMin(new int[]{5}), 5);
        assertEquals(MinimumElementSnippet.findMin(new int[]{0}), 0);
    }

}
