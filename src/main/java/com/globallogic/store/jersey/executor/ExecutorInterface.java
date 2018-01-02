package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Entity;

import java.util.List;

/**
 * Interface with executor logic of given type
 *
 * @param <T> given type
 * @author oleksii.slavik
 */
public interface ExecutorInterface<T extends Entity> {

    /**
     * Find list of all items
     *
     * @return list of all items
     * @throws EmptyResponseException throws when response is empty
     */
    List<T> findAll() throws EmptyResponseException;

    /**
     * Find item by given id
     *
     * @param id given item id
     * @return item with given id
     * @throws EmptyResponseException throws when response is empty
     */
    T findById(Long id) throws EmptyResponseException;

    /**
     * Find list of items by given key
     *
     * @param key given key
     * @return list of found items
     * @throws EmptyResponseException throws when response is empty
     */
    List<T> findByKey(String key) throws EmptyResponseException;

    /**
     * Delete item with given id
     *
     * @param id given item id
     * @return deleted item
     * @throws EmptyResponseException throws when response is empty
     */
    T delete(Long id) throws EmptyResponseException;
}
