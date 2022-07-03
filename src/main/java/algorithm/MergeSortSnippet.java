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

package algorithm;
/*
 * 30 Seconds of Java code library
 *
 */
import java.util.Arrays;


class MergeSortSnippet{
    /**
     * Sort an array with mergeSort algorithm.
     *
     * @param arr array to sort
     */
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);

    }
    // the below code is to just merge 2 sorted array in such a way that the resultant is also a sorted array.
    public static int[] merge(int[] arr1, int [] arr2){
        int[] mergedArray = new int[arr1.length + arr2.length];
        int a = 0; 
        int b = 0;
        int c = 0;
        // if none of them is empty so we have to compare elements and then place it
        while(a< arr1.length && b< arr2.length){
            if(arr1[a]< arr2[b]){
                mergedArray[c++] = arr1[a++];
            }else{
                mergedArray[c++] = arr2[b++];
            }
        }
        // if any of the array is empty so we just have to place another remaining array before that

        // if array 2 is empty
        while(a< arr1.length){
            mergedArray[c++] = arr1[a++];
        }

        // if array 1 is empty
        while(b< arr2.length){
            mergedArray[c++] = arr2[b++];
        }

        return mergedArray;
    }
} 