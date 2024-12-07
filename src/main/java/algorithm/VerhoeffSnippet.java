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

package algorithm;

/**
 * VerhoeffSnippet.
 */
public class VerhoeffSnippet {

    private static final int[][] d = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 0, 3, 2, 5, 4, 7, 6, 9, 8},
            {2, 3, 0, 1, 6, 7, 4, 5, 8, 9},
            {3, 2, 1, 0, 7, 6, 5, 4, 9, 8},
            {4, 5, 6, 7, 0, 1, 2, 3, 8, 9},
            {5, 4, 7, 6, 1, 0, 3, 2, 9, 8},
            {6, 7, 4, 5, 2, 3, 0, 1, 8, 9},
            {7, 6, 5, 4, 3, 2, 1, 0, 9, 8},
            {8, 9, 8, 9, 8, 9, 8, 9, 0, 1},
            {9, 8, 9, 8, 9, 8, 9, 8, 1, 0}
    };

    private static final int[][] p = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
            {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
            {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
            {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
            {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
            {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
            {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
    };

    private static final int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

    /**
     * Validates a number using the Verhoeff checksum algorithm.
     *
     * @param num the numeric string to validate
     * @return true if the number is valid according to Verhoeff algorithm, false otherwise
     */
    public static boolean validateVerhoeff(String num) {
        int c = 0;
        int length = num.length();

        // Adjust index for validation of the full number (including check digit)
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(num.charAt(length - i - 1));
            c = d[c][p[(i + 1) % 8][digit]]; // Correct permutation index
        }

        return c == 0; // Final checksum must be zero
    }

    /**
     * Generates a Verhoeff check digit for a given numeric string.
     *
     * @param num the numeric string for which to generate the check digit
     * @return the generated Verhoeff check digit as a string
     */
    public static String generateVerhoeff(String num) {
        int c = 0;
        int length = num.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(num.charAt(length - i - 1));
            c = d[c][p[(i % 8)][digit]];
        }

        return Integer.toString(inv[c]);
    }

}