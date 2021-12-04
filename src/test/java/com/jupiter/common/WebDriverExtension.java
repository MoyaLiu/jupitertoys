package com.jupiter.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverExtension {
    final static int TIME_IN_SECONDS = 2;
    final static int TIME_OUT_FOR_DISPLAY_iN_SECONDS = 2;

    public static WebElement findChildElement(WebElement element, By by) {
        try {
            WebElement webElement = element.findElement(by);
            return webElement;
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public static WebElement waitUntilTimeouts(WebDriver driver, ExpectedCondition<WebElement> condition, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            return wait.until(condition);
        } catch (TimeoutException e) {
            return null;
        }
    }

    public static WebElement waitForClickable(WebDriver driver, WebElement element, int timeoutInSenconds) {
        return waitUntilTimeouts(driver, ExpectedConditions.elementToBeClickable(element), timeoutInSenconds);
    }

    public static WebElement waitForClickable(WebDriver driver, WebElement element) {
        return waitForClickable(driver, element, TIME_IN_SECONDS);
    }

    public static WebElement waitForDisplayed(WebDriver driver, WebElement element) {
        return waitUntilTimeouts(driver, ExpectedConditions.visibilityOf(element), TIME_OUT_FOR_DISPLAY_iN_SECONDS);
    }

    public static WebElement waitForDisplayed(WebDriver driver, WebElement element, int timeOutInSeconds) {
        return waitUntilTimeouts(driver, ExpectedConditions.visibilityOf(element), timeOutInSeconds);
    }

    public static WebElement waitForElement(WebDriver driver, By by, int timeoutInSeconds) {
        return waitUntilTimeouts(driver, ExpectedConditions.presenceOfElementLocated(by), timeoutInSeconds);
    }

    public static WebElement waitForElement(WebDriver driver, By by) {
        return waitUntilTimeouts(driver, ExpectedConditions.presenceOfElementLocated(by), TIME_IN_SECONDS);
    }
}
