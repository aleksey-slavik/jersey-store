package com.globallogic.store.jersey.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Product {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private static String format = "%5s|%15s|%15s|%15s|%15s";

    public static String header() {
        return String.format(format, "id", "name", "brand", "description", "price");
    }

    public static String separator() {
        return "-------------------------------------------------------------------------";
    }

    @Override
    public String toString() {
        return String.format(format, id, name, brand, description, price);
    }
}
