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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class IoLibraryTest {
  /**
   * Tests for {@link IoLibrary#readFile(String)}.
   */
  @Test
  void testReadFile() throws FileNotFoundException {
    assertEquals("foo", IoLibrary.readFile("src/test/resources/somelines.txt").get(0));
    assertEquals("bar", IoLibrary.readFile("src/test/resources/somelines.txt").get(1));
    assertEquals("baz", IoLibrary.readFile("src/test/resources/somelines.txt").get(2));
    assertNotEquals("abc", IoLibrary.readFile("src/test/resources/somelines.txt").get(1));
  }

  /**
   * Tests for {@link IoLibrary#inputStreamToString(InputStream)}.
   */
  @Test
  void testInputStreamToString() throws IOException {
    String str = "ąćśź\n"
            + "←≠²³¢²€\n"
            + "июля\n"
            + "åøä\n"
            + "ñí\n"
            + "7月15日起\n"
            + "خەيرلىك ئەتىگەن!";
    assertEquals(str, IoLibrary.inputStreamToString(
            new FileInputStream("src/test/resources/dir1/placeholder.txt")));
    assertNotEquals(str.toUpperCase(), IoLibrary.inputStreamToString(
            new FileInputStream("src/test/resources/dir1/placeholder.txt")));
  }
}