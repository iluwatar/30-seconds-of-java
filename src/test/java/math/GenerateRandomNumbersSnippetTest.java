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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class GenerateRandomNumbersSnippetTest {
  /**
   * Tests for {@link GenerateRandomNumbersSnippet#generateRandomNumberBetween(int, int)}.
   */
  @CsvSource({
      "-2147483648, -2147483648",
      "-2147483648, -2",
      "-100, 100",
      "0, 0",
      "3, 10",
      "1, 2147483647",
      "2147483647, 2147483647"
  })
  @ParameterizedTest
  void testGenerateRandomNumberBetween(int min, int max) {
    var randomInteger = GenerateRandomNumbersSnippet.generateRandomNumberBetween(min, max);
    assertTrue(randomInteger >= min && randomInteger <= max);
  }

  @Test
  void checkThatAllNumbersInTheSpecifiedRangeHaveBeenGenerated() {
    List<Integer> listOfResults = new ArrayList<Integer>();
    for (int i = 0; i < 200; i++) {
      listOfResults.add(GenerateRandomNumbersSnippet.generateRandomNumberBetween(1, 10));
    }
    List<Integer> listOfDistinctResults =
        listOfResults.stream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());

    List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    assertEquals(listOfDistinctResults, expectedResult);
  }

  /**
   * Tests for {@link GenerateRandomNumbersSnippet#throwDice(int, int)}.
   */
  @CsvSource({
      "1, 6",
      "2, 6",
      "3, 6",
      "1, 10",
      "2, 10",
      "10, 6",
      "10, 10",
      "20, 5"
  })
  @ParameterizedTest
  void testThrowDice(int numberOfDice, int typeOfDice) {
    var number = GenerateRandomNumbersSnippet.throwDice(numberOfDice, typeOfDice);
    assertTrue(number >= numberOfDice && number <= typeOfDice * numberOfDice);
  }
}
