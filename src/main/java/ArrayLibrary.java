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

import java.util.Arrays;

public class ArrayLibrary {
  /**
   * Generic 2 array concatenation Credits: Joachim Sauer https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
   *
   * @param first  is the first array (not null)
   * @param second is the second array (not null)
   * @param <T>    the element type
   * @return concatenated array
   */
  public static <T> T[] arrayConcat(T[] first, T[] second) {
    var result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }

  /**
   * Generic N array concatenation Credits: Joachim Sauer https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
   *
   * @param first is the first array (not null)
   * @param rest  the rest of the arrays (optional)
   * @param <T>   the element type
   * @return concatenated array
   */
  public static <T> T[] multiArrayConcat(T[] first, T[]... rest) {
    var totalLength = first.length;
    for (var array : rest) {
      totalLength += array.length;
    }
    var result = Arrays.copyOf(first, totalLength);
    var offset = first.length;
    for (var array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  /**
   * Returns true if all elements in array are equal.
   *
   * @param arr the array to check (not null)
   * @param <T> the element type
   * @return true if all elements in the array are equal
   */
  public static <T> boolean allEqual(T[] arr) {
    return Arrays.stream(arr).distinct().count() == 1;
  }

  /**
   * Returns the maximum integer from the array using reduction.
   * @param arr the array of integers (not null)
   * @return the maximum element from the array
   */
  public static int findMax(int[] arr) {
    return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
  }
}
