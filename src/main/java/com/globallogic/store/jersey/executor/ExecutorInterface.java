package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.exception.EmptyResponseException;

import java.util.List;

public interface ExecutorInterface<T> {

    List<T> findAll() throws EmptyResponseException;

    T findById(Long id) throws EmptyResponseException;

    List<T> findByKey(String key) throws EmptyResponseException;

    T delete(Long id) throws EmptyResponseException;
}
