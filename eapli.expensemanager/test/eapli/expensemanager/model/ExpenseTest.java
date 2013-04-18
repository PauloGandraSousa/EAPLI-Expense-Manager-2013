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

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTest {
    
        final BigDecimal ONE = new BigDecimal(1);
    final BigDecimal MINUS_ONE = new BigDecimal(-1);

    public ExpenseTest() {
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

        @Test(expected = IllegalArgumentException.class)
    public void testNegativeAmmountExpensesAreNotAllowed() {
        Expense expense = new Expense(new ExpenseType(), "aaa", new Date(), MINUS_ONE, new Payment(new Cash()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullExpenseTypesAreNotAllowed() {
        Expense expense = new Expense(null, "aaa", new Date(), ONE, new Payment(new Cash()));
    }
}