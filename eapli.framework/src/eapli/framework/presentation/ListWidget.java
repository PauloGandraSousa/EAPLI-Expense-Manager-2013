/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.presentation;

import eapli.framework.visitor.Visitor;
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
    
    int position = 0;

    public void show() {
        for (T et : source) {
            position++;
            System.out.print(position + ". ");
            visitor.visit(et);
        }
    }

    protected int numberOfPositions() {
        return position;
    }
}
