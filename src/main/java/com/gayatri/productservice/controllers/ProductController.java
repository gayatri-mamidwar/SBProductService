package com.gayatri.productservice.controllers;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.dtos.FakeStoreProductDto;
import com.gayatri.productservice.models.Product;
import com.gayatri.productservice.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductServiceInterface productServiceInterface;
    private RestTemplate restTemplate;

    //If u have many service classes then use @Qualifier to know compiler which service to use
    public ProductController(@Qualifier("fakeStoreProductService") ProductServiceInterface productServiceInterface){
        this.productServiceInterface = productServiceInterface;
    }

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

    //update single product details.
     @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody CreateProductDto createProductDto) {
            try {
                Product existingProduct = productServiceInterface.getSingleProduct(id);

                if (existingProduct == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).
                            body("Product not found. Use POST to create a new product.");
                /*
                can't use like below to createproduct if its null. use PUT method just for updation
                productServiceInterface.createProduct(createProductDto);
                return ResponseEntity.ok("Product created successfully.");
                 */
                }

                productServiceInterface.updateProduct(id, createProductDto);
                return ResponseEntity.ok("Product updated successfully.");
            }

            catch (Exception e) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product with id = " + id + " not found ");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to update product: " + e.getMessage());
            }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productServiceInterface.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

}

/* IMP-
    API => methods in controller class
    RestController => controller which following rest practices i.e. GET, PUT,POST, DELETE
    Access Modifiers of methods should be public.
 */