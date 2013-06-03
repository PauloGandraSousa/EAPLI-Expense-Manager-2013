/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.util.Validations;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MovementType implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String shortName;
    private String description;

    /**
     * since this class is used as a key to a hash map it should override
     * equals() and hashCode()
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.shortName != null ? this.shortName.hashCode() : 0);
        return hash;
    }

    /**
     * since this class is used as a key to a hash map it should override
     * equals() and hashCode()
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovementType other = (MovementType) obj;
        if ((this.shortName == null) ? (other.shortName != null) : !this.shortName.equals(other.shortName)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }

    protected MovementType() {
    }

    public MovementType(String key, String description) {
        if (Validations.isNullOrEmpty(key) || description == null) {
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
        return "<description>" + description + "</description>";
    }

    public String toCsv() {
        return description + ",";
    }
}
