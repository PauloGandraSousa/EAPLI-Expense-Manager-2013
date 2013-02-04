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
    public void testIsOdd() {
        System.out.println("isOdd");
        int i = 0;
        boolean expResult = false;
        boolean result = Math.isOdd(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEven method, of class Math.
     */
    @Test
    public void testIsEven() {
        System.out.println("isEven");
        int i = 0;
        boolean expResult = false;
        boolean result = Math.isEven(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
