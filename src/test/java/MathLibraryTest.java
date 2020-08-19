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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class MathLibraryTest {
  /**
   * Tests for {@link MathLibrary#factorial(int)}.
   */
  @Test
  void testFactorial() {
    assertEquals(1, MathLibrary.factorial(0));
    assertEquals(1, MathLibrary.factorial(1));
    assertEquals(2, MathLibrary.factorial(2));
    assertEquals(6, MathLibrary.factorial(3));
    assertEquals(24, MathLibrary.factorial(4));
    assertEquals(120, MathLibrary.factorial(5));
    assertEquals(720, MathLibrary.factorial(6));
    assertEquals(5040, MathLibrary.factorial(7));
    assertEquals(40320, MathLibrary.factorial(8));
    assertEquals(362880, MathLibrary.factorial(9));
    assertEquals(3628800, MathLibrary.factorial(10));
  }

  /**
   * Tests for {@link MathLibrary#fibonacci(int)}.
   */
  @Test
  void testFibonacci() {
    assertEquals(0, MathLibrary.fibonacci(0));
    assertEquals(1, MathLibrary.fibonacci(1));
    assertEquals(1, MathLibrary.fibonacci(2));
    assertEquals(2, MathLibrary.fibonacci(3));
    assertEquals(3, MathLibrary.fibonacci(4));
    assertEquals(5, MathLibrary.fibonacci(5));
    assertEquals(8, MathLibrary.fibonacci(6));
    assertEquals(13, MathLibrary.fibonacci(7));
    assertEquals(21, MathLibrary.fibonacci(8));
    assertEquals(34, MathLibrary.fibonacci(9));
    assertEquals(55, MathLibrary.fibonacci(10));
  }

  /**
   * Tests for {@link MathLibrary#performLottery(int, int)}.
   */
  @Test
  void testPerformLottery() {
    var numbers0 = MathLibrary.performLottery(0, 0);
    assertArrayEquals(new Integer[] {}, numbers0);
    var numbers1 = MathLibrary.performLottery(1, 1);
    assertArrayEquals(new Integer[] {1}, numbers1);
    var numbers2 = MathLibrary.performLottery(2, 2);
    assertEquals(2, numbers2.length);
    assertTrue(numbers2[0] == 1 || numbers2[0] == 2);
    assertTrue(numbers2[1] == 1 || numbers2[1] == 2);
  }

  /**
   * Tests for {@link MathLibrary#gcd(int, int)}.
   */
  @Test
  void testGcd() {
    assertEquals(2, MathLibrary.gcd(2, 4));
    assertEquals(1, MathLibrary.gcd(2, 5));
    assertEquals(6, MathLibrary.gcd(18, 24));
    assertEquals(7, MathLibrary.gcd(7, 7));
  }

  /**
   * Tests for {@link MathLibrary#isPrime(int)}.
   */
  @Test
  void testIsPrime() {
    assertTrue(MathLibrary.isPrime(2));
    assertTrue(MathLibrary.isPrime(3));
    assertTrue(MathLibrary.isPrime(17));
    assertTrue(MathLibrary.isPrime(97));
    assertFalse(MathLibrary.isPrime(4));
    assertFalse(MathLibrary.isPrime(100));
  }
}