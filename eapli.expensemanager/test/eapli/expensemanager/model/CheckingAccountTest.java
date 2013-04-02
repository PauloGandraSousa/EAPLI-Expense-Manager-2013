/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.Date;
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
public class CheckingAccountTest {
    
    final BigDecimal ONE = new BigDecimal(1);
    final BigDecimal MINUS_ONE = new BigDecimal(-1);
    final Date aprilFirst2013 = new Date(2013-1900, 3, 01);
    
    public CheckingAccountTest() {
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
    
    @Test
    public void testNewAccountHasNoExpenses()  {
        CheckingAccount instance = new CheckingAccount();
        BigDecimal expResult = new BigDecimal(0);
        BigDecimal result = instance.totalExpenditure();
        assertEquals(expResult, result);
    }

    @Test
    public void testNewAccountHasNoIncomes()  {
        CheckingAccount instance = new CheckingAccount();
        BigDecimal expResult = new BigDecimal(0);
        BigDecimal result = instance.totalEarnings();
        assertEquals(expResult, result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNullExpensesAreNotAllowed() {
        System.out.println("registerExpense");
        Expense expense = null;
        CheckingAccount instance = new CheckingAccount();
        instance.registerExpense(expense);
    }

}