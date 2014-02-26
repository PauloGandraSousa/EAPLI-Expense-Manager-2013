/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.presentation;

import eapli.framework.visitor.Visitor;
import eapli.util.Console;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */

/**
 *
 * @author Paulo Gandra Sousa
 * @param <T>
 */
public class SelectWidget<T> extends ListWidget<T> {
    int option = -1;

        public SelectWidget(List<T> source, Visitor<T> visitor) {
			super(source, visitor);
		}

		@Override
    public void show() {
		super.show();
		System.out.println("0. Exit");
		option = Console.readOption(1, numberOfPositions(), 0);
	}

    /**
     *
     * @return -1 is the user has not yet made a selection 0 if the user
     * selected "exit" a positive number corresponding to the list index os
     * source if the user selected an item
     */
    public int selectedOption() {
        return option;
    }
}
