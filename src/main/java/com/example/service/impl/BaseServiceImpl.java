package com.example.service.impl;

import com.example.dao.BaseDao;
import com.example.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Base Service Implementation
 */
@Transactional
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    protected abstract BaseDao<T, ID> getDao();

    @Override
    public void save(T entity) {
        getDao().save(entity);
    }

    @Override
    public void update(T entity) {
        getDao().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getDao().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        getDao().deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return getDao().findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findByPage(int page, int pageSize) {
        return getDao().findByPage(page, pageSize);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getDao().count();
    }
}
