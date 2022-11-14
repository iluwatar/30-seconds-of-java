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

package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for 30 Seconds of Java code library.
 */
public class ArrayMedianSnippetTest {

  /**
   * Tests for {@link ArrayMedianSnippet#arrayMedian(int[])}.
   */
  @Test
  void testArrayMedian() {
    assertEquals(11, ArrayMedianSnippet.arrayMedian(new int[]{4, 17, 2, 11, 29}));
    assertEquals(4.5, ArrayMedianSnippet.arrayMedian(new int[]{9, 1, 11, 5, 3, 4}));
    assertEquals(-11, ArrayMedianSnippet.arrayMedian(new int[]{-3, -1, -100, -11, -29}));
    assertEquals(-11.5, ArrayMedianSnippet.arrayMedian(new int[]{1, -29, -14, -20, -9, -2}));
  }
}
