/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Persistence.ExpenseTypeRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ExpenseTypes {
//    private static final String MISC_KEY = "Misc.";
//    private static final String MISC_DESC = "Miscelaneous";
//    private static final String CLOTHING_KEY = "Clothing";
//    private static final String CLOTHING_DESC = "Clothing";
//    private static final String MEALS_KEY = "Meals";
//    private static final String MEALS_DESC = "Meals";
//    
//    public static final ExpenseType MISC;
//    public static final ExpenseType CLOTHING;
//    public static final ExpenseType MEALS;
//    
//    static {
//        ExpenseTypeRepository repo = new ExpenseTypeRepository();
//        MISC = repo.findOrCreate(MISC_KEY, MISC_DESC);
//        CLOTHING = repo.findOrCreate(CLOTHING_KEY, CLOTHING_DESC);
//        MEALS = repo.findOrCreate(MEALS_KEY, MEALS_DESC);
//    }
    
    List<ExpenseType> theExpenseTypes = new ArrayList<ExpenseType>();
    
    private ExpenseTypes() {}
    private static ExpenseTypes theInstance;
    public static ExpenseTypes instance() {
        if (theInstance == null)
            theInstance = new ExpenseTypes();
        return theInstance;
    }
    
     public void register(ExpenseType expenseType) {
        if (expenseType == null) {
            throw new IllegalArgumentException();
        }
        theExpenseTypes.add(expenseType);
    }
     
    public List<String> getExpenseTypes()
    {
         List<String> types = new ArrayList<String>();
    
        for (Iterator<ExpenseType> i = theExpenseTypes.iterator(); i.hasNext();)
        {
            ExpenseType e = i.next();
            types.add(e.getDescription());
        }
        return types;
    }
    
    public ExpenseType getExpenseTypeByDescr(String typeToFind)
    {
         List<String> types = new ArrayList<String>();
        ExpenseType found= null;
    
        for (Iterator<ExpenseType> i = theExpenseTypes.iterator(); i.hasNext();)
        {
            ExpenseType et = i.next();
            if (et.getDescription() == typeToFind)
                    {
                    found=et;
                    break;
                    }
        }
        return found;
    }

    
}
