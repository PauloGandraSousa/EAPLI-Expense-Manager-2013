/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.RegisterPaymentMeanController;
import eapli.util.Console;
import java.util.Calendar;

/**
 *
 * @author Paulo Gandra Sousa
 */
class RegisterPaymentMeanUI extends BaseForm {

    String cardName;
    String bank;
    String number;
    String name;
    Calendar validUntil;
    String chequeBookName;
    String accountNumber;
    
    RegisterPaymentMeanController controller = new RegisterPaymentMeanController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    @Override
    protected boolean doShow() {
        
        // TODO consider using a menu (wth Action) for this instead of being hardcoded
        // in the UI
        
        //System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Debit card");
        System.out.println("4. Cheque");
        System.out.println("0. Exit");
        int option = Console.readOption(2, 4, 0);
        switch (option) {
            case 2:
                readCardData();
                controller.registerCreditCard(cardName, bank, number, name, validUntil);
                break;
            case 3:
                readCardData();
                controller.registerDebitCard(cardName, bank, number, name, validUntil);
                break;
            case 4:
                readChequeData();
                controller.registerCheque(chequeBookName, bank, accountNumber);
        }
        return true;
    }

    @Override
    public String headline() {
        return "REGISTER A PAYMENT METHOD";
    }

    private void readCardData() {
        cardName = Console.readLine("How do you call your card:");
        bank = Console.readLine("Bank:");
        number = Console.readLine("Card number:");
        name = Console.readLine("Name on card:");
        validUntil = Console.readCalendar("Valid (dd-MM-yyyy):");
    }

    private void readChequeData() {
        chequeBookName = Console.readLine("How do you call your cheque account:");
        bank = Console.readLine("Bank:");
        accountNumber = Console.readLine("Account number:");
    }
}
