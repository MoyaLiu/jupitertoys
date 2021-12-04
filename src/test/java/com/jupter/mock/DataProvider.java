package com.jupter.mock;

import com.jupter.models.ContactInfo;
import com.jupter.models.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public final ContactInfo contactInfo = new ContactInfo("Jhone", "123@123.com", "test");

    public List<ProductInfo> getProductInfoListTC3(){
        List<ProductInfo> products = new ArrayList<ProductInfo>();
        products.add(new ProductInfo("Funny Cow","$10.99", 2));
        products.add(new ProductInfo("Fluffy Bunny","$9.99", 1));
        return products;
    }
    public List<ProductInfo> getProductInfoListTC4(){
        List<ProductInfo> products = new ArrayList<ProductInfo>();
        products.add(new ProductInfo("Stuffed Frog","$10.99", 3));
        products.add(new ProductInfo("Fluffy Bunny","$9.99", 5));
        products.add(new ProductInfo("Valentine Bear","$14.99", 2));
        return products;
    }
}
