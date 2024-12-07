import io.WAVProcessor;

import java.util.Arrays;
import java.util.List;

public class WAVProcessorTest {

    public static void testAddEcho() {
        List<Short> input = Arrays.asList((short) 1000, (short) 2000, (short) 3000, (short) 4000, (short) 5000);
        int sampleRate = 5; // Sample rate in samples per second
        float delaySeconds = 0.2f; // 200ms delay
        float decayFactor = 0.5f; // 50% decay for echo

        List<Short> expectedOutput = Arrays.asList((short) 1000, (short) 2000, (short) 3500, (short) 5000, (short) 6500);

        List<Short> actualOutput = WAVProcessor.addEcho(input, sampleRate, delaySeconds, decayFactor);

        if (expectedOutput.equals(actualOutput)) {
            System.out.println("testAddEcho PASSED");
        } else {
            System.out.println("testAddEcho FAILED");
        }
    }

    public static void testReverseAudio() {
        List<Short> input = Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        List<Short> expectedOutput = Arrays.asList((short) 5, (short) 4, (short) 3, (short) 2, (short) 1);

        List<Short> actualOutput = WAVProcessor.reverseAudio(input);

        if (expectedOutput.equals(actualOutput)) {
            System.out.println("testReverseAudio PASSED");
        } else {
            System.out.println("testReverseAudio FAILED");
        }
    }

    public static void testWriteAndReadWAV() {
        try {
            // Input test data
            List<Short> audioData = Arrays.asList((short) 1000, (short) 2000, (short) 3000, (short) 4000, (short) 5000);
            String testFile = "test.wav";

            // Write the test data
            WAVProcessor.writeWAV(testFile, null, audioData);

            // Read back the written data
            List<Short> readData = WAVProcessor.readWAV(testFile).getData();

            if (readData.equals(audioData)) {
                System.out.println("testWriteAndReadWAV PASSED");
            } else {
                System.out.println("testWriteAndReadWAV FAILED");
            }
        } catch (Exception e) {
            System.out.println("testWriteAndReadWAV FAILED with exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testAddEcho();
        testReverseAudio();
        testWriteAndReadWAV();
    }
}

