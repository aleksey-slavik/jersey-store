package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.common.Command;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Order;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

public class OrderExecutor implements ExecutorInterface<Order> {

    public List<Order> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Order>>(){});
        else
            throw new EmptyResponseException();
    }

    public Order findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Order>(){});
        else
            throw new EmptyResponseException();

    }

    public List<Order> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Order>>(){});
        else
            throw new EmptyResponseException();
    }

    public Order delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Order>(){});
        else
            throw new EmptyResponseException();
    }
}
