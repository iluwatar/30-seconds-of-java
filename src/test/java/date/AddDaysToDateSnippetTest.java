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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for AddDaysToDateSnippet.
 */
public class AddDaysToDateSnippetTest {

  /**
  * Test add days to date.
  *
  * @throws ParseException if date can't be parsed
  *
  */
  @Test
  void testAddDaysToDate() throws ParseException {
    DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

    String dateStr = "January 1, 2022";
    Date date = format.parse(dateStr);

    String dateStrAfter = "January 3, 2022";
    Date dateAfterTwoDaysExpected = format.parse(dateStrAfter);

    Date dateAfterTwoDaysActual = AddDaysToDateSnippet.addDaysToDate(date, 2);
    Assertions.assertEquals(dateAfterTwoDaysExpected, dateAfterTwoDaysActual);
  }

  /**
  * Test add days to local date.
  */
  @Test
  void testAddDaysToLocalDate() {
    LocalDate date = LocalDate.now();
    LocalDate dateAfterTwoDaysExpected = date.plusDays(2);

    LocalDate dateAfterTwoDaysActual = AddDaysToDateSnippet.addDaysToLocalDate(date, 2);
    Assertions.assertEquals(dateAfterTwoDaysExpected, dateAfterTwoDaysActual);
  }
}
