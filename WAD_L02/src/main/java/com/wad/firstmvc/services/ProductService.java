package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    List<Product> findProducts(String category, Double minPrice, Double maxPrice);
}