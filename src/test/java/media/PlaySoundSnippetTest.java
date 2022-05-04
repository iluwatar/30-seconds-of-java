package media;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class PlaySoundSnippetTest {
  /**
   * Tests for {@link PlaySoundSnippet#playSound(String)}.
   */
  @Test
  void playSound() {
    String filename = "media/file_example_WAV_1MG.wav";

    assertDoesNotThrow(() -> {
      PlaySoundSnippet.playSound(filename);
    });

  }

}