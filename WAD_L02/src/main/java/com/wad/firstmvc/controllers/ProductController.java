package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String viewProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String showAddProductForm(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/new")
    public String addProduct(Product product){
        if(product.getId() == null)
            product.setId(new Random().nextLong());
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/find")
    public String showFindProductForm(){
        return "findproducts";
    }

    @PostMapping("/find")
    public String findProducts(String category, Double minPrice, Double maxPrice, Model model){
        model.addAttribute("products", productService.findProducts(category, minPrice, maxPrice));
        return "products";
    }
}