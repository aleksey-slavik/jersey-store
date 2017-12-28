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
}
