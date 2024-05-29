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
 * BinarySearchIn2dArraySnippet.
 */
public class BinarySearchIn2dArraySnippet {

  /**
  * Search an item with binarySearch algorithm.
  *
  * @param matrix should be sorted
  * @param target an item to search
  * @return if location of item is found, otherwise return {-1,-1}
  */
  public static int[] binarySearchIn2darr(int[][] matrix, int target) {
    int rows = matrix.length - 1;
    int cols = matrix[0].length - 1;

    if (rows == 1) {
      return binarySearch(matrix, target, 0, 0, cols);
    }

    int rstart = 0;
    int rend = rows;
    int cmid = cols / 2;

    while (rstart < rend - 1) {
      int rmid = rstart + (rend - rstart) / 2;
      if (matrix[rmid][cmid] > target) {
        rend = rmid;
      } else if (matrix[rmid][cmid] < target) {
        rstart = rmid;
      } else {
        return new int[]{rmid, cmid};
      }
    }
    if (matrix[rstart][cmid] == target) {
      return new int[]{rstart, cmid};
    }
    if (matrix[rend][cmid] == target) {
      return new int[]{rend, cmid};
    }
    if (target <= matrix[rstart][cmid - 1]) {
      return binarySearch(matrix, target, rstart, 0, cmid - 1);
    }
    if (target >= matrix[rstart][cmid + 1]) {
      return binarySearch(matrix, target, rstart, cmid + 1, cols);
    }
    if (target <= matrix[rend][cmid - 1]) {
      return binarySearch(matrix, target, rend, 0, cmid - 1);
    }
    if (target <= matrix[rend][cmid + 1]) {
      return binarySearch(matrix, target, rend, cmid + 1, cols);
    }
    return new int[]{-1, -1};
  }

  static int[] binarySearch(int[][] matrix, int target, int row, int cstart, int cend) {
    while (cstart <= cend) {
      int cmid = cstart + (cend - cstart) / 2;
      if (matrix[row][cmid] > target) {
        cend = cmid - 1;
      } else if (matrix[row][cmid] < target) {
        cstart = cend + 1;
      } else {
        return new int[]{row, cmid};
      }
    }
    return new int[]{-1, -1};
  }
}
