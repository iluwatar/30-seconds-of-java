/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppäläy
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

import java.util.ArrayList;
import java.util.Collections;

/**
 * SortingHeuristicIntelligentTableSnippet.
 */
public class SortingHeuristicIntelligentTableSnippet {
    /**
     * Sort an array with SHIT algorithm
     * For details around implementation, please refer - i
     *
     * @param arr array to sort
     */
    public static void sortHeuristicIntelligentTable(int[] arr) {

        //Create 10 buckets from 0-9 to
        ArrayList<Integer>[] buckets = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets based on the tens place
        for (int num : arr) {
            int tensPlace = num / 10;
            buckets[tensPlace].add(num);
        }

        // Sort each bucket
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Merge the sorted buckets back into the original array
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
