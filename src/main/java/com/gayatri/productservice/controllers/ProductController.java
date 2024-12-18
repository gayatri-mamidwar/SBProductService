package com.gayatri.productservice.controllers;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.models.Product;
import com.gayatri.productservice.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductServiceInterface productServiceInterface;

    //If u have many service classes then use @Qualifier to know compiler which service to use
    public ProductController(@Qualifier("fakeStoreProductService") ProductServiceInterface productServiceInterface){
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
    //changing createProduct return type from void to Product just for testing purpose
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductDto createProductDto){
        return productServiceInterface.createProduct(createProductDto);
    }

    //update single product details if id not present create new product
//    @PutMapping("/products/{id}")
//    public Product updateProduct(@RequestBody CreateProductDto createProductDto, @PathVariable("id") long id){
//        return productServiceInterface.updateProduct(createProductDto, id);
//    }

}
