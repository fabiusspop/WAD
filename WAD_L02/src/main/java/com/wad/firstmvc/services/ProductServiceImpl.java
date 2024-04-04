package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findProducts(String category, Double minPrice, Double maxPrice) {
        return products.stream()
                .filter(product -> (category == null || product.getCategory().equals(category)) &&
                        (minPrice == null || product.getPrice() >= minPrice) &&
                        (maxPrice == null || product.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }
}