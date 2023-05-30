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

/**
 * BinarySearchSnippet.
 */

public class BinarySearchSnippet {

  /**
   * Search an item with binarySearch algorithm.
   *
   * @param arr sorted array to search
   * @param item an item to search
   * @return if item is found, return the index position of the array item otherwise return -1
   */

  public static int binarySearch(int[] arr, int left, int right, int item) {
    while(right >= left) 
    {
      int mid = left + (right - left) / 2;
      if (arr[mid] == item) 
      {
        return mid;
      }

      else if (arr[mid] > item) 
      {
        right = mid-1;
      }
      else
      {
        left = mid+1;
      }
    }
    return -1;
  }
    
}
