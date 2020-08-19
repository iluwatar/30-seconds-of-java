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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

import java.util.zip.ZipOutputStream;

public class FileLibrary {
  /**
   * List directories.
   *
   * @param path the path where to look
   * @return array of File
   */
  public static File[] listDirectories(String path) {
    return new File(path).listFiles(File::isDirectory);
  }

  /**
   * List files in directory.
   *
   * @param folder the path where to look
   * @return array of File
   */
  public static File[] listFilesInDirectory(File folder) {
    return folder.listFiles(File::isFile);
  }

  /**
   * Recursively list all the files in directory.
   *
   * @param path the path to start the search from
   * @return list of all files
   */
  public static List<File> listAllFiles(String path) {
    var all = new ArrayList<File>();
    var list = new File(path).listFiles();
    if (list != null) {  // In case of access error, list is null
      for (var f : list) {
        if (f.isDirectory()) {
          all.addAll(listAllFiles(f.getAbsolutePath()));
        } else {
          all.add(f.getAbsoluteFile());
        }
      }
    }
    return all;
  }

  /**
   * Read file as list of strings.
   *
   * @param filename the filename to read from
   * @return list of strings
   * @throws IOException if an I/O error occurs
   */
  public static List<String> readLines(String filename) throws IOException {
    return Files.readAllLines(Paths.get(filename));
  }

  /**
   * Zip single file.
   *
   * @param srcFilename the filename of the source file
   * @param zipFilename the filename of the destination zip file
   * @throws IOException if an I/O error occurs
   */
  public static void zipFile(String srcFilename, String zipFilename) throws IOException {
    var srcFile = new File(srcFilename);
    try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut);
            var fileIn = new FileInputStream(srcFile)
    ) {
      var zipEntry = new ZipEntry(srcFile.getName());
      zipOut.putNextEntry(zipEntry);
      final var bytes = new byte[1024];
      int length;
      while ((length = fileIn.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }

  /**
   * Zip multiples files.
   *
   * @param srcFilenames array of source file names
   * @param zipFilename  the filename of the destination zip file
   * @throws IOException if an I/O error occurs
   */
  public static void zipFiles(String[] srcFilenames, String zipFilename) throws IOException {
    try (
            var fileOut = new FileOutputStream(zipFilename);
            var zipOut = new ZipOutputStream(fileOut)
    ) {
      for (String srcFilename : srcFilenames) {
        var srcFile = new File(srcFilename);
        try (var fileIn = new FileInputStream(srcFile)) {
          var zipEntry = new ZipEntry(srcFile.getName());
          zipOut.putNextEntry(zipEntry);
          final var bytes = new byte[1024];
          int length;
          while ((length = fileIn.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
          }
        }
      }
    }
  }
}
