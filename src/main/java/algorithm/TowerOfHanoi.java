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
 * TowerOfHanoiSnippet.
 */
public class TowerOfHanoiSnippet {

  /**
   * Solve Tower of Hanoi puzzle.
   *
   * @param n the number of disks
   * @param fromRod the source rod
   * @param toRod the destination rod
   * @param auxRod the auxiliary rod
   */
  public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
    if (n == 0) {
      return;
    }
    towerOfHanoi(n - 1, fromRod, auxRod, toRod);
    System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
    towerOfHanoi(n - 1, auxRod, toRod, fromRod);
  }

  /**
   * Driver code to test the Tower of Hanoi.
   */
  public static void main(String[] args) {
    int N = 3;
    // A, B, and C are the names of rods
    towerOfHanoi(N, 'A', 'C', 'B');
  }
}
