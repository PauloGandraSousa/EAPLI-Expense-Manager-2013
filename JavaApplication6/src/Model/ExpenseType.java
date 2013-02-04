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
    
    public ExpenseType(String description) {
        this.description = description;
    }
}
