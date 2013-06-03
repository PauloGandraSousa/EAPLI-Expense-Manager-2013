/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.IncomeType;
import eapli.expensemanager.model.SavingPlan;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.IncomeTypeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.persistence.SavingPlanRepository;
import java.util.Date;
import javax.persistence.NoResultException;

/**
 * this classes serves as bootstrap data loader. just to make sure some data
 * exists in order to use the system it should be removed for "production-ready"
 * deployment
 *
 * @author Paulo Gandra Sousa
 */
public class ReferenceDataBootstrap implements Bootstrap {

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
            Cash.loadEUR();
        } catch (NoResultException ex) {
            Cash cashEur = new Cash(Cash.EUR);
            cashEur.save();
        }
    }

    private void ensureTheAccountExists() {
        CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        try {
            repo.theAccount();
        } catch (IllegalStateException ex) {
            CheckingAccount theAccount = new CheckingAccount();
            repo.save(theAccount);
        }
    }

    private void ensureSavingsPlanExists() {
        SavingPlanRepository repo = PersistenceFactory.buildPersistenceFactory().savingPlanRepository();
        try {
            repo.theSavingPlan();
        } catch (IllegalStateException ex) {
            SavingPlan theSavingPlan = new SavingPlan(new Date());
            repo.save(theSavingPlan);
        }
    }
    public final static String CLOTHING_EXPENSE_TYPE = "Cloth.";
    private final static String CLOTHING_EXPENSE_TYPE_DESC = "Clothing";
    public final static String TRANSPORTS_EXPENSE_TYPE = "Trans.";
    private final static String TRANSPORTS_EXPENSE_TYPE_DESC = "Transports";

    private void ensureDefaultExpenseTypesExist() {
        ExpenseTypeRepository repo = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
        ensureClothingExpenseTypeExists(repo);
        ensureTransportsExpenseTypeExists(repo);
    }

    private void ensureDefaultIncomeTypesExist() {
        IncomeTypeRepository repo = PersistenceFactory.buildPersistenceFactory().incomeTypeRepository();
        ensureSalaryIncomeTypeExists(repo);
    }
    public static final String SALARY_INCOME_TYPE = "Sal.";
    private static final String SALARY_INCOME_TYPE_DESC = "Salary";

    private void ensureSalaryIncomeTypeExists(IncomeTypeRepository repo) {
        IncomeType salary = repo.findForName(SALARY_INCOME_TYPE);
        if (salary == null) {
            salary = new IncomeType(SALARY_INCOME_TYPE, SALARY_INCOME_TYPE_DESC);
            repo.save(salary);
        }
    }

    @Override
    public void bootstrap() {
        ensureTheAccountExists();
        ensureDefaultExpenseTypesExist();
        ensureDefaultIncomeTypesExist();
        ensureCashEurExists();
        ensureSavingsPlanExists();
    }
}
