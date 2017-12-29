package com.globallogic.store.jersey.executor;

import com.sun.jersey.api.client.ClientResponse;

public interface ExecutorCallback {
    ClientResponse execute();
}
