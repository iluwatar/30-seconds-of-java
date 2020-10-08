package file;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
