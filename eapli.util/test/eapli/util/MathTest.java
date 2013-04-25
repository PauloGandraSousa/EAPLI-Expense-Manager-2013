/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

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
public class MathTest {
    
    public MathTest() {
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
     * Test of isOdd method, of class Math.
     */
    @Test
    public void testTwoIsNotOdd() {
        System.out.println("twoIsNotOdd");
        int i = 2;
        boolean expResult = false;
        boolean result = Math.isOdd(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of isOdd method, of class Math.
     */    @Test
    public void testOneIsOdd() {
        System.out.println("oneIsOdd");
        int i = 1;
        boolean expResult = true;
        boolean result = Math.isOdd(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEven method, of class Math.
     */
    @Test
    public void testTwoIsEven() {
        System.out.println("twoIsEven");
        int i = 2;
        boolean expResult = true;
        boolean result = Math.isEven(i);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEven method, of class Math.
     */
    @Test
    public void testOneIsNotEven() {
        System.out.println("oneIsNotEven");
        int i = 1;
        boolean expResult = false;
        boolean result = Math.isEven(i);
        assertEquals(expResult, result);
    }
    
      /**
     * Test of simpleLinearConversion method, of class
     * ListExpensesUIPerTypeTextChart.
     */
    @Test
    public void testSimpleLinearConversion1() {
        System.out.println("simpleLinearConversion");
        float oldMin = 0.0F;
        float oldMax = 100.0F;
        float newMin = 0.0F;
        float newMax = 10.0F;
        float oldValue = 50.0F;
        float expResult = 5.0F;
        float result = Math.simpleLinearConversion(oldMin, oldMax, newMin, newMax, oldValue);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of simpleLinearConversion method, of class
     * ListExpensesUIPerTypeTextChart.
     */
    @Test
    public void testSimpleLinearConversion2() {
        System.out.println("simpleLinearConversion");
        float oldMin = 0.0F;
        float oldMax = 575.0F;
        float newMin = 0.0F;
        float newMax = 10.0F;
        float oldValue = 575.0F;
        float expResult = 10.0F;
        float result = Math.simpleLinearConversion(oldMin, oldMax, newMin, newMax, oldValue);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of simpleLinearConversion method, of class
     * ListExpensesUIPerTypeTextChart.
     */
    @Test
    public void testSimpleLinearConversion3() {
        System.out.println("simpleLinearConversion");
        float oldMin = 0.0F;
        float oldMax = 575.0F;
        float newMin = 0.0F;
        float newMax = 10.0F;
        float oldValue = 355.0F;
        float expResult = 355.0F/575.0F*10;
        float result = Math.simpleLinearConversion(oldMin, oldMax, newMin, newMax, oldValue);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of simpleLinearConversion2 method, of class
     * ListExpensesUIPerTypeTextChart.
     */
    @Test
    public void testSimpleLinearConversion_BigDecimal1() {
        System.out.println("simpleLinearConversion2");
        BigDecimal oldMin = new BigDecimal(0);
        BigDecimal oldMax = new BigDecimal(100);
        BigDecimal newMin = new BigDecimal(0);
        BigDecimal newMax = new BigDecimal(10);
        BigDecimal oldValue = new BigDecimal(50);
        BigDecimal expResult = new BigDecimal(5.0);
        BigDecimal result = Math.simpleLinearConversion(oldMin, oldMax, newMin, newMax, oldValue);
        assertEquals(expResult.doubleValue(), result.doubleValue(), 0);

    }

    /**
     * Test of simpleLinearConversion2 method, of class
     * ListExpensesUIPerTypeTextChart.
     */
    @Test
    public void testSimpleLinearConversion_BigDecimal2() {
        System.out.println("simpleLinearConversion2");
        BigDecimal oldMin = new BigDecimal(0);
        BigDecimal oldMax = new BigDecimal(575);
        BigDecimal newMin = new BigDecimal(0);
        BigDecimal newMax = new BigDecimal(10);
        BigDecimal oldValue = new BigDecimal(575);
        BigDecimal expResult = new BigDecimal(10.0);
        BigDecimal result = Math.simpleLinearConversion(oldMin, oldMax, newMin, newMax, oldValue);
        assertEquals(expResult.doubleValue(), result.doubleValue(), 0);

    }

    /**
     * Test of simpleLinearConversion2 method, of class
     * ListExpensesUIPerTypeTextChart.
     */
    @Test
    public void testSimpleLinearConversion_BigDecimal3() {
        System.out.println("simpleLinearConversion2");
        BigDecimal oldMin = new BigDecimal(0);
        BigDecimal oldMax = new BigDecimal(575);
        BigDecimal newMin = new BigDecimal(0);
        BigDecimal newMax = new BigDecimal(10);
        BigDecimal oldValue = new BigDecimal(355);
        BigDecimal expResult = new BigDecimal(6.0);
        BigDecimal result = Math.simpleLinearConversion(oldMin, oldMax, newMin, newMax, oldValue);
        assertEquals(expResult.doubleValue(), result.doubleValue(), 0);

    }
}
