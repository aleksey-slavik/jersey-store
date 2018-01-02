package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.common.Command;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Product;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

public class ProductExecutor implements ExecutorInterface<Product> {

    public List<Product> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Product>>(){});
        else
            throw new EmptyResponseException();
    }

    public Product findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Product>(){});
        else
            throw new EmptyResponseException();

    }

    public List<Product> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Product>>(){});
        else
            throw new EmptyResponseException();
    }

    public Product delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Product>(){});
        else
            throw new EmptyResponseException();
    }
}
