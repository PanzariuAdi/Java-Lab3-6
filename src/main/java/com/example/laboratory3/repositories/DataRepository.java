package com.example.laboratory3.repositories;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class DataRepository<T, Integer extends Serializable> implements Serializable {
    protected Class<T> entityClass;

    @PersistenceContext(unitName = "TPU")
    private EntityManager entityManager;

    protected DataRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PostConstruct
    protected void init() {}

    public void persist(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void remove(T entity) {
        if(!entityManager.contains(entity)) {
            entity = entityManager.merge(entity);
        }
        entityManager.remove(entity);
    }

    public T findById(int id) {
        return entityManager.find(entityClass, id);
    }

    public void clearCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }

    public List<T> findAll() {
        return getResultList(entityClass.getSimpleName() + ".findAll");
    }

    public List<T> getResultList(String namedQuery) {
        return entityManager.createNamedQuery(namedQuery, entityClass).getResultList();
    }

}
