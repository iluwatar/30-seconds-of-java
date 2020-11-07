  /*
 * MIT License
 *
 * Copyright (c) 2017-2020 Ilkka Seppälä
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

/*
 * 30 Seconds of Java code library
 *
 */

public class MoveSpecialCharsToEndSnippet {
  /**
   * Find the Levenshtein distance between two words. https://en.wikipedia.org/wiki/Levenshtein_distance
   *
   * @param input string to process
   * @return modified string
   */
	public static String move(String input) {
		StringBuilder firstPart = new StringBuilder(), secondPart = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			Character current = input.charAt(i);
			if (current > 64 && current < 91 || current > 96 && current < 123 || current > 47 && current < 58) {
				firstPart.append(current);
			} else {
				secondPart.append(current);
			}
		}
		return firstPart.append(secondPart).toString();
	}
}
