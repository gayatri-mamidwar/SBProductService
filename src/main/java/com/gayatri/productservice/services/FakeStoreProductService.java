package com.gayatri.productservice.services;

import com.gayatri.productservice.dtos.CreateProductDto;
import com.gayatri.productservice.dtos.FakeStoreProductDto;
import com.gayatri.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductServiceInterface{

    //RestTemplate is used to call 3rd party API's. restTemplate is a way to contact the internet & get the data
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    // Making a GET request to the API to fetch all products
    @Override
    public List<Product> getAllProducts() {

       //Getting an array of FakeStoreDto objects
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        // Converting the DTO list to the Product list and returning it
        List<Product> products = new ArrayList<>();

        //iterate over array & convert individual fakestoreproductDTO to product
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            Product product = fakeStoreProductDto.toProduct();
            products.add(product);
        }

        return products;
    }

    /*
    This method is used to call 3rd party API to fetch the data.
    using RestTemplate getForObject() we can call 3rd party API.
    https://fakestoreapi.com/products/

    whatever details you will get from this method put it in FakeStoreProductDto class.
     */
    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                                                                            FakeStoreProductDto.class);
        System.out.println("calling.....");
        return fakeStoreProductDto.toProduct();
    }

    /*
    This is just a dummy endpoint.
    changing createProduct return type from void to Product just for testing purpose
     */
    @Override
    public Product createProduct(CreateProductDto createProductDto) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(createProductDto.getTitle());
        fakeStoreProductDto.setPrice(createProductDto.getPrice());
        fakeStoreProductDto.setCategory(createProductDto.getCategory());
        fakeStoreProductDto.setDescription(createProductDto.getDescription());
        fakeStoreProductDto.setImage(createProductDto.getImage());

        //postForObject() takes 3 param 1st is url on which we are sending, 2nd object which we want to send, 3rd obj of which file
        FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products",
                                    fakeStoreProductDto,
                                    FakeStoreProductDto.class);

        System.out.println("fakestoreproductdto before return values...");
        return fakeStoreProductDto1.toProduct();
    }

    @Override
    public Product updateProduct(CreateProductDto createProductDto, long id) {
//        getSingleProduct(id);
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

//        fakeStoreProductDto.setTitle(c);
//                FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
//                                                                                CreateProductDto.class);

//      return fakeStoreProductDto.toProduct();
        return null;
    }
}

/* Could not autowire. No bean of 'RestTemplate' is found. if we get this error. we need to create
custom config class & create bean manually.
 */