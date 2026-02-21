/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
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

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * PlaySoundSnippet.
 *
 * <p>Plays a sound file using the Java Sound API. No external libraries are used. This method
 * blocks until playback completes. Common supported formats are WAV, AIFF and AU; actual
 * supported formats depend on the runtime JVM/platform.
 */
public class PlaySoundSnippet {

  /**
   * Play a sound file and block until playback finishes.
   *
   * @param filename path to the audio file
   * @throws IOException if an I/O error occurs
   * @throws UnsupportedAudioFileException if the audio file format is not supported
   * @throws LineUnavailableException if a clip line cannot be opened
   * @throws InterruptedException if the thread is interrupted while waiting for playback
   */
  public static void playSound(String filename)
      throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
    var file = new File(filename);
    try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(file)) {
      Clip clip = AudioSystem.getClip();
      clip.open(audioIn);

      final Object lock = new Object();
      final boolean[] finished = {false};

      clip.addLineListener((LineEvent event) -> {
        if (event.getType() == LineEvent.Type.STOP) {
          synchronized (lock) {
            finished[0] = true;
            lock.notifyAll();
          }
        }
      });

      clip.start();

      synchronized (lock) {
        while (!finished[0]) {
          lock.wait();
        }
      }

      clip.close();
    }
  }
}
