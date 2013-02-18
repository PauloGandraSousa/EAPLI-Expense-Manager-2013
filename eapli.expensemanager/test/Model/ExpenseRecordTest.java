/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseRecordTest {
    
    public ExpenseRecordTest() {
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
     * Test of register method, of class ExpenseRecord.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Expense expense = null;
        ExpenseRecord instance = ExpenseRecord.instance();
        instance.register(expense);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThisWeekBalance method, of class ExpenseRecord.
     */
    @Test
    public void testGetThisWeekBalance() {
        System.out.println("getThisWeekBalance");
        ExpenseRecord instance = ExpenseRecord.instance();
        BigDecimal expResult = null;
        BigDecimal result = instance.getThisWeekBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThisMonthBalance method, of class ExpenseRecord.
     */
    @Test
    public void testGetThisMonthBalance() {
        System.out.println("getThisMonthBalance");
        ExpenseRecord instance = ExpenseRecord.instance();
        BigDecimal expResult = null;
        BigDecimal result = instance.getThisMonthBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class ExpenseRecord.
     */
    @Test
    public void testRegister10GetTotal10() {
        System.out.println("getTotal");
        ExpenseRecord instance = ExpenseRecord.instance();
                
        BigDecimal expResult = new BigDecimal(10);
        
        instance.register(new Expense(ExpenseTypes.CLOTHING, "", 2013, 2, 17, expResult));
        
        BigDecimal result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class ExpenseRecord.
     */
    @Test
    public void testRegister2x10GetTotal20() {
        System.out.println("getTotal");
        ExpenseRecord instance = ExpenseRecord.instance();
        
        instance.register(new Expense(ExpenseTypes.CLOTHING, "1", 2013, 2, 17, new BigDecimal(10)));
        instance.register(new Expense(ExpenseTypes.CLOTHING, "2", 2013, 2, 17, new BigDecimal(10)));
        
        BigDecimal expResult = new BigDecimal(20);
        BigDecimal result = instance.getTotal();
        assertEquals(expResult, result);
    }
}
