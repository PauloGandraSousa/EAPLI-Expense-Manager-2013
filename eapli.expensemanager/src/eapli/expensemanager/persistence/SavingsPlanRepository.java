/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.SavingsPlan;
import java.util.Collection;
import java.util.Iterator;
/**
 *
 * @author Paulo Gandra Sousa
 */
public interface SavingsPlanRepository {

    /**
     * Quando uma classe é persistente, temos de garantir que o retorno da base
     * de dados será sempre um e apenas um objecto, daí o nome theAccount
     *
     * @return the one and only accountƒ
     */
  
 public SavingsPlan theSavingsPlan();

    public SavingsPlan save(SavingsPlan savingplan);
    
}
