/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.SavingsPlan;

/**
 *
 * @author losa
 */
public interface SavingsPlanRepository {
        
    public SavingsPlan theSavingsPlan();
    public SavingsPlan  save(SavingsPlan savingsplan); 
    

    
}
