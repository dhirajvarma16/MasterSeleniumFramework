package org.selenium.pom.objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class Product {
    private int id;
    private String productName;

    public Product(int id) throws IOException {
        Product[] products=JacksonUtils.deserializeJson("products.json", Product[].class);
        for (Product product:products){
            if (getId()==id)
            {
            this.id=id;
            this.productName=product.getProductName();
            }
        }
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
