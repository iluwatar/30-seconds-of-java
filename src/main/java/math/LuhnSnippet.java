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

package math;

public class LuhnSnippet {

  /**
   * Calculates checksum for a given number with Luhn's algorithm. Works only on non-negative
   * integers not greater than {@link Long#MAX_VALUE} i.e., all numbers with a maximum of 18
   * digits, plus 19-digit-long numbers start with 1..8 (also some with 9, too). For
   * demonstration purposes, algorithm is not optimized for efficiency.
   *
   * @param num number whose checksum is to be calculated
   * @return checksum value for num
   * @see <a href="https://patents.google.com/patent/US2950048A">Hans P. LUHN's patent US2950048A</a>
   * @see <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm on Wikipedia</a>
   */
  public static int calculateLuhnChecksum(long num) {
    if (num < 0) {
      throw new IllegalArgumentException("Non-negative numbers only.");
    }
    final var numStr = String.valueOf(num);

    var sum = 0;
    var isOddPosition = true;
    // Loop on digits of numStr from right to left.
    for (var i = numStr.length() - 1; i >= 0; i--) {
      final var digit = Integer.parseInt(Character.toString(numStr.charAt(i)));
      final var substituteDigit = (isOddPosition ? 2 : 1) * digit;

      final var tensPlaceDigit = substituteDigit / 10;
      final var onesPlaceDigit = substituteDigit % 10;
      sum += tensPlaceDigit + onesPlaceDigit;

      isOddPosition = !isOddPosition;
    }
    final var checksumDigit = (10 - (sum % 10)) % 10;
    // Outermost modulus handles edge case `num = 0`.
    return checksumDigit;
  }

}
