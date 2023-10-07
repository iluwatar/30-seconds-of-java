package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchIn2DArraySnippetTest {
    void testLinearSearchIn2DArraySnippetTest() {
        int[][] arr1 = new int[][]{{3,4,7,9},{12,24,26,29},{34,55,88,99},{100,189,232,234}};
        assertEquals(new int[]{1, 2}, LinearSearchIn2DArraySnippet.LinearSearchIn2DArray(arr1,26));

        int[][] arr2 = new int[][]{{3,4,7,9},{12,24,26,29},{34,55,88,99},{100,189,232,234}};
        assertEquals(new int[]{-1, -1}, LinearSearchIn2DArraySnippet.LinearSearchIn2DArray(arr2,69));
    }
}
