package file;

import java.io. File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileRenameSnippet {

    public static void main(String[] args) {
        // Get the old and new file names from the user
        String oldFileName = "old_file.txt";
        String newFileName = "new_file.txt";

        // Create File objects for the old and new files
        File oldFile = new File(oldFileName);
        File newFile = new File(newFileName);

        // Check if the old file exists
        if (!oldFile.exists()) {
            System.out .println("The old file " + oldFileName + " does not exist.");
            return;
        }

        // Check if the new file already exists
        if (newFile.exists()) {
            System.out.println("The new file " + newFileName + " already exists.");
            return;
        }

        // Rename the file
        boolean renamed = oldFile.renameTo(newFile);

        if (renamed) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Failed to rename the file.");

        }
    }
}


//EOF