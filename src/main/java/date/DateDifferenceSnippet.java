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

package date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * DateDifferenceSnippet.
 */

public class DateDifferenceSnippet {

  /**
  * This function calculates the number of years between two LocalDate objects.
  * If the result is negative, it returns the absolute value of the difference.
  *
  * @param firstTime  The first LocalDate object representing the starting date
  * @param secondTime The second LocalDate object representing the ending date
  * @return The number of years between the two LocalDate objects as a long data type
  */
  public static long getYearsDifference(LocalDate firstTime, LocalDate secondTime) {
    var yearsDifference = ChronoUnit.YEARS.between(firstTime, secondTime);
    return Math.abs(yearsDifference);
  }

  /**
   * This function calculates the number of months between two LocalDate objects.
   * If the result is negative, it returns the absolute value of the difference.
   *
   * @param firstTime  The first LocalDate object representing the starting date
   * @param secondTime The second LocalDate object representing the ending date
   * @return The number of months between the two LocalDate objects as a long data type
   */
  public static long getMonthsDifference(LocalDate firstTime, LocalDate secondTime) {
    var monthsDifference = ChronoUnit.MONTHS.between(firstTime, secondTime);
    return Math.abs(monthsDifference);
  }

  /**
   * This function calculates the number of days between two LocalDate objects.
   * If the result is negative, it returns the absolute value of the difference.
   *
   * @param firstTime  The first LocalDate object representing the starting date
   * @param secondTime The second LocalDate object representing the ending date
   * @return The number of days between the two LocalDate objects as a long data type
   */
  public static long getDaysDifference(LocalDate firstTime, LocalDate secondTime) {
    var daysDifference = ChronoUnit.DAYS.between(firstTime, secondTime);
    return Math.abs(daysDifference);
  }


}
