/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
* Tests for 30 Seconds of Java code library.
*/
class RandomNumberTest {

  /**
  * Tests for {@link RandomNumber #getRandomNumber(T, T)}.
  */
  @RepeatedTest(100)
  void testGetRandomNumber() {
    // Test for Short range
    Number shortResult = RandomNumber.getRandomNumber(
            (short) 2, (short) 7);
    assertTrue(shortResult instanceof Short);
    assertTrue((shortResult.shortValue() >= 2) && (shortResult.shortValue() <= 7));
    // Test for Integer range
    Number intResult = RandomNumber.getRandomNumber(5, 10);
    assertTrue(intResult instanceof Integer);
    assertTrue((intResult.intValue() >= 5) && (intResult.intValue() <= 10));
    // Test for Long range
    Number longResult = RandomNumber.getRandomNumber(
            (long) -100, (long) 2500);
    assertTrue(longResult instanceof Long);
    assertTrue((longResult.longValue() >= -100) && (longResult.longValue() <= 2500));
    // Test for Float range
    Number floatResult = RandomNumber.getRandomNumber(
            (float) 2.5f, (float) 25.4f);
    assertTrue(floatResult instanceof Float);
    assertTrue((floatResult.floatValue() >= 2.5f) && (floatResult.floatValue() <= 25.4f));
    // Test for Double range
    Number doubleResult = RandomNumber.getRandomNumber(
            (double) 100.12, (double) 200.28);
    assertTrue(doubleResult instanceof Double);
    assertTrue((doubleResult.doubleValue() >= 100.12) && (doubleResult.doubleValue() <= 200.28));
    // Test for Double range
    double d1 = (double) 100.12;
    int d2 = (int) 200;
    assertThrows(IllegalArgumentException.class, 
        () -> RandomNumber.getRandomNumber(d1, d2));
  }
}