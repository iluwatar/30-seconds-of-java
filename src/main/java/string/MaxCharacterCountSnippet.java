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

package string;

/**
 * MaxCharacterCountSnippet.
 */
public class MaxCharacterCountSnippet {

  /**
   * The maximum count of times a specific character appears in a string.
   *
   * @param str َA specific string
   * @param character A specific character
   * @return the maximum count of one character
   */

  public static int getMaxCharacterCount(String str, char character) {
    int characterCount = 0;
    int maxCharacterCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if ((str.charAt(i)) == character) {
        characterCount++;
        maxCharacterCount = Math.max(maxCharacterCount, characterCount);
      } else {
        characterCount = 0;
      }
    }
    return maxCharacterCount;
  }
}
