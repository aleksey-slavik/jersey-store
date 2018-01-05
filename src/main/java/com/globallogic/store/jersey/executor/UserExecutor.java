package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.User;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Execute requests of users
 *
 * @author oleksii.slavik
 */
public class UserExecutor implements DAOAccessible<User> {

    /**
     * Find list of all items
     *
     * @return list of all items
     * @throws EmptyResponseException throws when response is empty
     */
    public List<User> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<User>>(){});
        else
            throw new EmptyResponseException();
    }

    /**
     * Find item by given id
     *
     * @param id given item id
     * @return item with given id
     * @throws EmptyResponseException throws when response is empty
     */
    public User findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<User>(){});
        else
            throw new EmptyResponseException();

    }

    /**
     * Find list of items by given key
     *
     * @param key given key
     * @return list of found items
     * @throws EmptyResponseException throws when response is empty
     */
    public List<User> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<User>>(){});
        else
            throw new EmptyResponseException();
    }

    /**
     * Delete item with given id
     *
     * @param id given item id
     * @return deleted item
     * @throws EmptyResponseException throws when response is empty
     */
    public User delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/users/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<User>(){});
        else
            throw new EmptyResponseException();
    }
}
