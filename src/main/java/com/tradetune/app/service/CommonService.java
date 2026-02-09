package com.tradetune.app.service;

import java.util.List;
import java.util.Optional;

public interface CommonService<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    boolean deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}