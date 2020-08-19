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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class StringLibraryTest {
  /**
   * Tests for {@link StringLibrary#isPalindrome(String)}.
   */
  @Test
  void testIsPalindrome() {
    assertTrue(StringLibrary.isPalindrome("saippuakauppias"));
    // non-letter characters are skipped
    assertTrue(StringLibrary.isPalindrome("111 Saippua - Kauppias 321"));
    assertFalse(StringLibrary.isPalindrome("Type O Negative"));
    assertFalse(StringLibrary.isPalindrome("Foo12121Bar"));
  }

  /**
   * Tests for {@link StringLibrary#reverseString(String)}.
   */
  @Test
  void testReverseString() {
    assertEquals("oof", StringLibrary.reverseString("foo"));
    assertEquals("ÖÄÅ321FED cba", StringLibrary.reverseString("abc DEF123ÅÄÖ"));
  }

  /**
   * Tests for {@link StringLibrary#stringToDate(String, String)}.
   */
  @Test
  void testStringToDate() throws ParseException {
    var calendar = Calendar.getInstance();
    calendar.setTime(StringLibrary.stringToDate("2017-08-18", "yyyy-MM-dd"));
    assertEquals(2017, calendar.get(Calendar.YEAR));
    assertEquals(8, calendar.get(Calendar.MONTH) + 1);
    assertEquals(18, calendar.get(Calendar.DAY_OF_MONTH));
  }

  /**
   * Tests for {@link StringLibrary#isAnagram(String, String)}.
   */
  @Test
  void testIsAnagram() {
    assertTrue(StringLibrary.isAnagram("Aditya", "aytdiA"));
    assertFalse(StringLibrary.isAnagram("Aditya", "aytida"));
    assertTrue(StringLibrary.isAnagram("~~# @!", "~@!#~ "));
    assertTrue(StringLibrary.isAnagram("Mother In Law", "hIt Ler woMan"));
    assertFalse(StringLibrary.isAnagram("aa", "aaa"));
  }

  /**
   * Tests for {@link StringLibrary#findLevenshteinDistance(String, String)}.
   */
  @Test
  void testFindLevenshteinDistance() {
    assertEquals(3, StringLibrary.findLevenshteinDistance("kitten", "kit"));
    assertEquals(6, StringLibrary.findLevenshteinDistance("kitten", ""));
    assertEquals(7, StringLibrary.findLevenshteinDistance("", "sitting"));
    assertEquals(3, StringLibrary.findLevenshteinDistance("kitten", "sitting"));
    assertEquals(5, StringLibrary.findLevenshteinDistance("intention", "execution"));
    assertEquals(10, StringLibrary
            .findLevenshteinDistance("zoologicoarchaeologist", "zoogeologist"));
  }
}