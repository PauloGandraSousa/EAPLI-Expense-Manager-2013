/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.util.Console;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class RegisterMovementBaseUI extends BaseUI {

    String what;
    Calendar date;
    BigDecimal amount;

    protected void readGeneralData() {
        what = Console.readLine("What:");
        date = Console.readCalendar("When (dd-MM-yyyy):");
        double value = Console.readDouble("How much:");
        amount = new BigDecimal(value);
    }
}
