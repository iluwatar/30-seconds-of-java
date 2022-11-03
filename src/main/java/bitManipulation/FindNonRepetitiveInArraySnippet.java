package bitManipulation;

public class FindNonRepetitiveInArraySnippet {
    /**
     * find one non-repetitive number from array, when all other numbers repeat two time.
     * Note: XOR of same number will be zero
     *
     * @param numsArray array of numbers
     * @return non-repetitive number in array
     */
    public static int findNonRepetitiveInArray(int[] numsArray){
        if(numsArray==null) return 0;
        int nonRepetitiveNumber = 0;
        for(int num:numsArray){
            nonRepetitiveNumber = nonRepetitiveNumber ^ num;
        }
        return nonRepetitiveNumber;
    }
}
