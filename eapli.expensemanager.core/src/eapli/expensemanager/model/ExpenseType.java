/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;

/**
 *
 * @author Paulo Gandra Sousa
 */
@Entity
public class ExpenseType extends MovementType {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected ExpenseType() {
    }

    public ExpenseType(String key, String description) {
        super(key, description);
    }

    @Override
    public String toString() {
        return "Expense Type: " + super.toString();
    }
}
