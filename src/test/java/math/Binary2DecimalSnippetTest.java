package math;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;
 
/*
 * Tests for 30 Seconds of Java code library
 *
 */
class Binary2DecimalSnippetTest {
  /**
   * Tests for {@link Binary2DecimalSnippet#binaryToDecimal(int)}.
   */
  @Test
   void testLcm() {
    assertEquals(9, Binary2DecimalSnippet.binaryToDecimal(1001));
    assertEquals(10, Binary2DecimalSnippet.binaryToDecimal(1010));
    assertEquals(72, Binary2DecimalSnippet.binaryToDecimal(1001000));
    assertEquals(7, Binary2DecimalSnippet.binaryToDecimal(111));
  }
}
