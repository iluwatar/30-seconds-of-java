package math;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {

    void test_sqrt()
    {
        assertEquals(6.0,SquareRoot.sqrt(36,1));
        assertEquals(6.324555319999993,SquareRoot.sqrt(40,9));
        assertEquals(6.707999999999995,SquareRoot.sqrt(45,3));
        assertEquals(9.529999999999982,SquareRoot.sqrt(91,2));

    }
}
