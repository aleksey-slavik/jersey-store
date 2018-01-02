package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.common.Command;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.User;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

public class UserExecutor implements ExecutorInterface<User> {

    public List<User> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<User>>(){});
        else
            throw new EmptyResponseException();
    }

    public User findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<User>(){});
        else
            throw new EmptyResponseException();

    }

    public List<User> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<User>>(){});
        else
            throw new EmptyResponseException();
    }

    public User delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<User>(){});
        else
            throw new EmptyResponseException();
    }
}
