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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */

class DateDifferenceSnippetTest {

  /**
   * Tests for {@link DateDifferenceSnippet#getYearsDifference(LocalDate, LocalDate)},
   * {@link DateDifferenceSnippet#getMonthsDifference(LocalDate, LocalDate)},
   * {@link DateDifferenceSnippet#getDaysDifference(LocalDate, LocalDate)}.
   */
  @Test
  void testAddDaysToDate() {

    var date1 = LocalDate.of(1998, 9, 24);
    var date2 = LocalDate.of(2023, 3, 22);

    assertEquals(24, DateDifferenceSnippet.getYearsDifference(date1, date2));
    assertEquals(293, DateDifferenceSnippet.getMonthsDifference(date1, date2));
    assertEquals(8945, DateDifferenceSnippet.getDaysDifference(date1, date2));

  }


}
