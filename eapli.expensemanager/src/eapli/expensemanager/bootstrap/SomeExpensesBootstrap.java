/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.InsufficientBalanceException;
import eapli.expensemanager.model.Payment;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class SomeExpensesBootstrap {

    public SomeExpensesBootstrap() {
        CheckingAccountRepository repoAccount = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount theAccount = repoAccount.theAccount();

        ExpenseTypeRepository repoExpenseType = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
        ExpenseType clothing = repoExpenseType.findForName(Bootstrap.CLOTHING_EXPENSE_TYPE);
        ExpenseType transport = repoExpenseType.findForName(Bootstrap.TRANSPORTS_EXPENSE_TYPE);

        PaymentMeanRepository repoPaymentMethod = PersistenceFactory.buildPersistenceFactory().paymentMeanRepository();
        Cash cashEur = repoPaymentMethod.getCash(Cash.EUR);
        Payment payment = new Payment(cashEur);

        Calendar baseDateOfExpense = DateTime.today();
        Date dateOfExpense = baseDateOfExpense.getTime();
        try {
            Expense exp = new Expense(clothing, "sapatilhas", dateOfExpense, new BigDecimal(100), payment);
            theAccount.registerExpense(exp);

            exp = new Expense(clothing, "T-shirt", dateOfExpense, new BigDecimal(10), payment);
            theAccount.registerExpense(exp);

            baseDateOfExpense.add(Calendar.DAY_OF_MONTH, 4);
            dateOfExpense = baseDateOfExpense.getTime();

            exp = new Expense(clothing, "calças", dateOfExpense, new BigDecimal(150), payment);
            theAccount.registerExpense(exp);

            baseDateOfExpense.add(Calendar.DAY_OF_MONTH, -30);
            dateOfExpense = baseDateOfExpense.getTime();

            exp = new Expense(transport, "passe Metro", dateOfExpense, new BigDecimal(35), payment);
            theAccount.registerExpense(exp);
        } catch (InsufficientBalanceException ex) {
            System.out.println("unable to bootstrap all or some of the expenses due to insufficient balance");
        }
        repoAccount.save(theAccount);
    }
}
