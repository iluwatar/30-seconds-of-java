package bitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapTwoNumbersSnippetTest {
    @Test
    void testSwapTwoNumbers(){
        Integer num1Actual = 3;
        Integer num2Actual = 8;


        Integer num1Expected = 8;
        Integer num2Expected = 3;

        Integer[] numbersAfterSwap = SwapTwoNumbersSnippet.swapTwoNumbers(num1Actual,num2Actual);
        num1Actual = numbersAfterSwap[0];
        num2Actual = numbersAfterSwap[1];
        Assertions.assertEquals(num1Expected,num1Actual);
        Assertions.assertEquals(num2Expected,num2Actual);
    }
}
