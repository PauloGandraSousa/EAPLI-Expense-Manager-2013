/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author losa
 */
@Entity
public class SavingPlan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    // TODO what is the meaning of this field?
    // FIX should follow naming conventions
    private Date InicialDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SavingGoal> savingGoals;

    public SavingPlan() {
        savingGoals = new ArrayList<SavingGoal>();
    }

    public SavingPlan(Date d) {
        InicialDate = d;
    }

    public SavingGoal registerSavingGoal(SavingGoal savingGoal) {
        savingGoals.add(savingGoal);
        return savingGoal;
    }

    // TODO:AJS: isto deveria trabalhar com indices da lista e não com objectivos propriamente ditos
    // TODO this method does not change the state of the object. is this the best place for it to be?
    public void registerSavingDeposit(SavingDeposit s, SavingGoal goal1) {
        goal1.registerSavingDeposit(s);
    }

    // TODO this method does not change the state of the object. is this the best place for it to be?
    public void registerSavingWithdraw(SavingWithdraw s, SavingGoal goal1) {
        goal1.registerSavingWithdraw(s);
    }

    public List<SavingGoal> getSavingGoals() {
        return savingGoals;
    }
}
