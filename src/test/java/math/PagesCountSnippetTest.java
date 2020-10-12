package math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static math.PagesCountSnippet.pagesCount;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class PagesCountSnippetTest {

  /**
   * Tests for {@link PagesCountSnippet#pagesCount(int, int)} )}.
   */
  @Test
  void testPagesCount() {
    assertEquals(1, pagesCount(1, 1));
    assertEquals(10, pagesCount(10, 1));
    assertEquals(4, pagesCount(10, 3));
    assertEquals(5, pagesCount(10, 2));
    assertEquals(1, pagesCount(7, 10));
    assertEquals(Integer.MAX_VALUE, pagesCount(Integer.MAX_VALUE, 1));
    assertEquals(214748365, pagesCount(Integer.MAX_VALUE, 10));
    assertEquals(1, pagesCount(Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(3, pagesCount(Integer.MAX_VALUE, Integer.MAX_VALUE / 2));
    assertEquals(1, pagesCount(10, Integer.MAX_VALUE));
  }

  @Test
  void testPagesCountWhenPagesCountIsZero() {
    assertThrows(IllegalArgumentException.class, () -> pagesCount(10, 0));
  }

  @Test
  void testPagesCountWhenPagesCountIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> pagesCount(10, -10));
  }
}
