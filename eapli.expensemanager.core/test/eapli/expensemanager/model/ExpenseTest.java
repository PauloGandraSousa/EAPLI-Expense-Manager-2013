/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.util.DateTime;
import java.math.BigDecimal;

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
        new Expense(new ExpenseType(), "aaa", DateTime.today(), MINUS_ONE,
                    new Payment(new Cash()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullExpenseTypesAreNotAllowed() {
        new Expense(null, "aaa", DateTime.today(), ONE, new Payment(new Cash()));
    }
}
