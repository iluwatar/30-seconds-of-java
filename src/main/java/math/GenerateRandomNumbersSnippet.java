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

import java.util.Random;

/*
 * 30 Seconds of Java code library
 *
 */
public class GenerateRandomNumbersSnippet {
    private static Random random = new Random();

    /**
     * Generate a random number between x (inclusive) and y (inclusive)
     *
     * @param x left bound
     * @param y right bound
     * @return random integer between x and y
     */
    public static int generateRandomNumberBetweenXAndY(int x, int y) {
        int exclusiveRightBound = y - x + 1;
        return random.nextInt(exclusiveRightBound) + x;
    }

    /**
     * Throw dice (3d6)
     *
     * @return random integer between 1 and 6 (inclusive)
     */
    public static int throwDice() {
        return random.nextInt(5) + 1;
    }
}
