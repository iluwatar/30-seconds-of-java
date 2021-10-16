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
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NaturalNumberBinaryConversionSnippetTest {

  @Test
  void convertPositiveIntegerToBinary() {
    assertEquals("0", NaturalNumberBinaryConversionSnippet.toBinary(0));
    assertEquals("11", NaturalNumberBinaryConversionSnippet.toBinary(3));
    assertEquals("101",NaturalNumberBinaryConversionSnippet.toBinary(5));
    assertEquals("10000000000",NaturalNumberBinaryConversionSnippet.toBinary(0b10000000000));
    assertEquals("10000000000",NaturalNumberBinaryConversionSnippet.toBinary(1024));
    assertEquals("11111111",NaturalNumberBinaryConversionSnippet.toBinary(0xFF));
    assertEquals("110110",NaturalNumberBinaryConversionSnippet.toBinary(066));
  }

  @Test
  void negativeIntegerToBinaryConversionThrowsException() {
    assertThrows(NumberFormatException.class,
        () -> NaturalNumberBinaryConversionSnippet.toBinary(-3));
  }

  @Test
  void convertBinaryStringToInteger() {
    assertEquals(3, NaturalNumberBinaryConversionSnippet.fromBinary("11"));
    assertEquals(6,NaturalNumberBinaryConversionSnippet.fromBinary("110"));
    assertEquals(0x5c,NaturalNumberBinaryConversionSnippet.fromBinary("01011100"));
    assertEquals(127,NaturalNumberBinaryConversionSnippet.fromBinary("1111111"));
  }

  @Test
  void invalidBinaryStringToIntegerConversionThrowsException() {
    assertThrows(NumberFormatException.class,
        () -> NaturalNumberBinaryConversionSnippet.fromBinary("12"));
  }

}
