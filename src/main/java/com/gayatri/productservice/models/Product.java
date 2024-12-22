package com.gayatri.productservice.models;

public class Product extends BaseModel {

    //Always declare class variables as private
    private String title;
    private String description;
    private double price;
    private Category category;          //bcz of cardinality we are adding Category datatype i.e.category obj. in product
    private String imageUrl;

    //in o/p we are getting sequence as per return Entity/Model contructor parameters
    public Product(String title, double price, Category category, String description, String imageUrl) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    //variable names should be same as per Product setter method sequence.
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

/* imp-
To make private variables accessible to outside world. create getter & setter functions for it
@Getter, @Setter, @AllArgConstructor, @NoArgConstructor ==>> Provided by Lombok. & This are Class level constructors
 */