package com.globallogic.store.jersey.executor;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Callback for execute command
 *
 * @author oleksii.slavik
 */
public interface ExecutorCallback {
    ClientResponse execute();
}
