package com.gayatri.productservice;

import com.gayatri.productservice.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

    //main() use to launch Apache tomcat server
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
