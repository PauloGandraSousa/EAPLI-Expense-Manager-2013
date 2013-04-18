/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    final Date aprilFirst2013 = new Date(2013, 4, 01);

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

    /**
     * Test of sumAmount method, of class CheckingAccount.
     */
    @Test
    public void testSumAmount() {
        System.out.println("sumAmount");
        List<Movement> theMovements = new ArrayList<Movement>();
        ExpenseType expenseType = new ExpenseType("clothing", "Clothing");
        Expense expense = new Expense(expenseType, "a", aprilFirst2013, ONE);
        theMovements.add(expense);
        theMovements.add(expense);
        theMovements.add(expense);
        CheckingAccount instance = new CheckingAccount();
        BigDecimal expResult = new BigDecimal(3);
        BigDecimal result = instance.sumAmount(theMovements);
        assertEquals(expResult, result);
    }
}