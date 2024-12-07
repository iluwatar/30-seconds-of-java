package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WAVProcessor {

    public static WAVFile readWAV(String filename) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            WAVHeader header = new WAVHeader();

            dis.readFully(header.riff);
            header.chunkSize = Integer.reverseBytes(dis.readInt());
            dis.readFully(header.wave);
            dis.readFully(header.fmt);
            header.subchunk1Size = Integer.reverseBytes(dis.readInt());
            header.audioFormat = Short.reverseBytes(dis.readShort());
            header.numChannels = Short.reverseBytes(dis.readShort());
            header.sampleRate = Integer.reverseBytes(dis.readInt());
            header.byteRate = Integer.reverseBytes(dis.readInt());
            header.blockAlign = Short.reverseBytes(dis.readShort());
            header.bitsPerSample = Short.reverseBytes(dis.readShort());
            dis.readFully(header.data);
            header.dataSize = Integer.reverseBytes(dis.readInt());

            // Read audio data
            List<Short> audioData = new ArrayList<>();
            for (int i = 0; i < header.dataSize / 2; i++) {
                audioData.add(Short.reverseBytes(dis.readShort()));
            }
            return new WAVFile(header, audioData);
        }
    }

    public static void writeWAV(String filename, WAVHeader header, List<Short> audioData) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.write(header.riff);
            dos.writeInt(Integer.reverseBytes(header.chunkSize));
            dos.write(header.wave);
            dos.write(header.fmt);
            dos.writeInt(Integer.reverseBytes(header.subchunk1Size));
            dos.writeShort(Short.reverseBytes(header.audioFormat));
            dos.writeShort(Short.reverseBytes(header.numChannels));
            dos.writeInt(Integer.reverseBytes(header.sampleRate));
            dos.writeInt(Integer.reverseBytes(header.byteRate));
            dos.writeShort(Short.reverseBytes(header.blockAlign));
            dos.writeShort(Short.reverseBytes(header.bitsPerSample));
            dos.write(header.data);
            dos.writeInt(Integer.reverseBytes(header.dataSize));

            for (short sample : audioData) {
                dos.writeShort(Short.reverseBytes(sample));
            }
        }
    }

    public static List<Short> addEcho(List<Short> audioData, int sampleRate, float delaySeconds, float decayFactor) {
        List<Short> echoedData = new ArrayList<>(audioData);
        int delaySamples = (int) (sampleRate * delaySeconds);

        for (int i = delaySamples; i < audioData.size(); i++) {
            short echo = (short) (audioData.get(i - delaySamples) * decayFactor);
            echoedData.set(i, (short) (audioData.get(i) + echo));
        }
        return echoedData;
    }

    public static WAVHeader changeSpeedHeader(WAVHeader header, float speedFactor) {
        header.sampleRate = (int) (header.sampleRate * speedFactor);
        header.byteRate = header.sampleRate * header.numChannels * header.bitsPerSample / 8;
        return header;
    }

    public static List<Short> reverseAudio(List<Short> audioData) {
        List<Short> reversedData = new ArrayList<>(audioData);
        for (int i = 0, j = reversedData.size() - 1; i < j; i++, j--) {
            short temp = reversedData.get(i);
            reversedData.set(i, reversedData.get(j));
            reversedData.set(j, temp);
        }
        return reversedData;
    }

    public static void main(String[] args) {
        try {
            // Read WAV file
            WAVFile wavFile = readWAV("C:/Users/CRIZMA MEGA STORE/Desktop/OpenGL-Lab-New/vendor\\SDL2\\test");

            // Process WAV
            List<Short> echoedData = addEcho(wavFile.getData(), wavFile.header.sampleRate, 0.5f, 0.6f);
            WAVHeader newHeader = changeSpeedHeader(wavFile.header, 1.5f);
            List<Short> reversedData = reverseAudio(echoedData);

            // Write output
            writeWAV("output.wav", newHeader, reversedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

