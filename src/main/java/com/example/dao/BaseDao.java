package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Base DAO with common CRUD operations
 */
@Repository
public abstract class BaseDao<T, ID extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    // ==================== CRUD Operations ====================

    public void save(T entity) {
        getCurrentSession().save(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    @SuppressWarnings("unchecked")
    public T findById(ID id) {
        return (T) getCurrentSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        String hql = "FROM " + entityClass.getSimpleName();
        return getCurrentSession().createQuery(hql).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByPage(int page, int pageSize) {
        String hql = "FROM " + entityClass.getSimpleName();
        return getCurrentSession()
                .createQuery(hql)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    public long count() {
        String hql = "SELECT COUNT(*) FROM " + entityClass.getSimpleName();
        return (Long) getCurrentSession().createQuery(hql).uniqueResult();
    }
}
