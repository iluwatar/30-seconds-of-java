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
import java.util.Scanner;

import static algorithm.BinarySearchSnippet.binarySearch;

public class BinarySearchSnippetTest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n;
        System.out.println("Enter the number of elements in array :: ");
        n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements .");
        for(int i=0;i<n;i++){
            int a;
            a=sc.nextInt();
            arr[i]=a;
        }
        System.out.println("Enter the element to be searched :: ");
        int x=sc.nextInt();
        int i=  binarySearch(arr,0,arr.length-1,x);
        System.out.println("Element found at ::"+(i+1));


    }
}
