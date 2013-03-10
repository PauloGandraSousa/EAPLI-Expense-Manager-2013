/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistence.ExpenseTypeRepository;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypes {
    private static final String MISC_KEY = "Misc.";
    private static final String MISC_DESC = "Miscelaneous";
    private static final String CLOTHING_KEY = "Clothing";
    private static final String CLOTHING_DESC = "Clothing";
    private static final String MEALS_KEY = "Meals";
    private static final String MEALS_DESC = "Meals";
    
    public static final ExpenseType MISC;
    public static final ExpenseType CLOTHING;
    public static final ExpenseType MEALS;
    
    static {
        ExpenseTypeRepository repo = new ExpenseTypeRepository();
        MISC = repo.findOrCreate(MISC_KEY, MISC_DESC);
        CLOTHING = repo.findOrCreate(CLOTHING_KEY, CLOTHING_DESC);
        MEALS = repo.findOrCreate(MEALS_KEY, MEALS_DESC);
    }
}
