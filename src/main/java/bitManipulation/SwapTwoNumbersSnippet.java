package bitManipulation;

public class SwapTwoNumbersSnippet {
    /**
     * Swap numbers without third variable.
     *
     * @param num1 number1
     * @param num2 number2
     * @return array of swap numbers
     */
    public static Integer[] swapTwoNumbers(Integer num1,Integer num2){
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        return new Integer[]{num1, num2};
    }
}
