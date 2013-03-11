/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.util.calendar.CalendarDate;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class DateTimeTest {
    
    public DateTimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of today method, of class DateTime.
     */
    @Test
    public void testToday() {
        System.out.println("today");
        Calendar expResult = null;
        Calendar result = DateTime.today();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of weekNumber method, of class DateTime.
     */
    @Test
    public void testWeekNumber() {
        System.out.println("weekNumber");
        Calendar date = DateTime.newCalendarDate(2013, 01, 01);
        int expResult = 1;
        int result = DateTime.weekNumber(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of currentWeekNumber method, of class DateTime.
     */
    @Test
    public void testCurrentWeekNumber() {
        System.out.println("currentWeekNumber");
        int expResult = 0;
        int result = DateTime.currentWeekNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newCalendarDate method, of class DateTime.
     */
    @Test
    public void testNewCalendarDate() {
        System.out.println("newCalendarDate");
        int year = 0;
        int month = 0;
        int day = 0;
        Calendar expResult = null;
        Calendar result = DateTime.newCalendarDate(year, month, day);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
