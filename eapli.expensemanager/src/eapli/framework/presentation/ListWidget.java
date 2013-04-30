/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.presentation;

import eapli.framework.Visitor;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class ListWidget<T> {

    List<T> source;
    Visitor<T> visitor;
    
    public ListWidget(List<T> source, Visitor<T> visitor) {
        this.source = source;
        this.visitor = visitor;
    }
    
    public void show() {
        int position = 1;
        for (T et : source) {
            System.out.print(position + ". ");
            visitor.visit(et);
            position++;
        }
    }

}
