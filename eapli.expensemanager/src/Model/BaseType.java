/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Id;

/**
 *
 * @author Paulo Gandra Sousa
 */
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
