package com.globallogic.store.jersey.common;

import com.globallogic.store.jersey.exception.IllegalTypeException;

/**
 * Enum of types of data to which queries will be executed.
 *
 * @author oleksii.slavik
 */
public enum Type {

    USERS("users"),
    PRODUCTS("products"),
    ORDERS("orders");

    /**
     * String representation of type
     */
    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * Find type by his string representation
     *
     * @param key string representation of command
     * @return type object
     * @throws IllegalTypeException throws when type don`t find by given key
     */
    public static Type getByKey(String key) throws IllegalTypeException {
        for (Type type : Type.values()) {
            if (type.getType().equals(key)) {
                return type;
            }
        }

        throw new IllegalTypeException();
    }
}
