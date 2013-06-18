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

/**
 * 
 * @author Paulo Gandra Sousa
 */
public final class DateTime {

	private DateTime() {
	}

	public static Calendar today() {
		return new GregorianCalendar();
	}

	public static int weekNumber(final Calendar date) {
		return date.get(Calendar.WEEK_OF_YEAR);
	}

	public static int weekNumber(final Date date) {
		return weekNumber(dateToCalendar(date));
	}

	public static Calendar dateToCalendar(final Date date) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static int currentWeekNumber() {
		return weekNumber(today());
	}

	public static Calendar beginningOfWeek(final int year, final int week) {
		final Calendar date = new GregorianCalendar();
		date.clear();
		date.set(Calendar.YEAR, year);
		date.set(Calendar.WEEK_OF_YEAR, week);
		return date;
	}

	private static final int DAYS_TILL_END_OF_WEEK = 6;

	public static Calendar endOfWeek(final int year, final int week) {
		final Calendar date = beginningOfWeek(year, week);
		date.add(Calendar.DATE, DAYS_TILL_END_OF_WEEK);
		return date;
	}

	public static Calendar endOfCurrentMonth() {
		return endOfMonth(today());
	}

	public static Calendar endOfMonth(final Calendar reference) {
		final Calendar lastDay = new GregorianCalendar();
		lastDay.setTime(reference.getTime());
		final int last = lastDay.getActualMaximum(Calendar.DAY_OF_MONTH);
		lastDay.set(Calendar.DAY_OF_MONTH, last);
		return lastDay;
	}

	public static Calendar endOfMonth(int year, int month) {
		Calendar date = new GregorianCalendar(year, month - 1, 1);
		return endOfMonth(date);
	}

	public static int currentYear() {
		return today().get(Calendar.YEAR);
	}

	/**
	 * returns the current month of the year
	 * 
	 * @return current month (1 - 12) of the year
	 */
	public static int currentMonth() {
		return today().get(Calendar.MONTH) + 1;
	}

	/**
	 * Creates a new Calendar object set to a specific date
	 * 
	 * @param year
	 *            the year
	 * @param month
	 *            the month (1 - 12)
	 * @param day
	 *            the day of the month
	 * @return a newly create Calendar object
	 */
	public static Calendar newCalendar(final int year, final int month,
			final int day) {
		return new GregorianCalendar(year, month - 1, day);
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
			Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return null;
	}

	public static Date parseDate(String aDateString) {
		return parseDate(aDateString, "dd-MM-yyyy");
	}

	public static String format(Date dateOcurred) {
		return dateOcurred.toLocaleString();
	}
}
