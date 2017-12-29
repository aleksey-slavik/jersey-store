package com.globallogic.store.jersey.common;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

public class ClientInstance {

    private static ClientInstance instance = null;
    private Client client;

    private ClientInstance() {
        ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(config);
    }

    public static ClientInstance getInstance() {
        if (instance == null) {
            instance = new ClientInstance();
        }

        return instance;
    }

    public Client getClient() {
        return client;
    }
}
