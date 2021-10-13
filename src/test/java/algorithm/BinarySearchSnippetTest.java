/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */

class BinarySearchSnippetTest {
  /**
   * Tests for {@link BinarSearchSnippet#binarySearch(int[] arr,int l,int r,int x)}.
   */

    private final BinarySearchSnippet finding = new BinarySearchSnippet();

    @Test
    void testBinarySearch() {
      
        var arr=new int[] {1,2,3,4,5,6};
        int a=BinarySearchSnippet.binarySearch(arr,0,arr.length-1,2);
        assertEquals(2,a);   // It tests if 2 is present in arr and compares the index returned
        a=BinarySearchSnippet.binarySearch(arr,0,arr.length-1,4);
        assertEquals(4,a);   // It tests if 4 is present in arr and compares the index returned
        a=BinarySearchSnippet.binarySearch(arr,0,arr.length-1,9);
        assertEquals(-1,a);  // It tests if 9 is present and gets -1 as return because 9 is not present in arr
        
       
    }

}
