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
    String id;
    String description;

    
    protected ExpenseType() {}
    
    public ExpenseType(String key, String description) {
        if (key == null || description == null) {
            throw new IllegalArgumentException();
        }
        if (key.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        
        this.id = key;
        this.description = description;
    }
    
    public ExpenseType(String description) {
        String key=description; // devia gerar um sequencial??
                                
        if (key == null || description == null) {
            throw new IllegalArgumentException();
        }
        if (key.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        
        this.id = key;
        this.description = description;
    }
    
    
    
    public String getDescription(){
        return description;
    }  

}
