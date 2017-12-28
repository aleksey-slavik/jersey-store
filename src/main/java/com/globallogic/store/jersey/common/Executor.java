package com.globallogic.store.jersey.common;

import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Executor<T> {

    private Class<T> tClass;
    private Class<T[]> aClass;
    private Type type;

    public Executor(Class<T> tClass, Class<T[]> aClass, Type type) {
        this.tClass = tClass;
        this.aClass = aClass;
        this.type = type;
    }

    private List<T> findAll() {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType());
        return Arrays.asList(webResource.accept(MediaType.APPLICATION_JSON).get(aClass));
    }

    private T findById(Long id) {
        WebResource webResource = ClientInstance.getInstance().getClient().resource("http://localhost:8080/" + type.getType() + "/" + id);
        return webResource.accept(MediaType.APPLICATION_JSON).get(tClass);
    }

    public List<T> execute(Command command, String key) {
        switch (command) {
            case FIND_ALL:
                return findAll();
            case FIND_BY_ID:
                Long id = Long.valueOf(key);
                return Collections.singletonList(findById(id));
            case FIND_BY_KEY:
                break;
            case CREATE:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
        }

        throw new IllegalStateException();
    }
}
