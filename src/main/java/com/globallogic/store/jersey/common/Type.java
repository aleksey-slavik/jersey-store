package com.globallogic.store.jersey.common;

import com.globallogic.store.jersey.exception.IllegalTypeException;

public enum Type {

    USERS("users"),
    PRODUCTS("products"),
    ORDERS("orders");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Type getByKey(String key) throws IllegalTypeException {
        for (Type type : Type.values()) {
            if (type.getType().equals(key)) {
                return type;
            }
        }

        throw new IllegalTypeException();
    }
}
