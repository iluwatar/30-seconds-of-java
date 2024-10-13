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
package file;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class FileRenameSnippetTest {

    private File oldFile;
    private File newFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create old file for testing
        oldFile = new File("old_file.txt");
        newFile = new File("new_file.txt");

        // Ensure both files do not exist before each test
        if (oldFile.exists()) {
            oldFile.delete();
        }
        if (newFile.exists()) {
            newFile.delete();
        }

        // Create the old file
        assertTrue(oldFile.createNewFile(), "Failed to create the old file.");
    }

    @AfterEach
    void tearDown() {
        // Clean up the files after each test
        if (oldFile.exists()) {
            oldFile.delete();
        }
        if (newFile.exists()) {
            newFile.delete();
        }
    }

    @Test
    void testFileRenameSuccess() {
        // Test renaming when the old file exists and the new file does not exist
        assertFalse(newFile.exists(), "New file should not exist before rename.");
        assertTrue(oldFile.exists(), "Old file should exist before rename.");

        // Attempt to rename the file
        boolean renamed = oldFile.renameTo(newFile);

        // Assert that the file was renamed successfully
        assertTrue(renamed, "File should be renamed successfully.");
        assertFalse(oldFile.exists(), "Old file should no longer exist.");
        assertTrue(newFile.exists(), "New file should exist after renaming.");
    }

    @Test
    void testOldFileDoesNotExist() {
        // Delete the old file before renaming
        assertTrue(oldFile.delete(), "Failed to delete the old file.");

        // Attempt to rename, which should fail
        boolean renamed = oldFile.renameTo(newFile);

        // Assert that renaming fails when old file does not exist
        assertFalse(renamed, "Renaming should fail because the old file does not exist.");
        assertFalse(newFile.exists(), "New file should not exist after failed rename.");
    }

    @Test
    void testNewFileAlreadyExists() throws IOException {
        // Create the new file before attempting to rename
        assertTrue(newFile.createNewFile(), "Failed to create the new file.");

        // Attempt to rename, which should fail
        boolean renamed = oldFile.renameTo(newFile);

        // Assert that renaming fails because the new file already exists
        assertFalse(renamed, "Renaming should fail because the new file already exists.");
        assertTrue(oldFile.exists(), "Old file should still exist.");
        assertTrue(newFile.exists(), "New file should still exist.");
    }
}
