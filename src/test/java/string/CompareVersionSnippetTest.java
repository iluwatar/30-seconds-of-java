/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
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

package string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CompareVersionSnippetTest {
  /**
   * Tests for {@link CompareVersionSnippet#compareVersion(String, String)}.
   */
  @Test
  public void testCompareVersion() {
    assertEquals(0, CompareVersionSnippet.compareVersion("awesome-app-2.3.4-SNAPSHOT", "2.3.4"));
    assertEquals(0, CompareVersionSnippet.compareVersion("2.3.4-SNAPSHOT", "2.3.4"));
    assertEquals(1, CompareVersionSnippet.compareVersion("2.3.4.1-SNAPSHOT", "2.3.4"));
    assertEquals(0, CompareVersionSnippet.compareVersion("2.03.4", "2.3.4"));
    assertEquals(-1, CompareVersionSnippet.compareVersion("2.03.4", "2.3.4.1"));
    assertEquals(-1, CompareVersionSnippet.compareVersion("2.3.4", "2.30.4"));
    assertEquals(0, CompareVersionSnippet.compareVersion("2.3.0", "2.3"));
    assertEquals(1, CompareVersionSnippet.compareVersion("2.3.3", "2.3"));

    // Test for sorting versions
    List<String> versions = Arrays.asList(
        "2.3.4.1",
        "2.3.5-beta2",
        "2.3.4.RELEASE",
        "awesome-app-2.2",
        "2.3.2-SNAPSHOT",
        "2.2.1"
    );

    List<String> expectedSortedVersion = Arrays.asList(
        "awesome-app-2.2",
        "2.2.1",
        "2.3.2-SNAPSHOT",
        "2.3.4.RELEASE",
        "2.3.4.1",
        "2.3.5-beta2"
    );

    String oldestVersion = versions.stream().min(CompareVersionSnippet::compareVersion).get();
    assertEquals("awesome-app-2.2", oldestVersion);

    String newestVersion = versions.stream().max(CompareVersionSnippet::compareVersion).get();
    assertEquals("2.3.5-beta2", newestVersion);

    assertArrayEquals(expectedSortedVersion.toArray(),
        versions.stream().sorted(CompareVersionSnippet::compareVersion).toArray());
  }
}