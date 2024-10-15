package string;

public class KMPSubstringSearchSnippet {

    /**
     * Implements the Knuth-Morris-Pratt (KMP) algorithm to find the index of the first occurrence of a substring in a given text.
     *
     * @param text The text in which the substring is to be searched.
     * @param pattern The substring pattern to search for.
     * @return The index of the first occurrence of the pattern in the text, or -1 if the pattern is not found.
     */
    public static int kmpSearch(String text, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0; // Trivial case: empty pattern
        }

        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i - j; // Found pattern at index (i - j)
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use the LPS array to skip characters
                } else {
                    i++; // If no match and j is 0, move to the next character in text
                }
            }
        }
        return -1; // Pattern not found
    }

    /**
     * Computes the LPS (Longest Prefix Suffix) array for the pattern, which indicates the longest proper prefix which is also a suffix.
     *
     * @param pattern The pattern for which the LPS array is to be computed.
     * @return The LPS array.
     */
    private static int[] computeLPSArray(String pattern) {
        int length = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0; // LPS for the first character is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Fall back to the previous LPS value
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
