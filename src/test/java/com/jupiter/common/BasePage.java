package com.jupiter.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void waitElementDisplay(WebElement element) {
        WebDriverExtension.waitForDisplayed(webDriver, element, 20);
    }

    public WebElement findChildElement(WebElement element, By by) {
        return WebDriverExtension.findChildElement(element, by);
    }

    public void clickElement(WebElement element) {
        WebDriverExtension.waitForClickable(webDriver, element).click();
    }

    public void enterKeysElement(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    public String getText(WebElement element) {
        return element.getText();
    }
}
