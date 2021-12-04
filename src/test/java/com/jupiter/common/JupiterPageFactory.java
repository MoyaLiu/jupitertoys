package com.jupiter.common;

import com.jupiter.pages.CartPage;
import com.jupiter.pages.ContactPage;
import com.jupiter.pages.HomePage;
import com.jupiter.pages.ShopPage;
import org.openqa.selenium.WebDriver;

public class JupiterPageFactory {
    private final WebDriver driver;

    public JupiterPageFactory(WebDriver driver) {
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
