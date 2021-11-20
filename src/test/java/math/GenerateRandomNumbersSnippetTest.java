package math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    assertTrue(listOfDistinctResults.size() == 10 && listOfDistinctResults.get(0) == 1);
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
