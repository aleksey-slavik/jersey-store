package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

/**
 * Executor template
 *
 * @param <T> given type
 * @author oleksii.slavik
 */
public class ExecutorTemplate<T> {

    /**
     * Execute request
     *
     * @param executorCallback executor details
     * @return response entity
     * @throws EmptyResponseException throws when response is empty
     */
    public T execute(ExecutorCallback executorCallback) throws EmptyResponseException {
        ClientResponse response = executorCallback.execute();

        if (response.hasEntity())
            return response.getEntity(new GenericType<T>() {
            });
        else
            throw new EmptyResponseException();
    }
}
