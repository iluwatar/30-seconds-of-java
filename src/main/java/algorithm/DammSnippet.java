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
 * The implementation of the Damm algorithm based on the details on
 * <a href="https://en.wikipedia.org/wiki/Damm_algorithm">Wikipedia</a>.
 *
 * <p>The Damm algorithm is used for error detection and generates a checksum
 * that can detect single-digit errors and adjacent transposition errors.</p>
 *
 */
public class DammSnippet {

  /**
   * Private constructor to prevent instantiation of utility class.
   */
  private DammSnippet() {
    throw new UnsupportedOperationException("Utility class - instantiation is not allowed.");
  }

  /**
   * The quasigroup table used by the Damm algorithm.
   */
  private static final int[][] matrix = new int[][] {
          { 0, 3, 1, 7, 5, 9, 8, 6, 4, 2 },
          { 7, 0, 9, 2, 1, 5, 4, 8, 6, 3 },
          { 4, 2, 0, 6, 8, 7, 1, 3, 5, 9 },
          { 1, 7, 5, 0, 9, 8, 3, 4, 2, 6 },
          { 6, 1, 2, 3, 0, 4, 5, 9, 7, 8 },
          { 3, 6, 7, 4, 2, 0, 9, 5, 8, 1 },
          { 5, 8, 6, 9, 7, 2, 0, 1, 3, 4 },
          { 8, 9, 4, 5, 3, 6, 2, 0, 1, 7 },
          { 9, 4, 3, 8, 6, 1, 7, 2, 0, 5 },
          { 2, 5, 8, 1, 4, 3, 6, 7, 9, 0 }
  };

  /**
   * Calculates the Damm checksum digit for the given number.
   *
   * @param number the input number as a string
   * @return the calculated checksum digit
   * @throws IllegalArgumentException if the input is null, empty, or contains non-digit characters
   */
  public static int calculateCheckSumDigit(String number) {
    if (number == null || number.isEmpty()) {
      throw new IllegalArgumentException("Input number cannot be null or empty.");
    }

    int interim = 0;
    for (int index = 0; index < number.length(); index++) {
      char currCh = number.charAt(index);
      if (!Character.isDigit(currCh)) {
        throw new IllegalArgumentException("Input number contains invalid characters: " + number);
      }

      int currentIndex = currCh - '0';
      interim = matrix[interim][currentIndex];
    }

    return interim;
  }

  /**
   * Calculates the Damm checksum digit for the given number.
   *
   * @param number the input number as an integer
   * @return the calculated checksum digit
   */
  public static int calculateCheckSumDigit(int number) {
    return calculateCheckSumDigit(String.valueOf(number));
  }

  /**
   * Calculates the Damm checksum digit for the given number.
   *
   * @param number the input number as a long
   * @return the calculated checksum digit
   */
  public static int calculateCheckSumDigit(long number) {
    return calculateCheckSumDigit(String.valueOf(number));
  }

  /**
   * Appends the calculated checksum digit to the given number as a string.
   *
   * @param number the input number as a string
   * @return the original number with the checksum digit appended
   * @throws IllegalArgumentException if the input is null, empty, or contains non-digit characters
   */
  public static String generateCheckSum(String number) {
    int checkSumDigit = calculateCheckSumDigit(number);
    return number + checkSumDigit;
  }

  /**
   * Appends the calculated checksum digit to the given number as an integer.
   *
   * @param number the input number as an integer
   * @return the original number with the checksum digit appended
   */
  public static int generateCheckSum(int number) {
    int checkSumDigit = calculateCheckSumDigit(number);
    return (number * 10) + checkSumDigit;
  }

  /**
   * Appends the calculated checksum digit to the given number as a long.
   *
   * @param number the input number as a long
   * @return the original number with the checksum digit appended
   */
  public static long generateCheckSum(long number) {
    int checkSumNumber = calculateCheckSumDigit(number);
    return (number * 10) + checkSumNumber;
  }

  /**
   * Validates the given number by checking if the checksum digit is correct.
   *
   * @param number the input number as a string
   * @return {@code true} if the number is valid, {@code false} otherwise
   * @throws IllegalArgumentException if the input is null, empty, or contains non-digit characters
   */
  public static boolean validate(String number) {
    return calculateCheckSumDigit(number) == 0;
  }

  /**
   * Validates the given number by checking if the checksum digit is correct.
   *
   * @param number the input number as an integer
   * @return {@code true} if the number is valid, {@code false} otherwise
   */
  public static boolean validate(int number) {
    return calculateCheckSumDigit(number) == 0;
  }

  /**
   * Validates the given number by checking if the checksum digit is correct.
   *
   * @param number the input number as a long
   * @return {@code true} if the number is valid, {@code false} otherwise
   */
  public static boolean validate(long number) {
    return calculateCheckSumDigit(number) == 0;
  }
}