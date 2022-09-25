package date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * 30 Seconds of Java code library.
 * AddDaysToDateSnippet
 *
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
