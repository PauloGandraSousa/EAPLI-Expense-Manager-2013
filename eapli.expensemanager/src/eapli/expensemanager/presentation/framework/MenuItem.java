/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.framework;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class MenuItem {
    int option;
    String text;
    Action action;
    
    public MenuItem(int option, String text, Action action) {
        if (action == null) {
            throw new IllegalArgumentException();
        }
        this.option = option;
        this.text = text;
        this.action = action;
    }
    
    public boolean select() {
        return action.execute();
    }
    
    public void show() {
        System.out.print(option + ". ");
        System.out.println(text);
    }
}
