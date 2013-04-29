/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.SavingsPlan;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PaymentMethodRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingsPlanRepository;
import java.util.Date;
import javax.persistence.NoResultException;

/**
 * this classes serves as bootstrap data loader. just to make sure some data
 * exists in order to use the system it should be removed for "production-ready"
 * deployment
 *
 * @author Paulo Gandra Sousa
 */
public class Bootstrap {

    private void ensureClothingExpenseTypeExists(ExpenseTypeRepository repo) {
        ExpenseType clothing = repo.findForName(CLOTHING_EXPENSE_TYPE);
        if (clothing == null) {
            clothing = new ExpenseType(CLOTHING_EXPENSE_TYPE, CLOTHING_EXPENSE_TYPE_DESC);
            repo.save(clothing);
        }
    }

    private void ensureTransportsExpenseTypeExists(ExpenseTypeRepository repo) {
        ExpenseType transports = repo.findForName(TRANSPORTS_EXPENSE_TYPE);
        if (transports == null) {
            transports = new ExpenseType(TRANSPORTS_EXPENSE_TYPE, TRANSPORTS_EXPENSE_TYPE_DESC);
            repo.save(transports);
        }
    }

    private void ensureCashEurExists() {
        try {
            Cash cashEur = Cash.loadEUR();
        } catch (NoResultException ex) {
            Cash cashEur = new Cash(Cash.EUR);
            cashEur.save();
        }
    }

    public Bootstrap() {
        ensureTheAccountExists();
        ensureDefaultExpenseTypesExist();
        ensureCashEurExists();
        ensureSavingsPlanExists();
    }          

    private void ensureTheAccountExists() {
        CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        try {
            CheckingAccount theAccount = repo.theAccount();
        } catch (IllegalStateException ex) {
            CheckingAccount theAccount = new CheckingAccount();
            repo.save(theAccount);
        }
    }
    
    
    
     private void ensureSavingsPlanExists() {
        SavingsPlanRepository repo = PersistenceFactory.buildPersistenceFactory().savingsPlanRepository();
        try {
            SavingsPlan theSavingPlan = repo.theSavingsPlan();
        } catch (IllegalStateException ex) {
            SavingsPlan theSavingPlan = new SavingsPlan(new Date());
            repo.save(theSavingPlan);
        }
    }
    
    final static String CLOTHING_EXPENSE_TYPE = "Cloth.";
    final static String CLOTHING_EXPENSE_TYPE_DESC = "Clothing";
    final static String TRANSPORTS_EXPENSE_TYPE = "Trans.";
    final static String TRANSPORTS_EXPENSE_TYPE_DESC = "Transports";

    private void ensureDefaultExpenseTypesExist() {
        ExpenseTypeRepository repo = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
        ensureClothingExpenseTypeExists(repo);
        ensureTransportsExpenseTypeExists(repo);
    }
}
