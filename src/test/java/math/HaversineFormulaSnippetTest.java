/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class HaversineFormulaSnippetTest {

  /**
   * Tests for {@link HaversineFormulaSnippet#findHaversineDistance(double, double, double,
   * double)}.
   */
  @Test
  void testFindHaversineDistance() {
    var distance1 = HaversineFormulaSnippet
        .findHaversineDistance(28.7041, 77.1025, 30.9661, 76.5231);
    assertEquals(257.7, distance1, 0.1);

    var distance2 = HaversineFormulaSnippet
        .findHaversineDistance(
            -17.947826, 177.221232, -16.603513, -179.779055
     );
    assertEquals(351.9, distance2, 0.1);
  }

  // Test for out of range inputs, as latitudes should be in range [-90,90] and longitudes in
  // [-180,180]
  @Test
  void testFindHaversineDistanceInvalidRange() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> {
          HaversineFormulaSnippet.findHaversineDistance(666, 0, 0, 0);
        });
  }
}
