 package algorithm;

 import static org.junit.jupiter.api.Assertions.assertEquals;
 
 import org.junit.jupiter.api.Test;
 
 
 /*
  * Tests for 30 Seconds of Java code library
  *
  */
 class MergeSortSnippetTest {
   /**
    * Tests for {@link MergeSortSnippet#mergeSort(int[], int, int)}.
    */
   @Test
   void testMergeSort() {
     var arr = new int[] {7, 13, 3, 1, 8, 5};
     MergeSortSnippet.mergeSort(arr, 0, arr.length - 1);
     assertEquals(6, arr.length);
     assertEquals(1, arr[0]);
     assertEquals(3, arr[1]);
     assertEquals(5, arr[2]);
     assertEquals(7, arr[3]);
     assertEquals(8, arr[4]);
     assertEquals(13, arr[5]);
   }
 }
