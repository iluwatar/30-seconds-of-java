package algorithm;

import java.util.Arrays;

/**
 * Search an item with linearSearch algorithm.
 *
 * @param arr    array to search
 * @param target an item to search
 * @return if location of target is found, return the index position of the array item otherwise return -1,-1
 */
public class LinearSearchIn2DArraySnippet {
    public static int[] LinearSearchIn2DArray(int arr[][], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

}
