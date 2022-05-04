package media;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/*
 * 30 Seconds of Java code library
 *
 */
public class PlaySoundSnippet {


  /**
   * Factorial. Works only for small numbers
   *
   * @param soundFile which needs to be played
   * @throws IOException  if an I/O error occurs
   * @throws UnsupportedAudioFileException if the file did not contain valid data of a recognized file type and format
   * @throws LineUnavailableException  if a line cannot be opened because it is unavailable
   */
  public static void playSound(String soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    File f = new File("./" + soundFile);
    AudioInputStream audioIn = null;
    Clip clip = null;

    try {
      audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
      clip = AudioSystem.getClip();
      clip.open(audioIn);

      clip.start();

      FloatControl volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
      volume.setValue(1.0f); // Reduce volume by 10 decibels.

      clip.drain();

    }
     finally {
      try {
        clip.close();
      }
      catch (Exception exp) {
        exp.printStackTrace();
      }
    }

  }
}


