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

import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class EloRatingSnippetTest {
  /**
   * Tests for EloRatingSnippet. {@link EloRatingSnippet#eloAdjustment(int,int,double,double)}
   */
  @Test
  void testEloRating() {
    assertEquals(1400, EloRatingSnippet.eloAdjustment(1400, 1400, 0.5, 32));
    assertEquals(1416, EloRatingSnippet.eloAdjustment(1400, 1400, 1.0, 32));
    assertEquals(1384, EloRatingSnippet.eloAdjustment(1400, 1400, 0.0, 32));
    assertEquals(1885, EloRatingSnippet.eloAdjustment(1900, 1400, 0.5, 32));
    assertEquals(1901, EloRatingSnippet.eloAdjustment(1900, 1400, 1.0, 32));
    assertEquals(1869, EloRatingSnippet.eloAdjustment(1900, 1400, 0.0, 32));
  }
}