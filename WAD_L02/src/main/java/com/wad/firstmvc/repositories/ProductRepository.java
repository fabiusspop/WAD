package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    @Query("SELECT p FROM Product p WHERE p.category = ?1 AND p.price <= ?2")

    List<Product> filter(String category, Double maxPrice);

}
