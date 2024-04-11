package com.ellos.backendtest.model.product;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products;
    private double averagePrice;

    public Products() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

}
