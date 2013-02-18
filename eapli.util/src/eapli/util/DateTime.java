/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

import java.util.Calendar;
import java.util.Date;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class DateTime {
        
    public static CalendarDate today() {
        CalendarSystem calendar = CalendarSystem.getGregorianCalendar();
        CalendarDate today = calendar.getCalendarDate();
        return today;
    }
    
    public static int weekNumber(CalendarDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getMillis());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static int weekNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    public static int currentWeekNumber() {       
        return weekNumber(today());
    }
    
    public static CalendarDate newCalendarDate(int year, int month, int day) {
        CalendarSystem calendar = CalendarSystem.getGregorianCalendar();
        CalendarDate date = calendar.getCalendarDate();
        date.setYear(year);
        date.setMonth(month);
        date.setDayOfMonth(day);
        return date;
    }
    
    public static Date newDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month-1, day);
        return c.getTime();
    }
}
