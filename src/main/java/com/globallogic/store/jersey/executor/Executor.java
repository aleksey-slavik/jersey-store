package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.common.Type;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class Executor<T> implements ExecutorInterface<T> {

    private Type type;

    public Executor(Type type) {
        this.type = type;
    }

    public List<T> findAll() throws EmptyResponseException {
        return new ExecutorTemplate<List<T>>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType());
                return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            }
        });
    }

    public T findById(final Long id) throws EmptyResponseException {
        return new ExecutorTemplate<T>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/" + id);
                return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            }
        });
    }

    public List<T> findByKey(final String key) throws EmptyResponseException {
        return new ExecutorTemplate<List<T>>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/search/" + key);
                return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            }
        });
    }

    public T delete(final Long id) throws EmptyResponseException {
        return new ExecutorTemplate<T>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/" + id);
                return webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
            }
        });
    }
}
