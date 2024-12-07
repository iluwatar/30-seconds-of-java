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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link DammSnippet} class.
 */
class DammSnippetTest {

  /**
   * Test for calculating the checksum digit with valid input.
   */
  @Test
  void testCalculateCheckSumDigit() {
    String number = "572";
    int checkSumDigit = DammSnippet.calculateCheckSumDigit(number);
    assertEquals(4, checkSumDigit);
  }

  /**
   * Test for generating the full number with checksum.
   */
  @Test
  void testGenerateCheckSum() {
    String number = "572";
    String fullNumber = DammSnippet.generateCheckSum(number);
    assertEquals("5724", fullNumber);
  }

  /**
   * Test for validating a number with a valid checksum.
   */
  @Test
  void testValidateWithValidNumber() {
    String fullNumber = "5724";
    boolean isValid = DammSnippet.validate(fullNumber);
    assertTrue(isValid);
  }

  /**
   * Test for validating an invalid number.
   */
  @Test
  void testValidateWithInvalidNumber() {
    String invalidNumber = "5723";
    boolean isValid = DammSnippet.validate(invalidNumber);
    assertFalse(isValid);
  }

  /**
   * Test for handling invalid input in checksum calculation.
   */
  @Test
  void testCalculateCheckSumDigitWithInvalidInput() {
    assertThrows(IllegalArgumentException.class, () -> DammSnippet.calculateCheckSumDigit(""));
    assertThrows(IllegalArgumentException.class, () -> DammSnippet.calculateCheckSumDigit("12a4"));
  }

  /**
   * Test for generating checksum with an integer input.
   */
  @Test
  void testGenerateCheckSumWithInt() {
    int number = 572;
    int fullNumberWithChecksum = DammSnippet.generateCheckSum(number);
    assertEquals(5724, fullNumberWithChecksum);
  }

  /**
   * Test for validation using integer input.
   */
  @Test
  void testValidateWithInt() {
    int fullNumber = 5724;
    boolean isValid = DammSnippet.validate(fullNumber);
    assertTrue(isValid);

    int invalidNumber = 5723;
    boolean isValidInvalid = DammSnippet.validate(invalidNumber);
    assertFalse(isValidInvalid);
  }

  /**
   * Test for validating a long number with checksum.
   */
  @Test
  void testValidateWithLong() {
    long fullNumber = 5724L;
    boolean isValid = DammSnippet.validate(fullNumber);
    assertTrue(isValid);

    long invalidNumber = 5723L;
    boolean isValidInvalid = DammSnippet.validate(invalidNumber);
    assertFalse(isValidInvalid);
  }
}