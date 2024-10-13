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

/**
 * EloRatingSnippet.
 */
public class EloRatingSnippet {

  static final int BASE = 400; //Two types are popular - 400 and 480. We will choose 400 here
  static final int RATING_ADJUSTMENT_FACTOR = 32; //32 is the standard for Beginner Games

  /**
   * Elo Rating Snippet to calculate result after a single match.
   *
   * @param firstPlayerRating Rating of the first player.
   * @param secondPlayerRating Rating of the second player.
   * @param result Result of the match, always considered with respect to the first player.
   *               1 indicates a win, 0.5 indicates a draw and 0 indicates a loss.
   * @return Returns the new rating of the first player.
   */
  public static double calculateMatchRating(double firstPlayerRating, double secondPlayerRating,
      double result) {
    double ratingDiff = ((secondPlayerRating - firstPlayerRating) * 1.0) / BASE;
    double logisticDiff = Math.pow(10, ratingDiff);
    double firstPlayerExpectedScore = 1.0 / (1 + logisticDiff);
    double firstPlayerActualScore = result;
    double newRating = firstPlayerRating + RATING_ADJUSTMENT_FACTOR * (firstPlayerActualScore 
                       - firstPlayerExpectedScore);
    return newRating;
  }
}
