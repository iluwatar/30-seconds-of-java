package io;

import java.util.List;

public class WAVFile {
    WAVHeader header;
    private final List<Short> data;

    public WAVFile(WAVHeader header, List<Short> data) {
        this.header = header;
        this.data = data;
    }


    public List<Short> getData() {
        return data;
    }
}


