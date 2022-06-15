package automationPractice.tests.contactUsTests;

import automationPractice.pages.ContactUsPage;
import automationPractice.pages.HomePage;
import automationPractice.pages.LoginPage;
import automationPractice.setup.Utilities;
import automationPractice.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static automationPractice.setup.WebDriverSettings.getDriver;

public class ContactUsTest extends BaseTest {
  protected WebDriver driver = getDriver();
  static Utilities utilities = new Utilities();
  LoginPage loginPage = new LoginPage(driver);

  ContactUsPage contactUsPage = new ContactUsPage(driver);

  @BeforeClass
  public void before() throws IOException {
    loginPage.navigateTo(utilities.getProperty("url"));
    HomePage homePage = new HomePage(driver);
    homePage.clickOnSignInButtonOnHomePage();
    loginPage.setEmail(utilities.getProperty("correct.email"));
    loginPage.setPassword(utilities.getProperty("correct.password"));
    loginPage.clickOnSubmitButton();
    homePage.clickOnContactLinkOnHomePage();
  }

  @Test
  public void verifySuccessfulSendingMessage() {

    String alertMessage = "Your message has been successfully sent to our team.";
    contactUsPage.selectSubject("Webmaster");
    contactUsPage.typeMessage("some text for testing");
    contactUsPage.clickSendButton();

    Assert.assertTrue(
        contactUsPage.getAlertMessage().equals(alertMessage),
        "Expected alert message to be "
            + alertMessage
            + " ,but instead was "
            + contactUsPage.getAlertMessage());
  }
}
