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


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class FileRenameSnippetTest {




        @Test
        void testFileRenameSuccess() {
            // Create temporary files for testing
            File oldFile = new File("old_file_test.txt");
            File newFile = new File("new_file_test.txt");

            try {
                // Create the old file
                oldFile.createNewFile();

                // Rename the file
                FileRenameSnippet.fileRename(oldFile.getAbsolutePath(), newFile.getAbsolutePath());

                // Verify the old file is deleted and the new file is created
                assertTrue(newFile.exists());
                assertFalse(oldFile.exists());
            } catch (IOException e) {
                fail("Failed to create temporary files: " + e.getMessage());
            } finally {
                // Delete the temporary files
                oldFile.delete();
                newFile.delete();
            }
        }

        @Test
        void testFileRenameOldFileDoesNotExist() {
            // Create a new file for testing
            File newFile = new File("new_file_test.txt");

            try {
                // Try to rename a non-existent old file
                FileRenameSnippet.fileRename("non_existent_file.txt", newFile.getAbsolutePath());

                // Verify the new file is not created
                assertFalse(newFile.exists());
            } catch (Exception e) {
                // Expecting an exception since the old file doesn't exist
                assertTrue(e.getMessage().contains("The old file non_existent_file.txt does not exist."));
            } finally {
                // Delete the temporary file
                newFile.delete();
            }
        }

        @Test
        void testFileRenameNewFileAlreadyExists() {
            // Create temporary files for testing
            File oldFile = new File("old_file_test.txt");
            File newFile = new File("new_file_test.txt");

            try {
                // Create both files
                oldFile.createNewFile();
                newFile.createNewFile();

                // Try to rename the old file to an existing new file
                FileRenameSnippet.fileRename(oldFile.getAbsolutePath(), newFile.getAbsolutePath());

                // Verify the old file is not deleted and the new file is not overwritten
                assertTrue(oldFile.exists());
                assertTrue(newFile.exists());
            } catch (IOException e) {
                fail("Failed to create temporary files: " + e.getMessage());
            } finally {
                // Delete the temporary files
                oldFile.delete();
                newFile.delete();
            }
        }
    }


