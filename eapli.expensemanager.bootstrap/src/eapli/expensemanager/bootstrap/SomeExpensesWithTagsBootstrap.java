/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Payment;
import eapli.expensemanager.persistence.ExpenseRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PaymentMeanRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.util.DateTime;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class SomeExpensesWithTagsBootstrap implements Bootstrap {

    @Override
    public void bootstrap() {
        ExpenseRepository repo = PersistenceFactory.buildPersistenceFactory().
                expenseRepository();

        ExpenseTypeRepository repoExpenseType = PersistenceFactory
                .buildPersistenceFactory().expenseTypeRepository();
        ExpenseType clothing = repoExpenseType
                .findById(ReferenceDataBootstrap.CLOTHING_EXPENSE_TYPE);
        ExpenseType transport = repoExpenseType
                .findById(ReferenceDataBootstrap.TRANSPORTS_EXPENSE_TYPE);

        PaymentMeanRepository repoPaymentMethod = PersistenceFactory
                .buildPersistenceFactory().paymentMeanRepository();
        Cash cashEur = repoPaymentMethod.getCash(Cash.EUR);
        Payment payment = new Payment(cashEur);

        Calendar dateOfExpense = DateTime.today();

        Expense exp = new Expense(clothing, "sapatilhas", dateOfExpense,
                                  new BigDecimal(100), payment, new String[]{"nike", "run", "shoes"});
        repo.save(exp);

        exp = new Expense(clothing, "T-shirt", dateOfExpense,
                          new BigDecimal(10), payment, new String[]{"nike", "tee", "color"});
        repo.save(exp);

        dateOfExpense.add(Calendar.DAY_OF_MONTH, 4);

        exp = new Expense(clothing, "calças", dateOfExpense,
                          new BigDecimal(150), payment, new String[]{"sport", "levis"});
        repo.save(exp);

        dateOfExpense.add(Calendar.DAY_OF_MONTH, -30);

        exp = new Expense(transport, "passe Metro", dateOfExpense,
                          new BigDecimal(35), payment);
        repo.save(exp);

    }
}
