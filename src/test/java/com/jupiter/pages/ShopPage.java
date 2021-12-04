package com.jupiter.pages;

import com.jupiter.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//a[@href='#/cart']")
    private WebElement cartPageLink;

    @FindBy(className = "product")
    private List<WebElement> products;

    private HashMap<String, Product> productHashMap = new HashMap();

    public ShopPage(WebDriver webDriver) {
        super(webDriver);
        System.out.println("product:" + products);
        initProductHashMap();
    }

    private void initProductHashMap() {
        for (WebElement product : products) {
            String id = product.getAttribute("id");
            String title = findChildElement(product, By.className("product-title")).getText();
            String price = findChildElement(product, By.className("product-price")).getText();
            WebElement buyBtn = findChildElement(product, By.className("btn"));
            productHashMap.put(title, new Product(title, price, id, buyBtn));
        }
    }

    public void purchase(String productName, int quantity) {
        Product product = productHashMap.get(productName);
        for (int i = 0; i < quantity; i++) {
            clickElement(product.buyBtn);
        }
    }

    public String getProductPrice(String productName) {
        Product product = productHashMap.get(productName);
        return product.price;
    }

    public void clickCartBtn() {
        clickElement(cartPageLink);
    }

    class Product {
        String title;
        String price;
        String id;
        WebElement buyBtn;

        public Product(String title, String price, String id, WebElement buyBtn) {
            this.title = title;
            this.price = price;
            this.id = id;
            this.buyBtn = buyBtn;
        }
    }
}
