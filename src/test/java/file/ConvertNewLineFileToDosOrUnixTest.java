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

package file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;



public class ConvertNewLineFileToDosOrUnixTest {

  @Test
  public void testconvertLfToCrlf() {
    try {
      ConvertNewLineFileToDosOrUnix.convertLfToCrlf("src/test/resources/zlinuxFileText.txt",
          "src/test/resources/windowsFileText.txt", null);
      var file = new File("src/test/resources/windowsFileText.txt");
      var totalLine =
          Files.readAllLines(Paths.get("src/test/resources/windowsFileText.txt")).stream().count();
      try (FileReader fr = new FileReader(file)) {
        int content;
        int count = 0;
        while ((content = fr.read()) != -1) {
          char c = (char) content;
          if (c == '\n' | c == '\r') {
            count++;
          }
        }
        assertEquals(totalLine * 2, count);
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testconvertCrlfToLf() {
    try {
      ConvertNewLineFileToDosOrUnix.convertCrlfToLf("src/test/resources/windowsFileText.txt",
          "src/test/resources/zlinuxFileText.txt", null);
      var file = new File("src/test/resources/zlinuxFileText.txt");
      var totalLine =
          Files.readAllLines(Paths.get("src/test/resources/zlinuxFileText.txt")).stream().count();
      try (FileReader fr = new FileReader(file)) {
        int content;
        int count = 0;
        while ((content = fr.read()) != -1) {
          char c = (char) content;
          if (c == '\n') {
            count++;
          }
        }
        assertEquals(totalLine, count);
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
