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
 * MergeSortSnippet.
 */

public class MergeSortSnippet {

 /**
   * Sort an array with quicksort algorithm.
   *
   * @param arr   array to sort
   * @param left  left index where to begin sort (e.g. 0)
   * @param right right index where to end sort (e.g. array length - 1)
   */

    public static void mergeSort(int arr[], int low, int high){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high, mid);
    }

    private static void merge(int[] arr, int low, int high, int mid) {
        int temp[] = new int[(high-low+1)];
        int i = low;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i];
                i++;
            }

            else{
                temp[k++] = arr[j];
                j++;
            }
        }

        while(i<=mid){
            temp[k++] = arr[i];
            i++;
        }

        while(j<=high){
            temp[k++] = arr[j];
            j++;
        }

        for(int m=0, n=low; m<temp.length; m++, n++){
            arr[n] = temp[m];
        }
    }
}
