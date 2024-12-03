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


/**
 * LuhnModnSnippet.
 */
public class LuhnModnSnippet {


  private LuhnModnSnippet() {
    throw new IllegalStateException("LuhnModnSnippet class");
  }


  private static final String CODE_POINTS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";


  /**
   * Generates a check character using the Luhn mod N algorithm.
   *
   * @param character the input string consisting of valid alphanumeric characters
   * @return the generated check character
   * @throws IllegalArgumentException if the input contains invalid characters
   */
  public static int codePointFromCharacter(char character) {
    int index = CODE_POINTS.indexOf(character);
    if (index == -1) {
      throw new IllegalArgumentException("Invalid character: " + character);
    }
    return index;
  }


  /**
   * Converts a code point to its corresponding character.
   *
   * @param codePoint the code point to be converted
   * @return the character representation of the code point
   * @throws IllegalArgumentException if the code point is out of range.
   */
  public static char characterFromCodePoint(int codePoint) {
    if (codePoint < 0 || codePoint >= CODE_POINTS.length()) {
      throw new IllegalArgumentException("Invalid code point: " + codePoint);
    }
    return CODE_POINTS.charAt(codePoint);
  }


  public static int numberOfValidInputCharacters() {
    return CODE_POINTS.length();
  }


  /**
   * Generates a check character for the given input string using the Luhn mod N algorithm.
   *
   * @param input the input string (non-empty)
   * @return the generated check character
   * @throws IllegalArgumentException if the input is null or empty
   */
  public static char generateCheckCharacter(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Input cannot be empty");
    }


    int factor = 2;
    int sum = 0;
    int n = numberOfValidInputCharacters();


    for (int i = input.length() - 1; i >= 0; i--) {
      int codePoint = codePointFromCharacter(input.charAt(i));
      int addend = factor * codePoint;


      factor = (factor == 2) ? 1 : 2;


      addend = (addend / n) + (addend % n);
      sum += addend;
    }


    int remainder = sum % n;
    int checkCodePoint = (n - remainder) % n;


    return characterFromCodePoint(checkCodePoint);
  }


  /**
   * Validates a check character by applying the Luhn mod N algorithm.
   *
   * @param input the input string (including the check character)
   * @return true if the input passes validation, false otherwise
   * @throws IllegalArgumentException if the input is null or empty
   */
  public static boolean validateCheckCharacter(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Input cannot be empty");
    }


    int factor = 1;
    int sum = 0;
    int n = numberOfValidInputCharacters();


    for (int i = input.length() - 1; i >= 0; i--) {
      int codePoint = codePointFromCharacter(input.charAt(i));
      int addend = factor * codePoint;


      factor = (factor == 2) ? 1 : 2;


      addend = (addend / n) + (addend % n);
      sum += addend;
    }


    int remainder = sum % n;


    return (remainder == 0);
  }
}
