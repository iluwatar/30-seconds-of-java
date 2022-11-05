package bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindNonRepetitiveInArraySnippetTest {
    @Test
    void testFindNonRepetitiveInArray(){
        int[] numArray = {1,3,4,3,2,4,1};
        int numExpected = 2;
        int numActual = FindNonRepetitiveInArraySnippet.findNonRepetitiveInArray(numArray);
        Assertions.assertEquals(numExpected,numActual);
    }
}
