package com.gayatri.productservice.models;

import java.util.List;

public class Category extends BaseModel{

    private String title;
    private List<Product> products;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

/* Product & category cardinality
product  category
1           1
M           1
So, M:1 relation. Add category in product class
 */