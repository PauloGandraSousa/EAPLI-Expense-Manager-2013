/**
 * Provides the interfaces of the persistence layer and the factory class.
 * The PersistenceFactory class follows the Abstract Factory pattern by building
 * repository factories (implementations of the RepositoryFactory interface).
 * each RepositoryFactory will build the different repositories, e.g., ExpenseRepository
 * 
 * @author Paulo Gandra Sousa
 *
 */
package eapli.expensemanager.persistence;