package com.gayatri.productservice.services;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.dtos.FakeStoreProductDto;
import com.gayatri.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductServiceInterface{

    //RestTemplate is used to call 3rd party API's. restTemplate is a way to contact the internet & get the data
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    /*
    This method is used to call 3rd party API to fetch the data.
    using RestTemplate getForObject() we can call 3rd party API.
    https://fakestoreapi.com/products/

    whatever details you will get from this method put it in FakeStoreProductDto class.
     */
    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public void createProduct(CreateProductDto createProductDto) {

    }
}

/* Could not autowire. No bean of 'RestTemplate' is found. if we get this error. we need to create
custom config class & create bean manually.
 */