package com.jupter.common;

import com.jupter.pages.CartPage;
import com.jupter.pages.ContactPage;
import com.jupter.pages.HomePage;
import com.jupter.pages.ShopPage;
import org.openqa.selenium.WebDriver;

public class JupterPageFactory {
    private final WebDriver driver;

    public JupterPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getWebPage(Pages pages) {
        switch (pages) {
            case HOME_PAGE:
                return new HomePage(driver);
            case CART_PAGE:
                return new CartPage(driver);
            case SHOP_PAGE:
                return new ShopPage(driver);
            case CONTACT_PAGE:
                return new ContactPage(driver);
            default:
                return null;
        }
    }
}
