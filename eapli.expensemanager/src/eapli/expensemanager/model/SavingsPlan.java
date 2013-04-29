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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author losa
 */
@Entity
public class SavingsPlan  {
    @Id
    @GeneratedValue
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date InicialDate;
    
     @OneToMany (cascade= CascadeType.ALL)
    private List<SavingGoal> listSavingGoal;
     
           
    public SavingsPlan() {
     listSavingGoal= new ArrayList<SavingGoal>();
    }
    
    public SavingsPlan(Date d)
    {
        InicialDate=d;
    }
    
    public SavingGoal registerSavingGoal(SavingGoal savingGoal)
    {
        listSavingGoal.add(savingGoal);
        return savingGoal;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the InicialDate
     */
    public Date getInicialDate() {
        return InicialDate;
    }

    /**
     * @param InicialDate the InicialDate to set
     */
    public void setInicialDate(Date InicialDate) {
        this.InicialDate = InicialDate;
    }

    /**
     * @return the listtargetofsaving
     */
    public List<SavingGoal> getLisfSavingGoal() {
        return listSavingGoal;
    }

    
    public void setlistSavingGoal(List<SavingGoal> listSavingGoal) {
        this.listSavingGoal = listSavingGoal;
    }

     public List<SavingGoal> getlistSavingGoal() {
        return listSavingGoal;
    }

    public void registerSaving(Saving s, SavingGoal goal1) {
        goal1.registerSaving(s);
    }
     
     
     
}
