package com.example.mvcproducts.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    public Cart(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }
}
