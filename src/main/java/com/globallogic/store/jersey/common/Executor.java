package com.globallogic.store.jersey.common;

import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

public class Executor<T> {

    private Type type;

    public Executor(Type type) {
        this.type = type;
    }

    private List<T> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType());
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<T>>(){});
        else
            throw new EmptyResponseException();
    }

    private T findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<T>(){});
        else
            throw new EmptyResponseException();

    }

    private List<T> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/search/" + key);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<T>>(){});
        else
            throw new EmptyResponseException();
    }

    private T delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<T>(){});
        else
            throw new EmptyResponseException();
    }

    public List<T> execute(Command command, String key) throws EmptyResponseException {
        switch (command) {
            case FIND_ALL:
                return findAll();
            case FIND_BY_ID:
                Long id = Long.valueOf(key);
                return Collections.singletonList(findById(id));
            case FIND_BY_KEY:
                return findByKey(key);
            case DELETE:
                id = Long.valueOf(key);
                return Collections.singletonList(delete(id));
        }

        throw new IllegalStateException();
    }
}
