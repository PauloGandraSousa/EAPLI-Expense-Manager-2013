/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class DateTime {

    public static Calendar today() {
        Calendar today = new GregorianCalendar();
        return today;
    }

    public static int weekNumber(Calendar date) {
        return date.get(Calendar.WEEK_OF_YEAR);
    }

    public static int weekNumber(Date date) {
        return weekNumber(dateToCalendar(date));
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static int currentWeekNumber() {
        return weekNumber(today());
    }

    public static Calendar newCalendarDate(int year, int month, int day) {
        Calendar date = new GregorianCalendar(year, month, day);
        return date;
    }

    public static Date newDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return c.getTime();
    }

    public static Date parseDate(String aDateString, String format) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date = df.parse(aDateString);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Date parseDate(String aDateString) {
        return parseDate(aDateString, "dd-MM-yyyy");
    }
}
