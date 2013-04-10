/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class Math {
    /**
     * determines if a number is odd
     * 
     * @param i
     * @return 
     */
    public static boolean isOdd(int i) { return i % 2 != 0; }
    
    public static boolean isEven(int i) { return i % 2 == 0; }
    
    public static int addOne(int n) { return n+1; }
    
    public static int subtractOne ( int i)
    {
        return i-1;
        
    }
}
