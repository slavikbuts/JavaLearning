package automationPractice.tests.contactUsTests;

import automationPractice.pages.ContactUsPage;
import automationPractice.pages.HomePage;
import automationPractice.pages.LoginPage;
import automationPractice.setup.Utilities;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

public class ContactUsTest extends ContactUsPage {

    static Utilities utilities = new Utilities();


    @BeforeClass
    public static void before() throws IOException {
        setUpChromeDriver();
        navigateTo(utilities.getProperty("url"));
        HomePage homePage = new HomePage();
        homePage.clickOnSignInButtonOnHomePage();
        LoginPage loginPage = new LoginPage();
        loginPage.setEmail(utilities.getProperty("correct.email"));
        loginPage.setPassword(utilities.getProperty("correct.password"));
        loginPage.clickOnSubmitButton();
        homePage.clickOnContactLinkOnHomePage();
    }

    @AfterClass
    public static void after(){
        closeChromeDriver();
    }

    @Test
    public void verifySuccessfulSendingMessage() {
        String alertMessage = "Your message has been successfully sent to our team.";
        selectSubject("Webmaster");
        typeMessage("some text for testing");
        clickSendButton();

        Assert.assertTrue("Expected alert message to be " + alertMessage + " ,but instead was "
                + getAlertMessage(), getAlertMessage().equals(alertMessage));

    }




}
