/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eapli.expensemanager.model.exceptions.InsufficientBalanceException;
import eapli.util.DateTime;
import java.util.Calendar;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class CheckingAccountTest {

    final BigDecimal ONE = new BigDecimal(1);
    final BigDecimal MINUS_ONE = new BigDecimal(-1);
    final Calendar aprilFirst2013 = DateTime.newCalendar(2013, 4, 01);

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
     *
     * @throws InsufficientBalanceException
     */
    @Test
    public void testTotalExpenditure() throws InsufficientBalanceException {
        CheckingAccount anAccount = new CheckingAccount();

        IncomeType salario = new IncomeType("sal", "salario");
        Income income = new Income("salario", aprilFirst2013, new BigDecimal(
                1000), salario);
        anAccount.registerIncome(income);

        ExpenseType expenseType = new ExpenseType("clothing", "Clothing");
        Expense expense = new Expense(expenseType, "a", aprilFirst2013, ONE,
                                      new Payment(new Cash()));
        anAccount.registerExpense(expense);
        anAccount.registerExpense(expense);
        anAccount.registerExpense(expense);

        BigDecimal expResult = new BigDecimal(3);
        BigDecimal result = anAccount.totalExpenditure();
        assertEquals(expResult, result);
    }
}
