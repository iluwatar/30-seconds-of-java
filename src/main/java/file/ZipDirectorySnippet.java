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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
 * 30 Seconds of Java code library
 *
 */
public class ZipDirectorySnippet {
  /**
   * Zip a complete directory.
   *
   * @param srcDirectoryName The path to the directory to be zipped
   * @param zipFileName The location and name of the zipped file.
   * @throws IOException if an I/O error occurs
   * */
  public static void zipDirectory(String srcDirectoryName, String zipFileName) throws IOException {
    var srcDirectory = new File(srcDirectoryName);
    try (
        var fileOut = new FileOutputStream(zipFileName);
        var zipOut = new ZipOutputStream(fileOut)
    ) {
      zipFile(srcDirectory, srcDirectory.getName(), zipOut);
    }
  }

  /**
   * Utility function which either zips a single file, or recursively calls itself for 
   * a directory to traverse down to the files contained within it.
   *
   * @param fileToZip The file as a resource
   * @param fileName The actual name of the file
   * @param zipOut The output stream to which all data is being written
   * */
  public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) 
      throws IOException {
    if (fileToZip.isHidden()) { // Ignore hidden files as standard
      return;
    }
    if (fileToZip.isDirectory()) {
      if (fileName.endsWith("/")) {
        zipOut.putNextEntry(new ZipEntry(fileName)); // To be zipped next
        zipOut.closeEntry();
      } else {
        // Add the "/" mark explicitly to preserve structure while unzipping action is performed
        zipOut.putNextEntry(new ZipEntry(fileName + "/"));
        zipOut.closeEntry();
      }
      var children = fileToZip.listFiles();
      for (var childFile : children) { // Recursively apply function to all children
        zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
      }
      return;
    }
    try (
        var fis = new FileInputStream(fileToZip) // Start zipping once we know it is a file
    ) {
      var zipEntry = new ZipEntry(fileName);
      zipOut.putNextEntry(zipEntry);
      var bytes = new byte[1024];
      var length = 0;
      while ((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }
}
