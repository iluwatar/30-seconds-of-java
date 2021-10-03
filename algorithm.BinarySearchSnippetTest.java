package algorithm;

import java.util.Scanner;

import static algorithm.Binary_Search.binarySearch;

public class Binary_SearchTest {
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
