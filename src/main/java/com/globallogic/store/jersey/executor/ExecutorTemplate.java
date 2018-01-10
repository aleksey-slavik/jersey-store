package com.globallogic.store.jersey.executor;

import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.exception.EmptyResponseException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/**
 * Executor template
 *
 * @author oleksii.slavik
 */
public class ExecutorTemplate {

    /**
     * Execute request
     *
     * @param executable executor details
     * @return response entity
     * @throws EmptyResponseException throws when response is empty
     */
    public ClientResponse execute(Executable executable) throws EmptyResponseException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource(executable.restPath());
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.hasEntity())
            return response;
        else
            throw new EmptyResponseException();
    }
}
