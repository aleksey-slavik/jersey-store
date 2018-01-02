package com.globallogic.store.jersey.common;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

/**
 * Jersey client instance
 *
 * @author oleksii.slavik
 */
public class ClientInstance {

    /**
     * Client instance
     */
    private static ClientInstance instance = null;

    /**
     * Jersey client
     */
    private Client client;

    /**
     * Create Jersey client
     */
    private ClientInstance() {
        ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(config);
    }

    /**
     * Get client instance
     *
     * @return client instance
     */
    public static ClientInstance getInstance() {
        if (instance == null) {
            instance = new ClientInstance();
        }

        return instance;
    }

    /**
     * Jersey client getter
     *
     * @return client
     */
    public Client getClient() {
        return client;
    }
}
