package com.gayatri.productservice.services;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.models.Product;

import java.util.List;

public interface ProductServiceInterface {

     List<Product> getAllProducts();
     Product getSingleProduct(long id);
     //changing createProduct return type from void to Product just for testing purpose
     Product createProduct(CreateProductDto createProductDto);
     Product updateProduct(CreateProductDto createProductDto, long id);
}
