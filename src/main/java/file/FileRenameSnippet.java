/*
 * MIT License
 *
 * Copyright (c) 2017-2024 Ilkka Seppälä
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
package file;

import java.io. File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * FileRenameSnippet.
 */

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
