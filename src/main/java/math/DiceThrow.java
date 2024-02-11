/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
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

/**
 * Sum of Dice throw (Eg. 3d6 - 3 dice having 6 sides).
 */
public class DiceThrow {

  private static Random random = new Random();

  /**
  * Enum for standardized sided dice (4,6,8,10,12 and 20).
  */
  public enum DiceSides {

    FOUR(4), SIX(6), EIGHT(8), TEN(10), TWELVE(12), TWENTY(20);

    private final int diceSides;

    DiceSides(int diceSides) {
      this.diceSides = diceSides;
    }

    /**
     * Returns the number of sides of a dice.
     *
     * @return int denoting number of sides of a dice
     */
    public int getDiceSides() {
      return this.diceSides;
    }

  }

  /**
  * Returns the sum of sides for the given number of sides of each dice.
  *
  * @param noOfDice number of dice
  * @param sides sides of a dice
  * @return int sum of sides for number of dice
  */
  public static int throwDice(int noOfDice, DiceSides sides) {

    int sum = 0;
    for (int i = 0; i < noOfDice; i++) {
      sum = sum + (1 + random.nextInt(sides.getDiceSides()));
    }

    return sum;

  }

}