/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.inmemory;

import eapli.framework.persistence.repositories.Repository;
import java.util.List;

/**
 * a generic base class for in memory repositories using a List object
 *
 * @author Paulo Gandra Sousa
 * @param <PK>
 */
public abstract class InMemoryRepositoryBase<T, PK> implements Repository<T, PK> {

    /**
     * derived classes must provide the actual List object which will contain
     * the entities. this is mainly due to the fact that java generic does not
     * allow to define static members, e.g.:
     *
     * protected static List<T> store = new ArrayList<T>();
     *
     * @return
     */
    protected abstract List<T> getStaticStore();

    protected boolean isManaged(T entity) {
        return getStaticStore().contains(entity);
    }

    @Override
    public T save(T entity) {
        if (!isManaged(entity)) {
            getStaticStore().add(entity);
        }
        return entity;
    }

    @Override
    public long size() {
        return getStaticStore().size();
    }

    @Override
    public List<T> all() {
        return getStaticStore();
    }

    protected abstract boolean matches(T entity, PK id);

    @Override
    public T findById(PK id) {
        for (T one : getStaticStore()) {
            if (matches(one, id)) {
                return one;
            }
        }
        return null;
    }
}
