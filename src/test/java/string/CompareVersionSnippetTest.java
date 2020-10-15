package string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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