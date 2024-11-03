/*
 * MIT License
 *
 * Copyright (c) 2017-2024 Ilkka Seppälä
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

package string;

import java.util.Map;

/**
 * LSystemSnippet.
 */
public class LindenmayerSystemSnippet {
  /**
   * Generates an L-system string based on axiom, production rules, and a number of iterations.
   *
   * @param axiom           initial string to begin the L-system
   * @param productionRules map of character rules where each symbol can be replaced with a string
   * @param iterations      number of iterations to apply the production rules
   * @return the generated string after all iterations
   */
  public static String generateLindenmayerSystem(
          String axiom,
          Map<Character, String> productionRules,
          int iterations
  ) {
    String current = axiom;

    for (int i = 0; i < iterations; i++) {
      StringBuilder nextIteration = new StringBuilder(current.length() * 2);

      // Replace each symbol with the corresponding production rule or the symbol itself
      current.chars()
          .mapToObj(c -> (char) c)
          .forEach(symbol ->
                  nextIteration.append(
                          productionRules.getOrDefault(symbol, String.valueOf(symbol))
                  )
          );

      current = nextIteration.toString();
    }
    return current;
  }
}
