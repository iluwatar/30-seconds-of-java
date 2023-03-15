/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
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

public class BinarySearchSnippetTest {
  /**
   * Tests for {@link BinarySearchSnippet#binarySearch(int[], int, int, int)}.
   */    

  @Test
  void testBinarySearch() {
    int[] arr = new int[]{1, 5, 33, 40, 45, 51, 68, 75, 78, 123, 180, 256, 300, 312};
    assertEquals(4, BinarySearchSnippet.binarySearch(arr, 0, arr.length - 1, 45));

    int[] arr2 = new int[]{1, 1, 4, 4, 8, 8, 90, 100, 111, 550, 621};
    assertEquals(2, BinarySearchSnippet.binarySearch(arr2, 0, arr2.length - 1, 4));

    int[] arr3 = new int[]{4, 9, 14, 71, 330, 400, 411, 556};
    assertEquals(-1, BinarySearchSnippet.binarySearch(arr3, 0, arr3.length - 1, 6));
  }
}
