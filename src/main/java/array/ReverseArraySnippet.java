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

/**
 * ReverseArraySnippet.
 */
public class ReverseArraySnippet {

  /**
   * The function then reverses the elements of the array between the starting and ending
   * indices using a while loop and a temporary variable `temp`. Finally, the function returns
   * the reversed array.
   *
   * @param array a array
   * @param start start index array
   * @param end end index array
   * @return reverses elements in the array
   * @throws IllegalArgumentException if the [start] index is greater
   *         than the [end] index or if the array is null
   **/
  public static <T> T[] reverseArray(T[] array, int start, int end) {
    if (start > end || array == null) {
      throw new
              IllegalArgumentException("Invalid argument!");
    }
    int minimumSizeArrayForReversal = 2;
    if (start == end || array.length < minimumSizeArrayForReversal) {
      return array;
    }
    while (start < end) {
      T temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
    return array;
  }
}
