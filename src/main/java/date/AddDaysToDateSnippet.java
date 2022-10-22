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

package date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * AddDaysToDateSnippet.
 */
public class AddDaysToDateSnippet {

  /**
   * Add days to given date.
   *
   * @param date given date
   * @param noOfDays number of days to add
   * @return modified date
   */
  public static Date addDaysToDate(Date date, int noOfDays) {
    if (date != null) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DAY_OF_MONTH, noOfDays);
      return cal.getTime();
    }
    return null;
  }

  /**
   * Add days to local date.
   *
   * @param date given local date
   * @param noOfDays number of days to add
   * @return modified date
   */
  public static LocalDate addDaysToLocalDate(LocalDate date, long noOfDays) {
    return date != null ? date.plusDays(noOfDays) : null;
  }
}
