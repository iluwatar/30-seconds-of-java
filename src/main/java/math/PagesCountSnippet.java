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
public class PagesCountSnippet {
  /**
   * Pages Count function. Calculates how many pages required to fit items depending on page size
   *
   * @param numberOfObjects total items to split onto pages
   * @param pageSize how many items 1 page can fit
   * @return pages count
   * @throws IllegalArgumentException if pageSize <=0
   */
  public static int pagesCount(int numberOfObjects, int pageSize) throws IllegalArgumentException {
    if (pageSize <= 0) {
      throw new IllegalArgumentException("Page Size should be greater than 0");
    }
    return numberOfObjects / pageSize + (numberOfObjects % pageSize == 0 ? 0 : 1);
  }
}
