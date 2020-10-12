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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConvertNewLineFileToDosOrUnix {
  /**
   * Convert Unix file LF to Windows File CRLF.
   *
   * @param fileIn  Path file to read and convert
   * @param fileOut Path file to convert
   * @throws IOException if an I/O error occurs
   */
  public static void convertLfToCrlf(String fileIn, String fileOut, String charSet) 
      throws IOException {
    charSet = charSet != null ? charSet : "ISO-8859-1";
    BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(new File(fileOut)), charSet));

    BufferedReader reader = new BufferedReader(new FileReader(new File(fileIn)));
    reader.lines().forEach(linha -> {
      try {
        writer.write(linha.replaceAll("\r", "") + "\r\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    writer.flush();
    writer.close();
    reader.close();

  }

  /**
   * Convert Unix file CRLF to Windows File LF.
   *
   * @param fileIn  Path file to read and convert
   * @param fileOut Path file to convert
   * @throws IOException if an I/O error occurs
   */
  public static void convertCrlfToLf(String fileIn, String fileOut, String charSet)
      throws IOException {
    charSet = charSet != null ? charSet : "UTF-8";
    BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(new File(fileOut)), charSet));
      
    BufferedReader reader = new BufferedReader(new FileReader(new File(fileIn)));
    reader.lines().forEach(linha -> {
      try {
        writer.write(linha.replaceAll("\r", "\n") + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    writer.flush();
    writer.close();
    reader.close();
  }
}
