package com.globallogic.store.jersey.common;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class ClientInstance {

    private static ClientInstance instance = null;
    private Client client;
    private ClientConfig config;

    private ClientInstance() {
        config = new DefaultClientConfig();
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
