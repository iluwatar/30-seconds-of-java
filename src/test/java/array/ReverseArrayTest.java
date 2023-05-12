/*
 * MIT License
 *
 * Copyright (c) 2017-2023 Ilkka Seppälä
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

package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


/**
 * Tests for {@link ReverseArraySnippet#reverseArray(Object[], int, int)}}.
 */

class ReverseArrayTest {


  /** reverseArray should correctly reverse the entire array. **/

  @Test
  void testReverseArrayFull() {
    Integer[] arr = {1, 2, 3, 4, 5};
    Integer[] result = ReverseArraySnippet.reverseArray(arr, 0, arr.length - 1);
    Integer[] expected = {5, 4, 3, 2, 1};
    assertArrayEquals(expected, result);
  }

  /** reverseArray should correctly reverse a subset of the array. **/

  @Test
  void testReverseArrayPartial() {
    String[] arr = {"Ali", "Shabnam", "Reza", "Fatemeh"};
    String[] result = ReverseArraySnippet.reverseArray(arr, 1, 2);
    String[] expected = {"Ali", "Reza", "Shabnam", "Fatemeh"};
    assertArrayEquals(expected, result);
  }

  /** reverseArray should correctly reverse a subset of the array with decimal values. **/

  @Test
  void testReverseArrayDecimal() {
    Double[] arr = {5.5, 4.4, 3.3, 2.2, 1.1};
    Double[] result = ReverseArraySnippet.reverseArray(arr, 2, 4);
    Double[] expected = {5.5, 4.4, 1.1, 2.2, 3.3};
    assertArrayEquals(expected, result);
  }

  /** reverseArray should correctly handle a single element array. **/

  @Test
  void testReverseArraySingleElement() {
    Integer[] arr = {1};
    Integer[] result = ReverseArraySnippet.reverseArray(arr, 0, arr.length - 1);
    Integer[] expected = {1};
    assertArrayEquals(expected, result);
  }

  /** reverseArray should correctly handle an empty array. **/

  @Test
  void testReverseArrayEmpty() {
    Integer[] arr = new Integer[0];
    Integer[] result = ReverseArraySnippet.reverseArray(arr, 0, 0);
    Integer[] expected = new Integer[0];
    assertArrayEquals(expected, result);
  }

  /** reverseArray when start and end are equal. **/

  @Test
  void testReverseArrayNoChange() {
    Integer[] array = {1, 2, 3, 4, 5};
    int start = 2;
    int end = 2;
    Integer[] reversedArray = ReverseArraySnippet.reverseArray(array, start, end);
    assertArrayEquals(array, reversedArray);
  }

  /** reverseArray should throw ArrayIndexOutOfBoundsException if startIndex is less than 0. **/

  @Test
  void testReverseArrayNegativeStartIndex() {
    Integer[] arr = {1, 2, 3, 4, 5};
    assertThrows(ArrayIndexOutOfBoundsException.class, () ->
            ReverseArraySnippet.reverseArray(arr, -1, 3));
  }

  /** reverseArray should throw ArrayIndexOutOfBoundsException if endIndex
  *  is greater than the array size minus 1. **/

  @Test
  void testReverseArrayEndIndexOutOfBounds() {
    Integer[] arr = {1, 2, 3, 4, 5};
    assertThrows(ArrayIndexOutOfBoundsException.class,
            () -> ReverseArraySnippet.reverseArray(arr, 2, 5));
  }

  /** reverseArray should throw ArrayIndexOutOfBoundsException
  * if startIndex is greater than endIndex. **/

  @Test
  void testReverseArrayInvalidIndexes() {
    Integer[] arr = {1, 2, 3, 4, 5};
    assertThrows(IllegalArgumentException.class, () -> ReverseArraySnippet.reverseArray(arr, 3, 2));
  }

  /** reverseArray should throw IllegalArgumentException if the input array is null. */

  @Test
  void  testReverseArrayNullInput() {
    assertThrows(IllegalArgumentException.class, () ->
            ReverseArraySnippet.reverseArray(null, 0, 2));
  }

}
