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
 * DammSnippet.
 */
public class DammSnippet {

  /**
   * Return the check digit for a string using a traditional for loop.
   *
   * @param s     the string
   * @param table the operation table
   * @return the check digit
   */
  public static char calculateCheckDigitUsingForLoop(String s, int[][] table) {
    int i;
    int row = 0;
    for (i = 0; i < s.length(); i++) {
      row = table[row][s.charAt(i) - '0'];
    }

    return Character.forDigit(row, 10);
  }

  /**
   * Return the check digit for a string using a for enhanced loop.
   *
   * @param s     the string
   * @param table the operation table
   * @return the check digit
   */
  public static char calculateCheckDigitUsingEnhancedLoop(String s, int[][] table) {
    int row = 0;
    for (var c : s.toCharArray()) {
      row = table[row][c - '0'];
    }

    return Character.forDigit(row, 10);
  }

  /**
   * Return the check digit for a string using streams.
   *
   * @param s     the string
   * @param table the operation table
   * @return the check digit
   */
  public static char calculateCheckDigitUsingStream(String s, int[][] table) {
    int reduce = s.chars().reduce(0, (row, col) -> table[row][col - '0']);
    return Character.forDigit(reduce, 10);
  }

  /**
   * Check if a string is valid using a traditional for loop.
   *
   * @param s     the digit string to check
   * @param table the operation table
   * @return true if no errors are detected, false otherwise
   */
  public static boolean validateUsingForLoop(String s, int[][] table) {
    int row = 0;
    for (int i = 0; i < s.length(); i++) {
      row = table[row][s.charAt(i) - '0'];
    }
    return row == 0;
  }

  /**
   * Check if a string is valid using an enhanced for loop.
   *
   * @param s     the digit string to check
   * @param table the operation table
   * @return true if no errors are detected, false otherwise
   */
  public static boolean validateUsingEnhancedLoop(String s, int[][] table) {
    int row = 0;
    for (var c : s.toCharArray()) {
      row = table[row][c - '0'];
    }
    return row == 0;
  }

  /**
   * Check if a string is valid using streams.
   *
   * @param s     the digit string to check
   * @param table the operation table
   * @return true if no errors are detected, false otherwise
   */
  public static boolean validateUsingStream(String s, int[][] table) {
    return s.chars().reduce(0, (row, col) -> table[row][col - '0']) == 0;
  }

}
