package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DammSnippetTest {

  @Test
  void test() {
    int[][] table = new int[][]{
        {0, 3, 1, 7, 5, 9, 8, 6, 4, 2},
        {7, 0, 9, 2, 1, 5, 4, 8, 6, 3},
        {4, 2, 0, 6, 8, 7, 1, 3, 5, 9},
        {1, 7, 5, 0, 9, 8, 3, 4, 2, 6},
        {6, 1, 2, 3, 0, 4, 5, 9, 7, 8},
        {3, 6, 7, 4, 2, 0, 9, 5, 8, 1},
        {5, 8, 6, 9, 7, 2, 0, 1, 3, 4},
        {8, 9, 4, 5, 3, 6, 2, 0, 1, 7},
        {9, 4, 3, 8, 6, 1, 7, 2, 0, 5},
        {2, 5, 8, 1, 4, 3, 6, 7, 9, 0}
    };

    assertEquals('4', DammSnippet.calculateCheckDigitUsingForLoop("572", table));
    assertEquals('4', DammSnippet.calculateCheckDigitUsingEnhancedLoop("572", table));
    assertEquals('4', DammSnippet.calculateCheckDigitUsingStream("572", table));

    assertTrue(DammSnippet.validateUsingForLoop("5724", table));
    assertTrue(DammSnippet.validateUsingEnhancedLoop("5724", table));
    assertTrue(DammSnippet.validateUsingStream("5724", table));

    assertFalse(DammSnippet.validateUsingForLoop("5725", table));
    assertFalse(DammSnippet.validateUsingEnhancedLoop("5725", table));
    assertFalse(DammSnippet.validateUsingStream("5725", table));
  }

}

