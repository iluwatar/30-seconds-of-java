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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class AllEqualSnippetTest {
  /**
   * Tests for {@link AllEqualSnippet#allEqual(Object[])}.
   */
  @Test
  void testAllEqual() {
    var intArray = new Integer[5];
    assertTrue(AllEqualSnippet.allEqual(intArray));
    intArray[0] = 1;
    assertFalse(AllEqualSnippet.allEqual(intArray));
    var stringArray = new String[10];
    Arrays.fill(stringArray, "Hello World");
    assertTrue(AllEqualSnippet.allEqual(stringArray));
    stringArray[3] = "Bye World";
    assertFalse(AllEqualSnippet.allEqual(stringArray));
    var doubleArray = new Double[1];
    assertTrue(AllEqualSnippet.allEqual(doubleArray));
    assertThrows(NullPointerException.class, () -> AllEqualSnippet.allEqual(null));
  }
}