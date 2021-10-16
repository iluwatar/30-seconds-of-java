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

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 30 Seconds of Java code library
 *
 */
public class NaturalNumberBinaryConversionSnippet {

  /**
   * Convert natural number to binary string. Only supports positive integers.Throws exception
   * for negative integers
   *
   * @param naturalNumber given number
   * @return Binary string representation of naturalNumber
   */
  public static String toBinary(long naturalNumber) {
    if (naturalNumber < 0) {
      throw new NumberFormatException("Negative Integer, this snippet only accepts "
              + "positive integers");
    }
    if (naturalNumber == 0) {
      return "0";
    }
    final Stack<Long> binaryBits =
            Stream.iterate(naturalNumber, n -> n > 0, n -> n / 2).map(n -> n % 2)
                    .collect(Stack::new, Stack::push, Stack::addAll);
    return Stream.generate(binaryBits::pop)
            .limit(binaryBits.size()).map(String::valueOf).collect(Collectors.joining());
  }

  /**
   * Convert binary string representation to Long valued Integer. Throws exception if input
   * string contains characters other than '0' and '1'
   *
   * @param binary given number
   * @return Unsigned Long value for the binary number
   */
  public static Long fromBinary(String binary) {
    binary.chars().filter(c -> c != '0' && c != '1').findFirst().ifPresent(in -> {
      throw new NumberFormatException(
              "Binary string contains values other than '0' and '1'");
    });
    return IntStream.range(0, binary.length())
            .filter(in -> binary.charAt(binary.length() - 1 - in) == '1')
            .mapToLong(in -> ((long) 0b1) << in).sum();
  }

}
