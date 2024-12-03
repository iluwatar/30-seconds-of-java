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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;





/**
 * Tests for {@link LuhnModnSnippet#generateCheckCharacter(String)} and
 * {@link LuhnModnSnippet#validateCheckCharacter(String)}.
 */
class LuhnModnSnippetTest {

  /**
   * Tests the full process of generating and validating a check character.
   */

  // Test 1: Valid input with generated check character
  @Test
  public void testGenerateCheckCharacterValidInput() {
    String input = "HELLO";
    char checkCharacter = LuhnModnSnippet.generateCheckCharacter(input);
    String fullInput = input + checkCharacter;
    assertTrue(LuhnModnSnippet.validateCheckCharacter(fullInput),
            "Validation should pass for the generated check character.");
  }

  // Test 2: Valid input with manually appended valid check character
  @Test
  public void testValidateCheckCharacterValidInput() {
    String input = "WORLD";
    char checkCharacter = 'A';
    String fullInput = input + checkCharacter;
    assertFalse(LuhnModnSnippet.validateCheckCharacter(fullInput),
            "Validation should fail for a mismatched check character.");
  }

  // Test 3: Input with numbers
  @Test
  public void testGenerateCheckCharacterWithNumbers() {
    String input = "12345";
    char checkCharacter = LuhnModnSnippet.generateCheckCharacter(input);
    String fullInput = input + checkCharacter;
    assertTrue(LuhnModnSnippet.validateCheckCharacter(fullInput),
            "Validation should pass for the generated check character.");
  }

  // Test 4: Input with mixed characters
  @Test
  public void testGenerateCheckCharacterWithMixedCharacters() {
    String input = "A1B2C3";
    char checkCharacter = LuhnModnSnippet.generateCheckCharacter(input);
    String fullInput = input + checkCharacter;
    assertTrue(LuhnModnSnippet.validateCheckCharacter(fullInput),
            "Validation should pass for the generated check character.");
  }

  // Test 5: Empty string input for generateCheckCharacter
  @Test
  public void testEmptyInput() {
    String input = "";
    assertThrows(IllegalArgumentException.class, () ->
                    LuhnModnSnippet.generateCheckCharacter(input),
            "Exception should be thrown for empty input.");

    assertThrows(IllegalArgumentException.class, () ->
                    LuhnModnSnippet.validateCheckCharacter(input),
            "Exception should be thrown for empty input.");
  }

}
