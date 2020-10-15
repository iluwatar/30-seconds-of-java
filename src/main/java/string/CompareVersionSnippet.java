package string;

public class CompareVersionSnippet {

  private static final String EXTRACT_VERSION_REGEX = ".*?((?<!\\w)\\d+([.-]\\d+)*).*";

  /**
   * Compares two version strings.
   * Credits: https://stackoverflow.com/a/6702000/6645088 and https://stackoverflow.com/a/44592696/6645088
   *
   * @param v1 the first version string to compare
   * @param v2 the second version string to compare
   * @return the value {@code 0} if the two strings represent same versions;
   *     a value less than {@code 0} if {@code v1} is greater than {@code v2}; and
   *     a value greater than {@code 0} if {@code v2} is greater than {@code v1}
   */
  public static int compareVersion(String v1, String v2) {
    var components1 = getVersionComponents(v1);
    var components2 = getVersionComponents(v2);
    int length = Math.max(components1.length, components2.length);
    for (int i = 0; i < length; i++) {
      Integer c1 = i < components1.length ? Integer.parseInt(components1[i]) : 0;
      Integer c2 = i < components2.length ? Integer.parseInt(components2[i]) : 0;
      int result = c1.compareTo(c2);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }

  private static String[] getVersionComponents(String version) {
    return version.replaceAll(EXTRACT_VERSION_REGEX, "$1").split("\\.");
  }
}