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

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;






/**
 * Tests for {@link LuhnModnSnippet#generateCheckCharacter(String)} and
 * {@link LuhnModnSnippet#validateCheckCharacter(String)}.
 */
class LuhnModnSnippetTest {


  /**
   * Tests the full process of generating and validating a check character.
   */


  @ParameterizedTest
  @MethodSource("validInputProvider")
  public void testGenerateCheckCharacter(String input) {
    char checkCharacter = LuhnModnSnippet.generateCheckCharacter(input);
    String fullInput = input + checkCharacter;
    assertTrue(LuhnModnSnippet.validateCheckCharacter(fullInput),
            "Validation should pass for the generated check character.");
  }


  @ParameterizedTest
  @MethodSource("invalidInputProvider")
  public void testInvalidInputs(String input, Character checkCharacter, boolean throwException) {
    if (throwException) {
      assertThrows(IllegalArgumentException.class, () ->
                      LuhnModnSnippet.generateCheckCharacter(input),
              "Exception should be thrown for invalid input.");
      assertThrows(IllegalArgumentException.class, () ->
                      LuhnModnSnippet.validateCheckCharacter(input),
              "Exception should be thrown for invalid input.");
    } else {
      String fullInput = input + checkCharacter;
      assertFalse(LuhnModnSnippet.validateCheckCharacter(fullInput),
              "Validation should fail for a mismatched check character.");
    }
  }


  private static Stream<String> validInputProvider() {
    return Stream.of(
            "HELLO",
            "12345",
            "A1B2C3"
    );
  }


  private static Stream<Arguments> invalidInputProvider() {
    return Stream.of(
            Arguments.of("", null, true),
            Arguments.of("WORLD", 'A', false)
    );
  }
}
