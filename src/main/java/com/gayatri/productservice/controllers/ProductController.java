package com.gayatri.productservice.controllers;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.models.Product;
import com.gayatri.productservice.services.ProductServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductServiceInterface productServiceInterface;

    public ProductController(ProductServiceInterface productServiceInterface){
        this.productServiceInterface = productServiceInterface;
    }
    /*
    API => methods in controller class
    RestController => controller which following rest practices i.e. GET, PUT,POST, DELETE
    Access Modifiers of methods should be public.
     */

    /*
    GET /products : get all products
     */

    //    @RequestMapping(value = "/products", method = RequestMethod.GET)      //.. old way of writing GET
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServiceInterface.getAllProducts();
    }

    /*
    GET /products/{id} : get single product
     */
    @GetMapping("/products/{id}")       //getmapping variable & pathvari name should be same
    public Product getSingleProduct(@PathVariable("id") long id){
        return productServiceInterface.getSingleProduct(id);
    }

    /*
    POST /products : create a new product
    {
        title : ____,
        description : ____,
        image_url : ____,
        .
        .
        .
    }
     */
    @PostMapping("/products")
    public void createProduct(CreateProductDto createProductDto){
        productServiceInterface.createProduct(createProductDto);
    }

}
