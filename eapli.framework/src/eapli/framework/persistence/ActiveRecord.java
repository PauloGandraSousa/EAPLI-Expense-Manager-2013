/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.persistence;

/**
 * An interface to mark a class as an Active Record.
 *
 * Active Records might have static finder methods.
 *
 * @author Paulo Gandra Sousa
 */
public interface ActiveRecord {

    void save();
    //void delete();
}
