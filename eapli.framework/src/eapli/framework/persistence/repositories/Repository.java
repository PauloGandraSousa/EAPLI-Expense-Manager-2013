/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.persistence.repositories;

import java.util.List;

/**
 * a generic interface for repositories.
 *
 * @param T the class we want to manage in the repository
 * @param PK the class denoting the primary key of the entity
 * @author Paulo Gandra Sousa
 */
public interface Repository<T, PK> {

    /**
     * Saves an entity either by creating it or updating it in the persistence
     * store.
     *
     * @param entity
     * @return
     */
    T save(T entity);

    /**
     * gets all entities from the repository.
     *
     * @return
     */
    List<T> all();

    /**
     * gets the entity with the specified id
     *
     * @param id
     * @return
     */
    T findById(PK id);

    /**
     * returns the number of entities in the repository.
     *
     * @return
     */
    long size();
}
