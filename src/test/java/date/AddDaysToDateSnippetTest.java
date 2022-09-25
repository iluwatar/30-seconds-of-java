package date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class AddDaysToDateSnippetTest {
    @Test
    void testAddDaysToDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

        String dateStr = "January 1, 2022";
        Date date = format.parse(dateStr);

        String dateStrAfter = "January 3, 2022";
        Date dateAfterTwoDaysExpected = format.parse(dateStrAfter);

        Date dateAfterTwoDaysActual = AddDaysToDateSnippet.addDaysToDate(date,2);
        Assertions.assertEquals(dateAfterTwoDaysExpected,dateAfterTwoDaysActual);
    }

    @Test
    void testAddDaysToLocalDate(){
        LocalDate date = LocalDate.now();
        LocalDate dateAfterTwoDaysExpected = date.plusDays(2);

        LocalDate dateAfterTwoDaysActual = AddDaysToDateSnippet.addDaysToLocalDate(date,2);
        Assertions.assertEquals(dateAfterTwoDaysExpected,dateAfterTwoDaysActual);
    }

}
