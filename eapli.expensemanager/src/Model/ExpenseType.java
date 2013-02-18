/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class ExpenseType {
    @Id
    long Id;
    String description;
    boolean isRecurrent;
    
    protected ExpenseType() {}
    
    public ExpenseType(String description) {
        this(description, false);
    }
    
    public ExpenseType(String description, boolean isRecurrent) {
        if (description == null) {
            throw new IllegalArgumentException();
        }
        
        this.description = description;
        this.isRecurrent = isRecurrent;
    }
    
    public boolean isRecurrent() {
        return isRecurrent;
    }
}
