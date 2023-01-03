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

import java.util.HashSet;
import java.util.Set;

/**
 * CommonLettersSnippet.
 */
public class CommonLettersSnippet {

    /**
     * Find Common Characters inside given two strings
     *
     * @param firstStr
     * @param secondStr
     * @return Common Characters
     */
    public static String getCommonLetters(String firstStr, String secondStr) {
        Set<String> commonLetters = new HashSet<>();
        for (Character currentCharacter : firstStr.toCharArray()) {
            if (isCommonLetter(secondStr, currentCharacter)) {
                commonLetters.add(currentCharacter.toString());
            }
        }
        return String.join(" ", commonLetters);
    }

    private static boolean isCommonLetter(String str, Character character) {
        return str.contains(character.toString()) && Character.isLetter(character);
    }
}
