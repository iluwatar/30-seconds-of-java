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

package media;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.scene.media.MediaException;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

/*
 * Tests for 30 Seconds of Java code library
 *
 */

class PlayVideoSnippetTest extends ApplicationTest {
  /**
   * Tests for {@link PlayVideoSnippet#main(String[] args)}}.
   */

  final String pathOfSupportedFile = "src/test/resources/video.mp4";
  final String pathOfUnsupportedFile = "src/test/resources/video.wmv";


  @Test
  void testSupportedVideoFilePlaysSuccessfully() throws Exception {
    assertDoesNotThrow(() -> PlayVideoSnippetTest.launch(PlayVideoSnippet.class,
            new String[]{pathOfSupportedFile}));
  }

  @Test
  void testUnsupportedVideoFileThrowsError() throws Exception {
    RuntimeException exception = assertThrows(RuntimeException.class,
        () -> PlayVideoSnippetTest.launch(PlayVideoSnippet.class,
                    new String[]{pathOfUnsupportedFile}));
    assertTrue(exception.getCause().getCause().getClass().equals(MediaException.class));
  }
}