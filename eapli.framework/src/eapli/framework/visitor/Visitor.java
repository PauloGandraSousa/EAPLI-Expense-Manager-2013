/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.visitor;

/**
 *
 * @author Paulo Gandra Sousa
 * @param <T> the specific type we want to visit
 */
public interface Visitor<T> {

	void visit(T visited);

	public void beforeVisiting(T visited);

	public void afterVisiting(T visited);
}
