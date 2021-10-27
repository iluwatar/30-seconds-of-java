package math;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class GenerateRandomNumbersSnippetTest {
    /**
     * Tests for {@link GenerateRandomNumbersSnippet#generateRandomNumberBetweenXAndY(int, int)}.
     */
    @Test
    void testGenerateRandomNumberBetweenXAndY() {
        var randomInteger0 = GenerateRandomNumbersSnippet.generateRandomNumberBetweenXAndY(0, 0);
        assertEquals(0, randomInteger0);

        var randomInteger1 = GenerateRandomNumbersSnippet.generateRandomNumberBetweenXAndY(3, 10);
        var listOfPossibleResults1 = List.of(3, 4, 5, 6, 7, 8, 9, 10);
        assertTrue(listOfPossibleResults1.contains(randomInteger1));

        var randomInteger2 = GenerateRandomNumbersSnippet.generateRandomNumberBetweenXAndY(42, 43);
        var listOfPossibleResults2 = List.of(42, 43);
        assertTrue(listOfPossibleResults2.contains(randomInteger2));
    }

    /**
     * Tests for {@link GenerateRandomNumbersSnippet#throwDice()}.
     */
    @Test
    void testThrowDice() {
        var number = GenerateRandomNumbersSnippet.throwDice();
        var listOfPossibleResults = List.of(1, 2, 3, 4, 5, 6);
        assertTrue(listOfPossibleResults.contains(number));
    }
}
