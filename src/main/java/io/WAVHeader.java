package io;

public class WAVHeader {
    byte[] riff = new byte[4]; // "RIFF"
    int chunkSize; // File size - 8 bytes
    byte[] wave = new byte[4]; // "WAVE"
    byte[] fmt = new byte[4]; // "fmt "
    int subchunk1Size; // PCM: 16
    short audioFormat; // PCM = 1
    short numChannels; // Mono = 1, Stereo = 2
    int sampleRate; // Samples per second
    int byteRate; // sampleRate * numChannels * bitsPerSample / 8
    short blockAlign; // numChannels * bitsPerSample / 8
    short bitsPerSample; // 8 bits = 8, 16 bits = 16
    byte[] data = new byte[4]; // "data"
    int dataSize; // Number of bytes in data section
}
