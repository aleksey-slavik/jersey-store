package com.globallogic.store.jersey.common;

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

    public static Type getByKey(String key) {
        for (Type type : Type.values()) {
            if (type.getType().equals(key)) {
                return type;
            }
        }

        throw new IllegalStateException();
    }
}
