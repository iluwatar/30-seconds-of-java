package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileRenameSnippet {

    public static void main(String[] args) {
        String oldFileName = "old_file.txt";
        String newFileName = "new_file.txt";

        // Using Files.move() for renaming
        Path oldFilePath = Path.of(oldFileName);
        Path newFilePath = Path.of(newFileName);

        try {
            Files.move(oldFilePath, newFilePath);
            System.out.println("File renamed successfully.");
        } catch (IOException e) {
            System.out.println("Failed to rename the file: " + e.getMessage());
        }
    }
}