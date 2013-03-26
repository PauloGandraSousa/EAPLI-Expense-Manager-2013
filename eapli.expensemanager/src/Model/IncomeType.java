/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
class IncomeType extends BaseType{
        protected IncomeType() {}
    
    public IncomeType(String key, String description) {
        super(key, description);
    }
}
