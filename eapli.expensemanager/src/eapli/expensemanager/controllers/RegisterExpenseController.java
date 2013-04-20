/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.controllers;

import eapli.expensemanager.model.CheckingAccount;
import eapli.expensemanager.model.Cheque;
import eapli.expensemanager.model.ChequePayment;
import eapli.expensemanager.model.Expense;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Payment;
import eapli.expensemanager.model.PaymentMethod;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.ExpenseTypeRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterExpenseController extends BaseController {

    public RegisterExpenseController() {
    }

    public Payment createPayment(PaymentMethod method) {
        Payment payment = new Payment(method);
        return payment;
    }
    
    public ChequePayment createChequePayment(Cheque method, String checkNumber) {
        ChequePayment payment = new ChequePayment(method, checkNumber);
        return payment;
    }
            
    public void registerExpense(String what, Date date, BigDecimal amount, ExpenseType expenseType, Payment method) {
        Expense expense = new Expense(expenseType, what, date, amount, method);
        //ExpenseRepository repo = PersistenceRegistry.instance().expenseRepository();
        CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount(); 
        account.registerExpense(expense);
        repo.save(account);
    }

    public List<ExpenseType> getExpenseTypes() {
        // use the existing controller to avoid duplication
        ListExpenseTypesController listExpenseTypesController = new ListExpenseTypesController();
        return listExpenseTypesController.getExpenseTypes();
    }

    public List<PaymentMethod> getPaymentMethods() {
        ListPaymentMethodsController listPaymentMethodsController = new ListPaymentMethodsController();
        return listPaymentMethodsController.getPaymentMethods();
    }
}
