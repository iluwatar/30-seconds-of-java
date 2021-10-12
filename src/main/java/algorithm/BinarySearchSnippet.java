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
public class BinarySearchSnippet {
    /**
    *Sorted Array will be given and element will be found
    *
    * @param arr array to be searched
    * @param l first index
    * @param r last index
    * @param x element to be searched
    * @return index where x is found in arr or -1
    */
    public static int binarySearch(int[] arr,int l,int r,int x){

        if (r >= l) {
            int mid = l + (r - l) / 2;

          
            if (arr[mid] == x)
                return mid+1;

           
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

           
            return binarySearch(arr, mid + 1, r, x);
        }

       
        return -1;
    }
}
