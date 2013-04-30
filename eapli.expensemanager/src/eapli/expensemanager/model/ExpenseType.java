/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class ExpenseType extends MovementType {
    
    protected ExpenseType() {}
    
    public ExpenseType(String key, String description) {
        super(key, description);
    }
}
