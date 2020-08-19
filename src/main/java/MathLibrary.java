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

import java.util.ArrayList;

import java.util.Collections;

public class MathLibrary {
  /**
   * Factorial. Works only for small numbers
   *
   * @param number for which factorial is to be calculated for
   * @return factorial
   */
  public static int factorial(int number) {
    var result = 1;
    for (var factor = 2; factor <= number; factor++) {
      result *= factor;
    }
    return result;
  }

  /**
   * Recursive Fibonacci series. Works only for small n and is spectacularly inefficient
   *
   * @param n given number
   * @return fibonacci number for given n
   */
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  /**
   * Generate random lottery numbers.
   *
   * @param numNumbers    how many performLottery numbers are available (e.g. 49)
   * @param numbersToPick how many numbers the player needs to pick (e.g. 6)
   * @return array with the random numbers
   */
  public static Integer[] performLottery(int numNumbers, int numbersToPick) {
    var numbers = new ArrayList<Integer>();
    for (var i = 0; i < numNumbers; i++) {
      numbers.add(i + 1);
    }
    Collections.shuffle(numbers);
    return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
  }

  /**
   * Greatest common divisor calculation.
   *
   * @param a one of the numbers whose gcd is to be computed
   * @param b other number whose gcd is to be computed
   * @return gcd of the two numbers
   */
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
   * Checks if given number is a prime number. Prime number is a number that is greater than 1 and
   * divided by 1 or itself only Credits: https://en.wikipedia.org/wiki/Prime_number
   *
   * @param number number to check prime
   * @return true if prime
   */
  public static boolean isPrime(int number) {
    if (number < 3) {
      return true;
    }
    // check if n is a multiple of 2
    if (number % 2 == 0) {
      return false;
    }
    // if not, then just check the odds
    for (var i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
