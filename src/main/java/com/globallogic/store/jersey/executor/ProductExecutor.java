package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.globallogic.store.jersey.model.Product;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Execute requests of products
 *
 * @author oleksii.slavik
 */
public class ProductExecutor implements ExecutorInterface<Product> {

    /**
     * Find list of all items
     *
     * @return list of all items
     * @throws EmptyResponseException throws when response is empty
     */
    public List<Product> findAll() throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Product>>(){});
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
    public Product findById(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Product>(){});
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
    public List<Product> findByKey(String key) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products/search/" + key);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<List<Product>>(){});
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
    public Product delete(Long id) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/products/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

        if (response.hasEntity())
            return response.getEntity(new GenericType<Product>(){});
        else
            throw new EmptyResponseException();
    }
}
