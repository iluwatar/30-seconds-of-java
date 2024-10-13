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

package math;

/**
 * SquareRoot.
 */
public class SquareRoot {

  /**
   * Returns square root of a number.
   *
   * @param num To find SquareRoot
   * @param p   precision till how many decimal numbers we want accurate ans
   */
  public static double sqrt(int num, int p) {
    int start = 0;
    int end = num;
    double root = 0.0;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if ((mid * mid) > num) {
        end = mid - 1;
      } else if ((mid * mid) < num) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    double incr = 0.1;
    for (int i = 0; i < p; i++) {
      while (root * root < num) {
        root = root + incr;
      }
      root = root - incr;
      incr = incr / 10;
    }
    return root;
  }
}
