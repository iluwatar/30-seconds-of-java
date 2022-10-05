package array;

public class MinimumElementSnippet {

    /**
     * Returns minimum element of the array
     * @param array , the array of integers
     * @return minimum element of an array
     */



    public static int findMin(int[] array){
        int min = array[0];
        for(int i = 1; i<array.length;i++){
            if(min>array[i]){
                min = array[i];
            }
        }
        return min;
    }
}
