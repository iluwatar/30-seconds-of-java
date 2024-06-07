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

package array;

import java.util.Arrays;

/**
 * ArrayModeSnippet.
 */
public class ArrayModeSnippet {

    /**
     * Returns the mode(s) of the array.
     * <p>
     * This method finds the mode(s) of the input array, handling cases where there may be multiple modes or no repetition of numbers.
     *
     * @param arr the array to find mode(s) in
     * @return an array containing the mode(s) of the input array
     */

    public static int[] modeArray(int[] arr) {
        // Find the minimum and maximum numbers in the array
        int minNumber = Arrays.stream(arr).min().orElse(0);
        int maxNumber = Arrays.stream(arr).max().orElse(0);

        // Calculate the range of numbers in the array
        int range = maxNumber - minNumber + 1;

        // Array to store the frequency of each element
        int[] frequency = new int[range];

        // Calculate the frequency of each element
        for (int num : arr) {
            frequency[num - minNumber]++;
        }

        // Find the maximum frequency value
        int maxFrequency = Arrays.stream(frequency).max().orElse(0);

        // Count the number of modes
        int modesCount = 0;
        for (int freq : frequency) {
            if (freq == maxFrequency) {
                modesCount++;
            }
        }

        // Build the array of modes
        int[] modes = new int[modesCount];
        int index = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == maxFrequency) {
                modes[index++] = i + minNumber;
            }
        }

        return modes;
    }
}

