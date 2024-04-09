package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;
  private static final Logger log = LoggerFactory.getLogger(ProductController.class);

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String seeProducts(Model model, Authentication authentication) {
    model.addAttribute("products", productService.findAll());
    User user = (User) authentication.getPrincipal();
    log.info(user.getUsername());
    return "products";
  }

  @PostMapping
  public String addProduct(Product product) {
    log.info(product.toString());
    productService.save(product);
    return "redirect:/products";
  }

}