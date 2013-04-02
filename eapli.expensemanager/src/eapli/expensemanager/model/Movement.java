/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import eapli.util.DateTime;
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
 *
 * @author Paulo Gandra Sousa
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // TODO check if single table inheritance is the best strategy
public abstract class Movement {

    @Id
    @GeneratedValue
    long id;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateOcurred;
    BigDecimal amount;

    public Movement() {
    }

    public Movement(String description, Date dateOccurred, BigDecimal amount) {
        if (description == null || dateOccurred == null || amount == null) {
            throw new IllegalArgumentException();
        }
        // cannot record a negative or zero EUR movement
        if (amount.signum() == -1 || amount.signum() == 0) {
            throw new IllegalArgumentException();
        }

        this.description = description;
        this.dateOcurred = dateOccurred;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean occursThisWeek() {
        int weekOfMovement = DateTime.weekNumber(dateOcurred);
        int thisWeek = DateTime.currentWeekNumber();
        return thisWeek == weekOfMovement;
    }

    public boolean occursThisMonth() {
        int thisMonth = DateTime.today().get(Calendar.MONTH);
        int movementMonth = DateTime.dateToCalendar(dateOcurred).get(Calendar.MONTH);
        return (thisMonth == movementMonth);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}