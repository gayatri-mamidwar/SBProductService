package com.gayatri.productservice.services;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.models.Product;
import java.util.List;

public interface ProductServiceInterface {

     //changing createProduct return type from void to Product just for testing purpose
     Product createProduct(CreateProductDto createProductDto);

     List<Product> getAllProducts();
     Product getSingleProduct(long id);
     void updateProduct(long id, CreateProductDto createProductDto);
     void deleteProduct(long id);
}
