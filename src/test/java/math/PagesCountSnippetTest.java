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

import static math.PagesCountSnippet.pagesCount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

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
