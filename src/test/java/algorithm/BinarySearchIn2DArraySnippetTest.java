package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchIn2DArraySnippetTest
{
    void testBinarySearchIn2DArraySnippetTest() {
        int[][] arr1 = new int[][]{{3,4,7,9},{12,24,26,29},{34,55,88,99},{100,189,232,234}};
        assertEquals(new int[]{1, 2}, BinarySearchIn2DArraySnippet.BinarySearchIn2Darr(arr1,26));

        int[][] arr2 = new int[][]{{3,4,7,9},{12,24,26,29},{34,55,88,99},{100,189,232,234}};
        assertEquals(new int[]{-1, -1}, BinarySearchIn2DArraySnippet.BinarySearchIn2Darr(arr2,69));
    }
}
