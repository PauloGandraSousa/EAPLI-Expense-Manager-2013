/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.util.Console;

/**
 *
 * @author Paulo Gandra Sousa
 */
public abstract class RegisterMovementTypeBaseUI extends BaseForm {

    protected String shortName;
    protected String descr;

    protected void readGeneralData() {
        shortName = Console.readLine("Short name:");
        descr = Console.readLine("Description:");
    }
}
