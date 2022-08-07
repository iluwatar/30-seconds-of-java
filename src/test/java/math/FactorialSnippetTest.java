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

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class FactorialSnippetTest {
  /**
   * Tests for {@link FactorialSnippet#factorial(int)}.
   */
  @Test
  void testFactorial() {
    assertEquals(1, FactorialSnippet.factorial(0));
    assertEquals(1, FactorialSnippet.factorial(1));
    assertEquals(2, FactorialSnippet.factorial(2));
    assertEquals(6, FactorialSnippet.factorial(3));
    assertEquals(24, FactorialSnippet.factorial(4));
    assertEquals(120, FactorialSnippet.factorial(5));
    assertEquals(720, FactorialSnippet.factorial(6));
    assertEquals(5040, FactorialSnippet.factorial(7));
    assertEquals(40320, FactorialSnippet.factorial(8));
    assertEquals(362880, FactorialSnippet.factorial(9));
    assertEquals(3628800, FactorialSnippet.factorial(10));
  }
}