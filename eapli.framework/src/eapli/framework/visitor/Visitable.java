/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.visitor;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface Visitable<T> {

    void accept(Visitor<T> visitor);
}
