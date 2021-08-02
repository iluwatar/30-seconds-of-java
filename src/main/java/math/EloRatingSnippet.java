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

/*
 * 30 Seconds of Java code library
 *
 */
public class EloRatingSnippet {
    /**
     * Elo rating adjustment. Returns new player rating based on the system
     * invented by Arpad Elo
     *
     * @param playerElo Current player rating
     * @param opponentElo Current opponent rating
     * @param score Score (1.0 win, 0.0 loss, 0.5 draw)
     * @param kFactor K-factor constant controls the sensitivity of rating updates
     * @return Adjusted elo rating
     */
    public static int eloAdjustment(int playerElo, int opponentElo, double score, double kFactor) {
        return (int)(playerElo + kFactor * (score - expectedWinProbability(playerElo, opponentElo)));
    }

    /**
     * Expected win probability. Returns the odds of a player winning based on elo comparisons
     *
     * @param playerElo Current player rating
     * @param opponentElo Current opponent rating
     * @return Expected win probability
     */
    public static double expectedWinProbability(int playerElo, int opponentElo) {
        return (1.0 / (1 + Math.pow(10.0, (opponentElo - playerElo) / 400.0)));
    }
}
