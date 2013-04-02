/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.persistence.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author Paulo Gandra Sousa
 *
 * based on
 * http://stackoverflow.com/questions/3888575/single-dao-generic-crud-methods-jpa-hibernate-spring
 * and on https://burtbeckwith.com/blog/?p=40
 */
public abstract class HibernateRepository<T, PK extends Serializable> {

    @PersistenceUnit
    static protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("eapli.expensemanagerPU");

    ;
    
    protected EntityManager getEntityManager() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }
    protected Class<T> entityClass;

    public HibernateRepository() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    public T create(T t) {
        this.getEntityManager().persist(t);
        return t;
    }

    public T read(PK id) {
        return this.getEntityManager().find(entityClass, id);
    }

    public T update(T t) {
        return this.getEntityManager().merge(t);
    }

    public void delete(T t) {
        t = this.getEntityManager().merge(t);
        this.getEntityManager().remove(t);
    }

    public long getCount() {
        return (Long) getEntityManager().createQuery(
                "SELECT COUNT(*) FROM " + entityClass.getSimpleName())
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public Collection<T> findAll() {
        return getEntityManager().createQuery(
                "FROM " + entityClass.getName())
                .getResultList();
    }

    public void save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        EntityManager em = getEntityManager();
        assert em != null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();
    }

    public List<T> all() {
        // TODO check performance impact of this 'where' clause
        return match("1=1");
        
//        EntityManager em = getEntityManager();
//        assert em != null;
//
//        String tableName = entityClass.getName(); //entityClass.getAnnotation(Table.class).name();
//        Query q = em.createQuery("SELECT it FROM " + tableName + " it");
//        List<T> all = q.getResultList();
//        return all;
    }

    public List<T> match(String where) {
        EntityManager em = getEntityManager();
        assert em != null;

        String tableName = entityClass.getName(); //entityClass.getAnnotation(Table.class).name();
        Query q = em.createQuery("SELECT it FROM " + tableName + " it WHERE " + where);
        List<T> some = q.getResultList();
        return some;
    }
}
