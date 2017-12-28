package com.globallogic.store.jersey.common;

public enum Type {

    USERS("users"),
    PRODUCTS("products"),
    ORDERS("orders");

    String type;

    Type(String type) {
        this.type = type;
    }
}
