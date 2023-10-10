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
 * HeapSortSnippet.
 */
public class HeapSortSnippet {
    /**
   * Sorts an array using heapSort algorithm.
   *
   * @param arr array to be sort
   */
    public static void heapSort(int arr[])
    {
        int n = arr.length;
 
        for(int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        for(int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    /**
    * Heapifies a subtree rooted with node i which is an
    * index in arr
    * 
    * @param arr : array to be sort
    * @param n : size of the array
    * @param i : index which is the root of the subtree to be heapified
    */
    private static void heapify(int arr[], int n, int i)
    {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
 
        if (left < n && arr[left] > arr[largest])
            largest = left;
 
        if (right < n && arr[right] > arr[largest])
            largest = right;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, n, largest);
        }
    }
}