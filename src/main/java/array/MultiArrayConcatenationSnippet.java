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

package array;

import java.util.Arrays;

/**
 * ArrayConcatenationUtility.
 */
public class ArrayConcatenationUtility {

  /**
   * Concatenates multiple arrays into a single array.
   *
   * @param first the first array (not null)
   * @param rest  the rest of the arrays (optional)
   * @param <T>   the element type
   * @return concatenated array
   * @throws IllegalArgumentException if the first array or any array in rest is null
   */
  public static <T> T[] concatenateArrays(T[] first, T[]... rest) {
    if (first == null) {
      throw new IllegalArgumentException("First array cannot be null.");
    }

    int totalLength = first.length;
    for (T[] array : rest) {
      if (array == null) {
        throw new IllegalArgumentException("Array in rest cannot be null.");
      }
      totalLength += array.length;
    }

    T[] result = Arrays.copyOf(first, totalLength);
    int offset = first.length;
    for (T[] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }

    return result;
  }
}
