package com.globallogic.store.jersey.model;

/**
 * User bean
 *
 * @author oleksii.slavik
 */
public class Product extends Entity {

    /**
     * Product name
     */
    private String name;

    /**
     * Product brand
     */
    private String brand;

    /**
     * Product description
     */
    private String description;

    /**
     * Priduct price
     */
    private Double price;

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

    /**
     * Header of table
     *
     * @return row of table
     */
    @Override
    public String header() {
        return row("Id", "Name", "Brand", "Description", "Price");
    }

    /**
     * Separator between table rows
     *
     * @return string representation of separator
     */
    @Override
    public String separator() {
        return separator(5);
    }

    /**
     * Formatted representation of order bean for console output
     *
     * @return string representation of order bean
     */
    @Override
    public String toString() {
        return row(Long.toString(getId()), name, brand, description, Double.toString(price));
    }
}
