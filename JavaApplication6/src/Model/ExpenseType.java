/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class ExpenseType {
    String description;
    boolean isRecurrent;
    
    public ExpenseType(String description) {
        this(description, false);
    }
    
    public ExpenseType(String description, boolean isRecurrent) {
        this.description = description;
        this.isRecurrent = isRecurrent;
    }
    
    public boolean isRecurrent() {
        return isRecurrent;
    }
    
    
}
