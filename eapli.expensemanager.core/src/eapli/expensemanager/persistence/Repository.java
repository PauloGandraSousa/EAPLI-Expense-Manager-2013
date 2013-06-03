/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence;

import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface Repository<T, PK> {
    T save(T entity);
    
    List<T> all();
    
    T findById(PK id);
}
