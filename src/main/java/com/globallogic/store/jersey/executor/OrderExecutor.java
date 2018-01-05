package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Order;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Execute requests of orders
 *
 * @author oleksii.slavik
 */
public class OrderExecutor implements DAOAccessible<Order> {

    /**
     * Find list of all items
     *
     * @return list of all items
     * @throws EmptyResponseException throws when response is empty
     */
    public List<Order> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Order>>(){});
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
    public Order findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Order>(){});
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
    public List<Order> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Order>>(){});
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
    public Order delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Order>(){});
        else
            throw new EmptyResponseException();
    }
}
