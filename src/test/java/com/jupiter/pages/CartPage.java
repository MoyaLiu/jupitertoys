package com.jupiter.pages;

import com.jupiter.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//strong[@class='total ng-binding']")
    private WebElement totalPrice;

    @FindBy(className = "cart-item")
    private List<WebElement> products;

    private HashMap<String, Product> productHashMap = new HashMap();

    public CartPage(WebDriver webDriver) {
        super(webDriver);

        initProductHashMap();
    }

    private void initProductHashMap() {
        for (WebElement product : products) {
            List<WebElement> tds = product.findElements(By.tagName("td"));
            String title = tds.get(0).getText();
            String price = tds.get(1).getText();
            String quantity = findChildElement(tds.get(2), By.tagName("input")).getAttribute("value");
            String subtotal = tds.get(3).getText();
            productHashMap.put(title, new Product(title, price, quantity, subtotal));
        }
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public String getProductPrice(String productName) {
        Product product = productHashMap.get(productName);
        return product.price;
    }

    public String getProductName(String productName) {
        Product product = productHashMap.get(productName);
        return product.title;
    }

    public String getProductQuantity(String productName) {
        Product product = productHashMap.get(productName);
        return product.quantity;
    }

    public String getProductSubtotal(String productName) {
        Product product = productHashMap.get(productName);
        return product.subtotal;
    }

    class Product {
        String title;
        String price;
        String quantity;
        String subtotal;

        public Product(String title, String price, String quantity, String subtotal) {
            this.title = title;
            this.price = price;
            this.quantity = quantity;
            this.subtotal = subtotal;
        }
    }

}
