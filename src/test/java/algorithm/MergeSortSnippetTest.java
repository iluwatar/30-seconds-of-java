package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortSnippetTest {

    /**
     * Tests for {@link MergeSortSnippet#mergeSort(int[] arr)}.
     */
    @Test
    void testMergeSort() {
        var arr = new int[] {6, 3, 1, 5, 4, 2};
        MergeSortSnippet.mergeSort(arr);
        assertEquals(6, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
        assertEquals(4, arr[3]);
        assertEquals(5, arr[4]);
        assertEquals(6, arr[5]);
    }

}
