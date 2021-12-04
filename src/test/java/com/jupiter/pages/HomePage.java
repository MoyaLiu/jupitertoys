package com.jupiter.pages;

import com.jupiter.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public static final String HOME_URL = "http://jupiter.cloud.planittesting.com";

    @FindBy(xpath = "//a[@href='#/contact']")
    private WebElement contactPageLink;
    @FindBy(xpath = "//a[@class='btn btn-success btn-large']")
    private WebElement startShoppingBtn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickContact() {
        clickElement(contactPageLink);
    }

    public void clickStartShoppingBtn() {
        clickElement(startShoppingBtn);
    }
}
