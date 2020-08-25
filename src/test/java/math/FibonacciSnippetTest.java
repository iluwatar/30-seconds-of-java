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
class FibonacciSnippetTest {
  /**
   * Tests for {@link FibonacciSnippet#fibonacci(int)}.
   */
  @Test
  void testFibonacci() {
    assertEquals(0, FibonacciSnippet.fibonacci(0));
    assertEquals(1, FibonacciSnippet.fibonacci(1));
    assertEquals(1, FibonacciSnippet.fibonacci(2));
    assertEquals(2, FibonacciSnippet.fibonacci(3));
    assertEquals(3, FibonacciSnippet.fibonacci(4));
    assertEquals(5, FibonacciSnippet.fibonacci(5));
    assertEquals(8, FibonacciSnippet.fibonacci(6));
    assertEquals(13, FibonacciSnippet.fibonacci(7));
    assertEquals(21, FibonacciSnippet.fibonacci(8));
    assertEquals(34, FibonacciSnippet.fibonacci(9));
    assertEquals(55, FibonacciSnippet.fibonacci(10));
  }
}