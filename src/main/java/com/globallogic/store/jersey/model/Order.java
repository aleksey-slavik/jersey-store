package com.globallogic.store.jersey.model;

import java.util.List;

/**
 * Order bean
 *
 * @author oleksii.slavik
 */
public class Order extends Entity {

    /**
     * Total cost of order
     */
    private Double totalCost;

    /**
     * User, which make order
     */
    private User user;

    /**
     * Order status
     */
    private String status;

    /**
     * Product items of order
     */
    private List<Product> products;

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

    /**
     * Header of table
     *
     * @return row of table
     */
    @Override
    public String header() {
        return row("Id", "Total cost", "Username", "Status", "Count of items");
    }

    /**
     * Separator between table rows
     *
     * @return string representation of separator
     */
    @Override
    public String separator() {
        return null;
    }

    /**
     * Formatted representation of order bean for console output
     *
     * @return string representation of order bean
     */
    @Override
    public String toString() {
        return row(Long.toString(getId()), Double.toString(totalCost), user.getUsername(), status, Integer.toString(products.size()));
    }


}
