/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class BaseType {
    @Id
    String id;
    String description;

    protected BaseType(){}
    
    public BaseType(String key, String description) {
        if (key == null || description == null) {
            throw new IllegalArgumentException();
        }
        if (key.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        this.id = key;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
