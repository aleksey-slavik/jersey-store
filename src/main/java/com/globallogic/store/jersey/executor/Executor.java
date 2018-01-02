package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.common.Type;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Entity;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Execute request of given type
 *
 * @param <T> given type
 * @author oleksii.slavik
 */
public class Executor<T extends Entity> implements ExecutorInterface<T> {

    /**
     * Command type
     */
    private Type type;

    public Executor(Type type) {
        this.type = type;
    }

    /**
     * Find list of all items
     *
     * @return list of all items
     * @throws EmptyResponseException throws when response is empty
     */
    public List<T> findAll() throws EmptyResponseException {
        return new ExecutorTemplate<List<T>>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType());
                return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            }
        });
    }

    /**
     * Find item by given id
     *
     * @param id given item id
     * @return item with given id
     * @throws EmptyResponseException throws when response is empty
     */
    public T findById(final Long id) throws EmptyResponseException {
        return new ExecutorTemplate<T>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/" + id);
                return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            }
        });
    }

    /**
     * Find list of items by given key
     *
     * @param key given key
     * @return list of found items
     * @throws EmptyResponseException throws when response is empty
     */
    public List<T> findByKey(final String key) throws EmptyResponseException {
        return new ExecutorTemplate<List<T>>().execute(new ExecutorCallback() {
            @Override
            public ClientResponse execute() {
                WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/search/" + key);
                return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            }
        });
    }

    /**
     * Delete item with given id
     *
     * @param id given item id
     * @return deleted item
     * @throws EmptyResponseException throws when response is empty
     */
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
