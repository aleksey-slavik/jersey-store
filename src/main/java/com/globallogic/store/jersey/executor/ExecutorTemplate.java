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
     * @param executable executor details
     * @return response entity
     * @throws EmptyResponseException throws when response is empty
     */
    public T execute(Executable executable) throws EmptyResponseException {
        ClientResponse response = executable.execute();

        if (response.hasEntity())
            return response.getEntity(new GenericType<T>() {
            });
        else
            throw new EmptyResponseException();
    }
}
