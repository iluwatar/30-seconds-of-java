package math;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;
 
/*
 * Tests for 30 Seconds of Java code library
 *
 */
class Binary2DecimalSnippetTest {
  /**
   * Tests for {@link Decimal2BinarySnippet#decimalToBinary(int)}.
   */
  @Test
   void testLcm() {
    assertEquals(1001, Decimal2BinarySnippet.decimalToBinary(9));
    assertEquals(1010, Decimal2BinarySnippet.decimalToBinary(10));
    assertEquals(1001000, Decimal2BinarySnippet.decimalToBinary(72));
    assertEquals(111, Decimal2BinarySnippet.decimalToBinary(7));
  }
}
