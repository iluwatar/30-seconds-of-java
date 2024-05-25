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
 * ArrayModeSnippet.
 */
public class ArrayModeInPlaceSnippet {

  /**
  * Returns the mode of the array.
  *
  * @param arr array to find mode in it
  * @return mode of array
  */
  public static int modeArrayInPlace(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    Arrays.sort(arr);

    int mode = arr[0];
    int maxcount = 1;
    int count = 1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        count++;
      } else {
        if (count > maxcount) {
          maxcount = count;
          mode = arr[i - 1];
        }
        count = 1;
      }
    }
    if (count > maxcount) {
      mode = arr[arr.length - 1];
    }
    return mode;
  }
}
