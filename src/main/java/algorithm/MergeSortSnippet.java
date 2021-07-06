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

/*
 * 30 Seconds of Java code library
 *
 */
public class MergeSortSnippet {
  /**
   * Sort an array with mergeSort algorithm.
   *
   * @param arr   array to sort
   * @param left  left index where to begin sort (e.g. 0)
   * @param right right index where to end sort (e.g. array length - 1)
   */
  public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    var pivotIndex = (left + right) / 2;

    mergeSort(arr, left, pivotIndex);
    mergeSort(arr, pivotIndex + 1, right);

    var leftArrLength = pivotIndex - left + 1;
    var rightArrLength = right - pivotIndex;

    var leftArr = new int[leftArrLength];
    var rightArr = new int[rightArrLength];

    for (var i = 0; i < leftArrLength; i++) {
      leftArr[i] = arr[left + i];
    }

    for (var j = 0; j < rightArrLength; j++) {
      rightArr[j] = arr[pivotIndex + j + 1];
    }

    var i = 0;
    var j = 0;
    var k = left;

    while (i < leftArrLength && j < rightArrLength) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }

    while (i < leftArrLength) {
      arr[k++] = leftArr[i++];
    }

    while (j < rightArrLength) {
      arr[k++] = rightArr[j++];
    }
  }
}
