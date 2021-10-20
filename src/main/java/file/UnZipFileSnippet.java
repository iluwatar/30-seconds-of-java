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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * 30 Seconds of Java code library
 *
 */
public class UnZipFileSnippet {
  /**
   * Unzip a zip file.
   *
   * @param fileZip source zip file
   * @param destDir the directory of the destination unzipped files
   * @throws IOException if an I/O error occurs
   * @return List of extracted files
   */
  public static String[] unzipFiles(String fileZip, String destDir) throws IOException {
    try (
            var zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(fileZip)))
    ) {
      ArrayList<String> files = new ArrayList<>();
      ZipEntry zipEntry = zipIn.getNextEntry();

      while (zipEntry != null) {
        File newFile = new File(destDir, zipEntry.getName());
        if (zipEntry.isDirectory()) {
          if (!newFile.isDirectory() && !newFile.mkdirs()) {
            throw new IOException("Failed to create directory " + newFile);
          }
        } else {
          files.add(newFile.getAbsolutePath());

          try (var fileOut = new FileOutputStream(newFile)) {
            final var bytes = new byte[1024];
            int length;
            while ((length = zipIn.read(bytes)) > 0) {
              fileOut.write(bytes, 0, length);
            }
          }

        }
        zipEntry = zipIn.getNextEntry();
      }

      return files.toArray(String[]::new);
    }
  }
}
