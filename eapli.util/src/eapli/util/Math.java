/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    
        /**
     * Permite efectuar a conversão de um valor para outra escala
     *
     * @param oldMin - exemplo 0
     * @param oldMax - exemplo 100
     * @param newMin - exemplo 0
     * @param newMax - exemplo 10
     * @param oldValue - exemplo 50
     * @return retorna o novo valor aplicando uma conversão linear - exemplo 5
     */
    public static float simpleLinearConversion(float oldMin, float oldMax, float newMin, float newMax, float oldValue) {
        float new_value;
        new_value = ((oldValue - oldMin) / (oldMax - oldMin)) * (newMax - newMin) + newMin;
        return new_value;

    }

    /**
     * Permite efectuar a conversão de um valor para outra escala
     *
     * @param oldMin - exemplo 0
     * @param oldMax - exemplo 100
     * @param newMin - exemplo 0
     * @param newMax - exemplo 10
     * @param oldValue - exemplo 50
     * @return retorna o novo valor aplicando uma conversão linear - exemplo 5
     */
    public static BigDecimal simpleLinearConversion(BigDecimal oldMin, BigDecimal oldMax, BigDecimal newMin, BigDecimal newMax, BigDecimal oldValue) {
        BigDecimal new_value;
        new_value = ((oldValue.subtract(oldMin)).divide(oldMax.subtract(oldMin), 1, RoundingMode.HALF_UP)).multiply((newMax.subtract(newMin)).add(newMin));
        return new_value;
    }
}
