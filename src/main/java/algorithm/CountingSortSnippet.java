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

import java.util.Arrays;

/*
 * 30 Seconds of Java code library
 *
 */
public class CountingSortSnippet {

  /**
   * Sort an array having zero or positive numbers with countingSort algorithm.
   *
   * @param arr array to sort
   */
  public static void countingSort(int[] arr) {
    var max = Arrays.stream(arr).max().getAsInt();

    var count = new int[max + 1];

    for (var num : arr) {
      count[num]++;
    }

    for (var i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    var sorted = new int[arr.length];
    for (var i = arr.length - 1; i >= 0; i--) {
      var cur = arr[i];
      sorted[count[cur] - 1] = cur;
      count[cur]--;
    }

    var index = 0;
    for (var num : sorted) {
      arr[index++] = num;
    }
  }
}
