package com.globallogic.store.jersey.common;

import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class Executor<T> {

    private Class<T> aClass;
    private Type type;

    public Executor(Class<T> aClass, Type type) {
        this.aClass = aClass;
        this.type = type;
    }

    private T findAll() {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType());
        return webResource.accept(MediaType.APPLICATION_JSON).get(aClass);
    }

    public T execute(Command command) {
        switch (command){
            case FIND_ALL:
                return findAll();
        }

        throw new IllegalStateException();
    }
}
