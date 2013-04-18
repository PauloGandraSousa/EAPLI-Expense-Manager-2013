/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation;

import eapli.expensemanager.model.Descriptable;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListWidget<T extends Descriptable> {

    List<T> source;
    
    public ListWidget(List<T> source) {
        this.source = source;
    }
    
    public void show() {
        int position = 1;
        for (T et : source) {
            System.out.println(position + ". " + et.getDescription());
            position++;
        }
    }

}
