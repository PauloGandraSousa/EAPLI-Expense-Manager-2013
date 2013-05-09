/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * a base class for factoring out the common parts of ExpenseType and IncomeType
 * 
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class MovementType implements Serializable {
    @Id
    String shortName;
    String description;

    protected MovementType(){}
    
    public MovementType(String key, String description) {
        if (key == null || description == null) {
            throw new IllegalArgumentException();
        }
        if (key.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        this.shortName = key;
        this.description = description;
    }

    public String getId() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }
     
    public String toXml() {
        return "<description>" + description + "</description>" ;
    }  
    
    public String toCsv() {
        return description + "," ;
    }
    
}
