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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class FileLibraryTest {
  /**
   * Tests for {@link FileLibrary#listDirectories(String)}.
   */
  @Test
  void testListDirectories() {
    var files = FileLibrary.listDirectories("src/test/resources");
    assertTrue(Arrays.stream(files).allMatch(File::isDirectory));
    assertTrue(Arrays.asList(files).contains(new File("src/test/resources/dir1")));
    assertTrue(Arrays.asList(files).contains(new File("src/test/resources/dir2")));
  }

  /**
   * Tests for {@link FileLibrary#listFilesInDirectory(File)}.
   */
  @Test
  void testListFilesInDirectory() {
    var files = FileLibrary.listFilesInDirectory(new File("src/test/resources"));
    assertEquals(2, files.length);
    var filenames = new HashSet<>(Arrays.asList(files[0].toString(), files[1].toString()));
    assertTrue(filenames.contains("src/test/resources/somelines.txt"));
    assertTrue(filenames.contains("src/test/resources/someotherlines.txt"));
  }

  /**
   * Tests for {@link FileLibrary#listAllFiles(String)}.
   */
  @Test
  void testListAllFiles() {
    var files = FileLibrary.listAllFiles("src/test/resources");
    assertEquals(4, files.size());
  }

  /**
   * Tests for {@link FileLibrary#readLines(String)}.
   *
   * @throws IOException if an I/O error occurs
   */
  @Test
  void testReadLines() throws IOException {
    var somelines = FileLibrary.readLines("src/test/resources/somelines.txt");
    assertEquals(3, somelines.size());
    assertEquals("foo", somelines.get(0));
    assertEquals("bar", somelines.get(1));
    assertEquals("baz", somelines.get(2));
    assertThrows(IOException.class, () -> FileLibrary.readLines("some/nonexistent/filename.txt"));
  }

  /**
   * Tests for {@link FileLibrary#zipFile(String, String)}.
   */
  @Test
  void testZipFile() throws IOException {
    final var src = "src/test/resources/somelines.txt";
    final var dst = "src/test/resources/somelines.zip";
    try {
      FileLibrary.zipFile(src, dst);
      assertTrue(Files.exists(Paths.get(dst)));
    } finally {
      Files.deleteIfExists(new File(dst).toPath());
    }
  }

  /**
   * Tests for {@link FileLibrary#zipFiles(String[], String)}.
   */
  @Test
  void testZipFiles() throws IOException {
    final String[] srcFilenames = {
        "src/test/resources/somelines.txt", "src/test/resources/someotherlines.txt"
    };
    final var dst = "src/test/resources/multiple.zip";
    try {
      FileLibrary.zipFiles(srcFilenames, dst);
      assertTrue(Files.exists(Paths.get(dst)));
    } finally {
      Files.deleteIfExists(new File(dst).toPath());
    }
  }
}
