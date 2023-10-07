package algorithm;

import java.util.Arrays;

public class BinarySearchIn2DArraySnippet {
    /**
     * Search an item with binarySearch algorithm.
     *
     * @param matrix It should be sorted
     * @param target     an item to search
     * @return if location of item is found, return the index position of the array item otherwise return -1,-1
     */

    public static int[] BinarySearchIn2Darr(int matrix[][], int target) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        if (rows == 1) {
            return BinarySearch(matrix, target, 0, 0, cols);
        }
        int rstart = 0, rend = rows;
        int cmid = cols / 2;

        //Run the loop till two rows are remaining
        while (rstart < rend - 1)  //while this is true , we will be having more than two rows
        {
            int rmid = rstart + (rend - rstart) / 2;

            if (matrix[rmid][cmid] > target)
                rend = rmid;
            else if (matrix[rmid][cmid] < target)
                rstart = rmid;
            else
                return new int[]{rmid, cmid};
        }
        //Now we have two Rows  remaining

        //1.  Check wheather middle col contains the ans
        if (matrix[rstart][cmid] == target)
            return new int[]{rstart, cmid};
        if (matrix[rend][cmid] == target)
            return new int[]{rend, cmid};

        //2.Consider 4 parts  search in that parts

        //search in 1st half
        if (target <= matrix[rstart][cmid - 1])
            return BinarySearch(matrix, target, rstart, 0, cmid - 1);

        //2nd half
        if (target >= matrix[rstart][cmid + 1])
            return BinarySearch(matrix, target, rstart, cmid + 1, cols);
        //3rd half
        if (target <= matrix[rend][cmid - 1])
            return BinarySearch(matrix, target, rend, 0, cmid - 1);
        //4th half
        if (target <= matrix[rend][cmid + 1])
            return BinarySearch(matrix, target, rend, cmid + 1, cols);


        return new int[]{-1, -1};
    }

    //Search in the specific Row provided between the col start and col end
    static int[] BinarySearch(int matrix[][], int target, int row, int cstart, int cend) {
        while (cstart <= cend) {
            int cmid = cstart + (cend - cstart) / 2;

            if (matrix[row][cmid] > target) {
                cend = cmid - 1;
            } else if (matrix[row][cmid] < target)
                cstart = cend + 1;
            else
                return new int[]{row, cmid};
        }
        return new int[]{-1, -1};

    }

}
