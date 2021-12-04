package com.jupter.pages;

import com.jupter.common.BasePage;
import com.jupter.models.ContactInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    public static final String ERROR_MESSAGE = "but we won't get it unless you complete the form correctly";
    public static final String INFO_MESSAGE = "tell it how it is";
    public static final String SUCCESS_MESSAGE = "we appreciate your feedback";

    @FindBy(xpath = "//a[@class='btn-contact btn btn-primary']")
    private WebElement submitBth;

    @FindBy(xpath = "//div[@class='alert alert-error ng-scope']")
    private WebElement errorMessageAlert;

    @FindBy(id = "forename")
    private WebElement forenameEditBox;

    @FindBy(id = "email")
    private WebElement emailEditBox;

    @FindBy(id = "message")
    private WebElement messageEditBox;

    @FindBy(xpath = "//div[@class='alert alert-info ng-scope']")
    private WebElement infoMessageAlert;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successMessageAlert;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmitBtn() {
        clickElement(submitBth);
    }

    public void enterForename(String forename) {
        enterKeysElement(forenameEditBox, forename);
    }

    public void enterEmail(String email) {
        enterKeysElement(emailEditBox, email);
    }

    public void enterMessage(String message) {
        enterKeysElement(messageEditBox, message);
    }

    public String getErrorMessage() {
        return getText(errorMessageAlert);
    }

    public String getInfoMessage() {
        return getText(infoMessageAlert);
    }

    public String getSuccessMessage() {
        return getText(successMessageAlert);
    }

    public void waitForSuccessMessageDisplay() {
        waitElementDisplay(successMessageAlert);
    }

    public void populateMandatoryFields(ContactInfo contactInfo) {
        enterForename(contactInfo.forename);
        enterEmail(contactInfo.email);
        enterMessage(contactInfo.message);
    }
}
