/*
 * MIT License
 *
 * Copyright (c) 2017-2023 Ilkka Seppälä
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

  static final double DELTA = 0.01; // Add tolerance for floating point calculations

  /**
   * Tests for {@link #calculateMatchRating(double, double, double)}.
   */
  @Test
  void testSingleMatchRatings() {

    //No rating change for draw between players of equal strength
    assertEquals(1500.0, EloRatingSnippet.calculateMatchRating(1500, 1500, 0.5), DELTA);

    //For a win against a very very high leveled player, we should get max points
    assertEquals(1532.0, EloRatingSnippet.calculateMatchRating(1500, 3000, 1.0), DELTA);

    //For a loss against a very very low leveled player, we should lose max points
    assertEquals(2968.0, EloRatingSnippet.calculateMatchRating(3000, 1500, 0.0), DELTA);
  }

  @Test
  void testTournamentRatings() {

    //Simulate a tournament, using data from wikipedia
    double initialRating = 1613.0;
    double expectedFinalRating = 1601.0; 
    double newRating = EloRatingSnippet.calculateMatchRating(initialRating, 1609.0, 0); // Loss

    //Match 2
    newRating = EloRatingSnippet.calculateMatchRating(newRating, 1477.0, 0.5); //Draw

    //Match 3
    newRating = EloRatingSnippet.calculateMatchRating(newRating, 1388.0, 1.0); //Win

    //Match 4
    newRating = EloRatingSnippet.calculateMatchRating(newRating, 1586.0, 1.0); //Win

    //Match 5
    newRating = EloRatingSnippet.calculateMatchRating(newRating, 1720.0, 0.0); //Loss

    assertEquals(expectedFinalRating, initialRating, DELTA);
  }
}