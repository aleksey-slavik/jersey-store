package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

public class ExecutorTemplate<T> {

    public T execute(ExecutorCallback executorCallback) throws EmptyResponseException {
        ClientResponse response = executorCallback.execute();

        if (response.hasEntity())
            return response.getEntity(new GenericType<T>(){});
        else
            throw new EmptyResponseException();
    }
}
