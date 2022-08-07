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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LuhnSnippetTest {

  @CsvSource({
          "0, 0",
          "1, 8",
          "4, 2",
          "5, 9",
          "9, 1",

          "42, 2",

          // Moderately interesting patterns.
          "10, 9",
          "11, 7",
          "12, 5",
          "100, 8",
          "101, 6",
          "102, 4",
          "1000, 9",
          "1001, 7",
          "1002, 5",
          "10000, 8",
          "10001, 6",
          "10002, 4", // etc.

          // Can detect any single-digit error.
          "4872148, 4", // Original number (Luhn's example in patent US2950048A).
          "4872143, 5",
          //     ^
          "4872178, 1",
          //    ^

          // Can detect many transposition of adjacent digits.
          "4872418, 1",
          //   ^^
          "4872184, 9",
          //    ^^

          // Can not detect some transposition of adjacent digits.
          "109223344, 2", // Original number.
          "190223344, 2", // 09<-->90
          //^^
          "109553344, 2", // 22<-->55
          //  ^^
          "109226644, 2", // 33<-->66
          //    ^^
          "109223377, 2", // 44<-->77
          //      ^^
          "190226644, 2", // Some of the above together.
          //^^  ^^
          "190556677, 2", // All of the above together.
          //^^^^^^^^
  })
  @ParameterizedTest
  void testLuhnCalculateChecksum(long num, int expectedChecksum) {
    assertEquals(expectedChecksum, LuhnSnippet.calculateLuhnChecksum(num));
  }

}