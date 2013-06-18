/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.persistence.repositories;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface DeleteableRepository<T, PK> extends Repository<T, PK> {

    /**
     * removes the specified entity from the repository.
     *
     * @param entity
     * @throws UnsuportedOperationException if the delete operation makes no
     * sense for this repository
     */
    void delete(T entity);
}
