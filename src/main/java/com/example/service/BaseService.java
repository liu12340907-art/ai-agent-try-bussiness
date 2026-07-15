package com.example.service;

import java.io.Serializable;
import java.util.List;

/**
 * Base Service interface
 */
public interface BaseService<T, ID extends Serializable> {

    void save(T entity);

    void update(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    void deleteById(ID id);

    T findById(ID id);

    List<T> findAll();

    List<T> findByPage(int page, int pageSize);

    long count();
}
