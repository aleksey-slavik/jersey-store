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

public class OrderExecutor {

    private List<Order> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Order>>(){});
        else
            throw new EmptyResponseException();
    }

    private Order findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Order>(){});
        else
            throw new EmptyResponseException();

    }

    private List<Order> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Order>>(){});
        else
            throw new EmptyResponseException();
    }

    private Order delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/orders/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Order>(){});
        else
            throw new EmptyResponseException();
    }

    public List<Order> execute(Command command, String key) throws EmptyResponseException {
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
