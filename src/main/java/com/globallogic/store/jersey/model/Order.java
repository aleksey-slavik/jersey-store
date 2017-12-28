package com.globallogic.store.jersey.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class Order {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("totalCost")
    private Double totalCost;

    @JsonProperty("user")
    private User user;

    @JsonProperty("status")
    private String status;

    @JsonProperty("items")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private static String format = "%5s|%15s|%15s|%15s|%15s";

    public static String header() {
        return String.format(format, "id", "total cost", "username", "status", "items count");
    }

    public static String separator() {
        return "------------------------------------------------------------------------------------------------------";
    }

    @Override
    public String toString() {
        return String.format(format, id, totalCost, user.getUsername(), status, products.size());
    }
}
