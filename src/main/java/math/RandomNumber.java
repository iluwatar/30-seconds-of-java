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
 * Random Number between given two values.
 * Supported Data types - Byte, Short, Integer, Long, Float and Double.
 */
public class RandomNumber {

  private static Random random = new Random();

  /**
  * Return a random number between two given numbers.
  *
  * @param start Starting point to find the random number
  * @param end Ending point to find the random number
  * @return Number denoting the random number generated
  */
  public static <T extends Number> Number getRandomNumber(T start, T end) {

    if ((start instanceof Byte && end instanceof Byte)) {
      return (byte) (start.byteValue() + random.nextInt(end.byteValue() - start.byteValue() + 1));
    } else if ((start instanceof Byte && end instanceof Byte) 
            || (start instanceof Short && end instanceof Short)) {
      return (short) (start.shortValue() 
              + random.nextInt(end.shortValue() - start.shortValue() + 1));
    } else if ((start instanceof Integer && end instanceof Integer)) {
      return (int) (start.intValue() 
              + random.nextInt(end.intValue() - start.intValue() + 1));
    } else if (start instanceof Long && end instanceof Long) {
      return (long) (start.longValue() 
              + random.nextLong(end.longValue() - start.longValue() + 1));
    } else if (start instanceof Float && end instanceof Float) {
      return (float) (start.floatValue() 
              + random.nextFloat(end.floatValue() - start.floatValue() + 1));
    } else if (start instanceof Double && end instanceof Double) {
      return (double) (start.doubleValue() 
              + random.nextDouble(end.doubleValue() - start.doubleValue() + 1));
    } else {
      throw new IllegalArgumentException("Invalid Numbers As Arguments " 
              + start.getClass() + " and " + end.getClass());
    }
  }

}
