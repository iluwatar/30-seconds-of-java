package math;

import array.FindMaxSnippet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenOddTest {

    void test_evenOdd()
    {
        assertEquals("even", EvenOdd.evenodd(4));
        assertEquals("even", EvenOdd.evenodd(0));
        assertEquals("odd", EvenOdd.evenodd(97));
        assertEquals("even", EvenOdd.evenodd(-96662));
        assertEquals("odd", EvenOdd.evenodd(1));
    }
}
