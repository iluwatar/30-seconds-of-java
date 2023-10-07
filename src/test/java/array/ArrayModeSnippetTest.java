package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayModeSnippetTest {

    void testModeArray()
    {
        assertEquals(2, ArrayModeSnippet.modeArray(new int[] {1,2,3,2,4,2,2}));
        assertEquals(-8, ArrayModeSnippet.modeArray(new int[] {-43, -8, -8, -10, -8, -65, -9}));
        assertEquals(0, ArrayModeSnippet.modeArray(new int[] {-4, 0, -2, -1, 0}));
        assertEquals(1, ArrayModeSnippet.modeArray(new int[] {1, 1, 1, 1, 1, 1}));
    }
}
