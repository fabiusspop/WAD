package com.wad.firstmvc;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repositories.ProductRepository;
import com.wad.firstmvc.repositories.UserRepository;
import com.wad.firstmvc.services.ProductService;
import com.wad.firstmvc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    public final UserService userService;
    public final ProductService productService;

    public DataLoader(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList(List.of(
                new User(1L, "John", "john@yahoo.com"),
                new User(2L, "Jane", "jane@yahoo.com"),
                new User(3L, "Jim", "jim@yahoo.com"))
        );

        for ( User u : users ){
            this.userService.save(u);
        }

        List<Product> products = new ArrayList(List.of(

                new Product("Car", 200.0, "Vehicles"),
                new Product("Boeing707", 1000.0, "Planes")));


        for ( Product p : products){
            this.productService.save(p);
        }

    }
}
