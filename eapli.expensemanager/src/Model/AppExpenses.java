/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
  

/**
 *
 * @author arocha
 */
 public class AppExpenses {
    private static AppExpenses inst;

    public ExpenseRecord expenseRecord=ExpenseRecord.instance();
    public ExpenseTypes  expenseTypes=ExpenseTypes.instance();;
    
    private AppExpenses()
    {       
    }

    public static AppExpenses getInstance()
    {       
        if (inst == null)
            inst = new AppExpenses();
            
        return inst;
    }
}