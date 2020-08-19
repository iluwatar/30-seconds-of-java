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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class StringLibrary {
  /**
   * Checks if given string is palindrome (same forward and backward). Skips non-letter characters
   * Credits: https://github.com/kousen/java_8_recipes
   *
   * @param s string to check
   * @return true if palindrome
   */
  public static boolean isPalindrome(String s) {
    var sb = new StringBuilder();
    for (var c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        sb.append(c);
      }
    }
    var forward = sb.toString().toLowerCase();
    var backward = sb.reverse().toString().toLowerCase();
    return forward.equals(backward);
  }

  /**
   * Reverse string.
   *
   * @param s the string to reverse
   * @return reversed string
   */
  public static String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  /**
   * Convert string to date.
   *
   * @param date   the date string
   * @param format expected date format
   * @return Date
   * @throws ParseException in case of an unparseable date string
   */
  public static Date stringToDate(String date, String format) throws ParseException {
    var simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.parse(date);
  }

  /**
   * Checks if two words are anagrams (contains same characters with same frequency in any order).
   *
   * @param s1 The first string to be checked
   * @param s2 The second string to be checked
   * @return true if they are anagrams of each other
   */
  public static boolean isAnagram(String s1, String s2) {
    var l1 = s1.length();
    var l2 = s2.length();
    var arr1 = new int[256];
    var arr2 = new int[256];
    if (l1 != l2) {
      return false;
    }
    for (var i = 0; i < l1; i++) {
      arr1[s1.charAt(i)]++;
      arr2[s2.charAt(i)]++;
    }
    return Arrays.equals(arr1, arr2);
  }

  /**
   * Find the Levenshtein distance between two words. https://en.wikipedia.org/wiki/Levenshtein_distance
   *
   * @param word1 first word
   * @param word2 second word
   * @return distance
   */
  public static int findLevenshteinDistance(String word1, String word2) {
    // If word2 is empty, removing
    int[][] ans = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      ans[i][0] = i;
    }
    // if word1 is empty, adding
    for (int i = 0; i <= word2.length(); i++) {
      ans[0][i] = i;
    }
    // None is empty
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        int min = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
        ans[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? ans[i - 1][j - 1] : min + 1;
      }
    }
    return ans[word1.length()][word2.length()];
  }
}
