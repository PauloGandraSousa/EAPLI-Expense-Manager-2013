/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.framework.model.Identifiable;
import eapli.util.DateTime;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 * the base movement class. to be extended for concrete movement types such as
 * Expense or Income
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Movement implements Serializable, Identifiable<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar ocurred;
    private BigDecimal amount;

    public Movement() {
    }

    /**
     * checks if the current object has the identity passed as a parameter
     *
     * @param id the identity to check
     * @return true if the object has the identity
     */
    @Override
    public boolean is(Long id) {
        return this.id.equals(id);
    }

    public Movement(String description, Calendar dateOccurred, BigDecimal amount) {
        if (description == null || dateOccurred == null || amount == null) {
            throw new IllegalArgumentException();
        }
        // cannot record a negative or zero EUR movement
        if (amount.signum() == -1 || amount.signum() == 0) {
            throw new IllegalArgumentException();
        }

        this.description = description;
        this.ocurred = (Calendar) dateOccurred.clone();
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean occursThisWeek() {
        int weekOfMovement = DateTime.weekNumber(getOcurred());
        int thisWeek = DateTime.currentWeekNumber();
        return thisWeek == weekOfMovement;
    }

    public boolean occursThisMonth() {
        int thisMonth = DateTime.today().get(Calendar.MONTH);
        int movementMonth = getOcurred().get(Calendar.MONTH);
        return (thisMonth == movementMonth);
    }

    public boolean occursBetween(Date start, Date end) {
        if (this.getOcurred().compareTo(DateTime.dateToCalendar(start)) >= 0
                && this.getOcurred().compareTo(DateTime.dateToCalendar(end)) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the date when the movement ocurred
     */
    public Calendar getOcurred() {
        return ocurred;
    }

    public boolean ocurredInMonth(int year, int month) {
        int monthOcurred = ocurred.get(Calendar.MONTH) + 1;
        int yearOcurred = ocurred.get(Calendar.YEAR);

        return (monthOcurred == month && yearOcurred == year ? true : false);
    }

    public boolean ocurredInWeek(int year, int week) {
        int weekOcurred = DateTime.weekNumber(ocurred);
        int yearOcurred = ocurred.get(Calendar.YEAR);

        return (weekOcurred == week && yearOcurred == year ? true : false);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movement other = (Movement) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
