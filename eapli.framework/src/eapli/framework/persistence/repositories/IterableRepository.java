/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.persistence.repositories;

/**
 * a Repository which can be efficiently iterated.
 *
 * the implementation class must provide for an efficient iterator over all
 * entities in the repository. this is particular the case for database-backed
 * up persistence stores where one expects a cursor like behaviour. it is the
 * responsibility of the implementation class to handle disconnected scenarios
 * or not.
 *
 * @author Paulo Gandra Sousa
 */
public interface IterableRepository<T, PK> extends Repository<T, PK>, Iterable<T> {
}
