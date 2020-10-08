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
    new BufferedReader(new FileReader(new File(fileIn))).lines().forEach(linha -> {
      try {
        writer.write(linha.replaceAll("\r", "") + "\r\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    writer.flush();
    writer.close();

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
    new BufferedReader(new FileReader(new File(fileIn))).lines().forEach(linha -> {
      try {
        writer.write(linha.replaceAll("\r", "\n") + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    writer.flush();
    writer.close();
  }
}
