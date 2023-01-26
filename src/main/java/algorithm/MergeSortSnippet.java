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
