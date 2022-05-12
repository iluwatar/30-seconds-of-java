package date;

import java.util.Date;

public class DateInRange {
    /**
     * Check if a certain date is between two dates.
     *
     */
    public static boolean isDateInRange(Date startDate, Date endDate , Date dateToCheck) {
        return !(dateToCheck.before(startDate) || dateToCheck.after(endDate));
    }

}
