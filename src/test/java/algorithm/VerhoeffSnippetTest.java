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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests for VerhoeffSnippet.
 */
class VerhoeffSnippetTest {

    /**
     * Tests the {@link VerhoeffSnippet#validateVerhoeff(String)} method.
     */
    @Test
    void testValidateVerhoeff() {
        String validInput = "1428579";   // Correct Verhoeff input with a valid check digit
        String invalidInput = "1428570"; // Incorrect Verhoeff input with an invalid check digit

        // Validate valid input
        boolean isValid = VerhoeffSnippet.validateVerhoeff(validInput);
        System.out.println("Testing validateVerhoeff with valid input: "
                + validInput + " -> " + isValid);
        assertTrue(isValid, "Expected " + validInput + " to be valid, but it was not.");

        // Validate invalid input
        boolean isInvalid = VerhoeffSnippet.validateVerhoeff(invalidInput);
        System.out.println("Testing validateVerhoeff with invalid input: "
                + invalidInput + " -> " + isInvalid);
        assertFalse(isInvalid, "Expected " + invalidInput + " to be invalid, but it was not.");
    }

    /**
     * Tests the {@link VerhoeffSnippet#generateVerhoeff(String)} method.
     */
    @Test
    void testGenerateVerhoeff() {
        String baseInput = "142857"; // Base input without the Verhoeff check digit

        // Generate a Verhoeff check digit
        String checkDigit = VerhoeffSnippet.generateVerhoeff(baseInput);
        assertTrue("9".equals(checkDigit),
                "Expected check digit to be 9 for input " + baseInput + ", but got " + checkDigit);

        // Combine and validate
        String fullInput = baseInput + checkDigit;
        boolean isValid = VerhoeffSnippet.validateVerhoeff(fullInput);
        System.out.println("Generated check digit for input " + baseInput + " -> " + checkDigit);
        System.out.println("Testing validateVerhoeff with full input: " + fullInput + " -> " + isValid);

        assertTrue(isValid, "Expected " + fullInput + " to be valid, but it was not.");
    }
}