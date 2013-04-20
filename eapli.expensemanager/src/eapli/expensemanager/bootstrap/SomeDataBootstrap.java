/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.bootstrap;

import eapli.expensemanager.model.Cash;
import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Payment;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PaymentMethodRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.util.DateTime;
import java.math.BigDecimal;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class SomeDataBootstrap extends Bootstrap {
    
    public SomeDataBootstrap() {
        super();
        
        CheckingAccountRepository repoAccount = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount theAccount = repoAccount.theAccount();
        
        ExpenseTypeRepository repoExpenseType = PersistenceFactory.buildPersistenceFactory().expenseTypeRepository();
        ExpenseType clothing = repoExpenseType.findForName(CLOTHING_EXPENSE_TYPE);
        ExpenseType transport = repoExpenseType.findForName(TRANSPORTS_EXPENSE_TYPE);
        
        PaymentMethodRepository repoPaymentMethod = PersistenceFactory.buildPersistenceFactory().paymentMethodRepository();
        Cash cashEur = repoPaymentMethod.getCash(Cash.EUR);
        Payment payment = new Payment(cashEur);

        Expense exp = new Expense(clothing, "sapatilhas", DateTime.newDate(2013, 4, 1), new BigDecimal(100), payment);
        theAccount.registerExpense(exp);
                
        exp = new Expense(clothing, "calças", DateTime.newDate(2013, 4, 5), new BigDecimal(150), payment);
        theAccount.registerExpense(exp);

        exp = new Expense(clothing, "T-shirt", DateTime.newDate(2013, 4, 1), new BigDecimal(10), payment);
        theAccount.registerExpense(exp);

        exp = new Expense(transport, "passe Metro", DateTime.newDate(2013, 3, 1), new BigDecimal(35), payment);
        theAccount.registerExpense(exp);
                
        repoAccount.save(theAccount);
    }
}
