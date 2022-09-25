package date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class AddDaysToDateSnippet {
    public static Date addDaysToDate(Date date, int noOfDays){
        if(date!=null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, noOfDays);
            return cal.getTime();
        }
        return null;
    }

    public static LocalDate addDaysToLocalDate(LocalDate date, long noOfDays){
        return date!=null ? date.plusDays(noOfDays) : null;
    }
}
