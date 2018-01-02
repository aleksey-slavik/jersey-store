package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Entity;

import java.util.List;

public interface ExecutorInterface<T extends Entity> {

    List<T> findAll() throws EmptyResponseException;

    T findById(Long id) throws EmptyResponseException;

    List<T> findByKey(String key) throws EmptyResponseException;

    T delete(Long id) throws EmptyResponseException;
}
