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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
public class UnZipFileSnippetTest {
  /**
   * Tests for {@link UnZipFileSnippet#unzipFiles(String, String)}.
   */
  @Test
  void testUnzipFiles() throws IOException {
    final String zipInput = "src/test/resources/multiple.zip";
    final var destDir = "src/test/resources/dir1";
    String[] destFiles = null;
    try {
      destFiles = UnZipFileSnippet.unzipFiles(zipInput, destDir);

      for (String file : destFiles) {
        assertTrue(Files.exists(Paths.get(file)));
      }
    } finally {
      if (destFiles != null) {
        File deleteFile;
        for (String file : destFiles) {
          deleteFile = new File(file);

          if (!deleteFile.isDirectory()) {
            Files.deleteIfExists(deleteFile.toPath());
          }
        }
      }
    }
  }
}
