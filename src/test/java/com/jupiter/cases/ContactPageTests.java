package com.jupiter.cases;

import com.jupiter.common.BaseTest;
import com.jupiter.pages.ContactPage;
import com.jupiter.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

import static com.jupiter.common.Pages.CONTACT_PAGE;
import static com.jupiter.common.Pages.HOME_PAGE;

public class ContactPageTests extends BaseTest {

    @Test
    public void TC_01_Validate_Errors_Gone_After_Fill_Mandatory_Fields() {
        HomePage homePage = (HomePage) jupterPageFactory.getWebPage(HOME_PAGE);
        homePage.clickContact();
        ContactPage contactPage = (ContactPage) jupterPageFactory.getWebPage(CONTACT_PAGE);
        contactPage.clickSubmitBtn();
        Assert.assertTrue(contactPage.getErrorMessage().contains(contactPage.ERROR_MESSAGE));
        contactPage.populateMandatoryFields(dataProvider.contactInfo);
        Assert.assertTrue(contactPage.getInfoMessage().contains(contactPage.INFO_MESSAGE));
    }

    @Test
    public void TC_02_Validate_Submission_Message_After_Fill_Mandatory_Fields() {
        HomePage homePage = (HomePage) jupterPageFactory.getWebPage(HOME_PAGE);
        homePage.clickContact();
        ContactPage contactPage = (ContactPage) jupterPageFactory.getWebPage(CONTACT_PAGE);
        contactPage.populateMandatoryFields(dataProvider.contactInfo);
        contactPage.clickSubmitBtn();
        contactPage.waitForSuccessMessageDisplay();
        Assert.assertTrue(contactPage.getSuccessMessage().contains(contactPage.SUCCESS_MESSAGE));
    }
}
