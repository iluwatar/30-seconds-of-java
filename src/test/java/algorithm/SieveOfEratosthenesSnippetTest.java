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

package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */

class SieveOfEratosthenesSnippetTest {
  /**
   * Tests for {@link SieveOfEratosthenesSnippet (int)}.
   */  

  @Test
  void testSieveOfEratosthenes() {
    boolean[] arr = SieveOfEratosthenesSnippet.sieveOfEratosthenes(4);
    assertEquals(true, arr[0]);
    assertEquals(true, arr[1]);
    assertEquals(true, arr[2]);
    assertEquals(true, arr[3]);
    assertEquals(false, arr[4]);

    boolean[] arr2 = SieveOfEratosthenesSnippet.sieveOfEratosthenes(7);
    assertEquals(true, arr2[0]);
    assertEquals(true, arr2[1]);
    assertEquals(true, arr2[2]);
    assertEquals(true, arr2[3]);
    assertEquals(false, arr2[4]);
    assertEquals(true, arr2[5]);
    assertEquals(false, arr2[6]);
    assertEquals(true, arr2[7]);

    boolean[] arr3 = SieveOfEratosthenesSnippet.sieveOfEratosthenes(2);
    assertEquals(true, arr3[0]);
    assertEquals(true, arr3[1]);
    assertEquals(true, arr3[2]);
  }
}
