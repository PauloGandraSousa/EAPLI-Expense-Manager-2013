/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface Visitor<T> {
    void visit(T visited);
}
