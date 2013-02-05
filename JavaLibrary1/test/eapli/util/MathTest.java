/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

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
}
