package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class ZipDirectorySnippetTest {
    /**
     * Tests for {@link ZipDirectorySnippet#zipDirectory(String, String)}.
     */
    @Test
    void testZipFileDirectory() throws IOException {
        final var src = "src/test/resources/dir3";
        final var dst = "src/test/resources/dir3.zip";
        try {
            ZipDirectorySnippet.zipDirectory(src, dst);
            assertTrue(Files.exists(Paths.get(dst)));
            var zipFile = new ZipFile(Paths.get(dst).toFile());
            var regularFiles = 0;
            var directories = 0;
            var zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                if (zipEntries.nextElement().isDirectory()) {
                    directories++;
                } else {
                    regularFiles++;
                }
            }
            assertEquals(4, zipFile.size());
            assertEquals(directories, 2); // The root directory + inner directory
            assertEquals(regularFiles, 2); // Two simple files
            zipFile.close();
        } finally {
            Files.deleteIfExists(new File(dst).toPath());
        }
    }
}