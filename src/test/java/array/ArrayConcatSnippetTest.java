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
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class ArrayConcatSnippetTest {
  /**
   * Tests for {@link ArrayConcatSnippet#arrayConcat(Object[], Object[])}.
   */
  @Test
  void testArrayConcat() {
    var integers = ArrayConcatSnippet.arrayConcat(new Integer[5], new Integer[5]);
    assertEquals(integers.length, 10);
    var strings = ArrayConcatSnippet.arrayConcat(new String[0], new String[0]);
    assertEquals(strings.length, 0);
    assertThrows(NullPointerException.class, () -> ArrayConcatSnippet.arrayConcat(null, null));
  }
}