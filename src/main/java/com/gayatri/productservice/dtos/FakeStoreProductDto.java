package com.gayatri.productservice.dtos;

import com.gayatri.productservice.models.Category;
import com.gayatri.productservice.models.Product;

//Dto for fetching product details
public class FakeStoreProductDto {

    //variable names as per FakeStore API
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //Method to convert FakeStoreProductDto to Product. whatever values we are getting setting in product hence set() used
    public Product toProduct() {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);

        Category category1 = new Category();
        category1.setTitle(category);           //in this cls, category is of String type. so creating category1 obj
        product.setCategory(category1);

        product.setDescription(description);
        product.setImageUrl(image);

        return product;
    }


}
