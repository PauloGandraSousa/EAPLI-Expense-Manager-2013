/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.presentation.framework.ListWidget;
import eapli.expensemanager.presentation.framework.BaseUI;
import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterExpenseController;
import eapli.expensemanager.model.Cheque;
import eapli.expensemanager.model.ChequePayment;
import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.Payment;
import eapli.expensemanager.model.PaymentMean;
import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
class RegisterExpenseUI extends BaseUI {

    ListWidget widget;

    @Override
    public String headline() {
        return "REGISTER AN EXPENSE";
    }

    @Override
    public boolean doShow() {
        // TODO remove duplicate code with RegisterIncomeUI
        String what = Console.readLine("What:");
        Date date = Console.readDate("When (dd-MM-yyyy):");
        double value = Console.readDouble("How much:");
        BigDecimal amount = new BigDecimal(value);
        ExpenseType expenseType = readExpenseType();
        
        // TODO should the UI create a Payment object?
        Payment method = readPaymentMean();        

        controller.registerExpense(what, date, amount, expenseType, method);

        System.out.println("\nExpense recorded!");

        return true;
    }
    
    RegisterExpenseController controller = new RegisterExpenseController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    private ExpenseType readExpenseType() {
        System.out.println("-- EXPENSE TYPES --");
        List<ExpenseType> listExpenseTypes = controller.getExpenseTypes();
        // TODO create SelectWidget to list and select an option
        widget = new ListWidget(listExpenseTypes, new ExpenseTypeListVisitor());
        widget.show();
        int option = Console.readOption(1, listExpenseTypes.size(), 0);
        ExpenseType expenseType = listExpenseTypes.get(option-1);
        return expenseType;
    }

    private Payment readPaymentMean() {
        System.out.println("-- PAYMENT MEANS --");
        List<PaymentMean> methods = controller.getPaymentMeans();
        // FIX use ListWidget to avoid code duplication
        int position = 1;
        for (PaymentMean method : methods) {
            System.out.println(position + ". " + method.getDescription());
            position++;
        }
        int option = Console.readOption(1, methods.size(), 0);
        PaymentMean method = methods.get(option-1);
        
        // TODO should the UI ask for a Payment object or call different 
        // registerXXX methods on the controller, i.e., registerExpensePaidwithCheque
        // or registerExpensePaidWithCash, etc...
        Payment payment;
        if (method.getClass() == Cheque.class) {
            String chequeNumber = Console.readLine("Cheque number:");
            payment = controller.createChequePayment((Cheque)method, chequeNumber);
        }
        else {
            payment = controller.createPayment(method);
        }
        
        return payment;
    }
}
