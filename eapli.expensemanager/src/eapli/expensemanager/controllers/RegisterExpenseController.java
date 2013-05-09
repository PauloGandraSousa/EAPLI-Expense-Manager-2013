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
import eapli.expensemanager.model.PaymentMean;
import eapli.expensemanager.model.WatchDogLimits;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import eapli.expensemanager.presentation.BaseForm;
import eapli.expensemanager.presentation.RegisterExpenseUI;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class RegisterExpenseController extends BaseController {
     // OBSERVER pattern: associate  WatchDogLimits 
      WatchDogLimits watchDog=null;

    public RegisterExpenseController() {
    }

    public Payment createPayment(PaymentMean mean) {
        Payment payment = new Payment(mean);
        return payment;
    }
    
    public ChequePayment createChequePayment(Cheque mean, String checkNumber) {
        ChequePayment payment = new ChequePayment(mean, checkNumber);
        return payment;
    }
            
    public void registerExpense(String what, Date date, BigDecimal amount, ExpenseType expenseType, Payment payment) {
        Expense expense = new Expense(expenseType, what, date, amount, payment);
        //ExpenseRepository repo = PersistenceRegistry.instance().expenseRepository();
        CheckingAccountRepository repo = PersistenceFactory.buildPersistenceFactory().checkingAccountRepository();
        CheckingAccount account = repo.theAccount(); 
         // OBSERVER PATTERN: add WatchDogLimits as observer of account 
        account.addObserver(watchDog);
        account.registerExpense(expense);
        repo.save(account);
    }

    public List<ExpenseType> getExpenseTypes() {
        // use the existing controller to avoid duplication
        ListExpenseTypesController listExpenseTypesController = new ListExpenseTypesController();
        return listExpenseTypesController.getExpenseTypes();
    }

    public List<PaymentMean> getPaymentMeans() {
        ListPaymentMeansController listPaymentMeansController = new ListPaymentMeansController();
        return listPaymentMeansController.getPaymentMeans();
    }
    
    // OBSERVER pattern : Create WatchDog that is an Observable and register RegisterExpenseUI as its Observer
    public void addObserverWatchDogLimits(RegisterExpenseUI ui){
           watchDog=new WatchDogLimits();
          watchDog.addObserver(ui);
    }
    
}
