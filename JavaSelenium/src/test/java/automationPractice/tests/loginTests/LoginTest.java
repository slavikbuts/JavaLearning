package automationPractice.tests.loginTests;

import automationPractice.pages.HomePage;
import automationPractice.pages.LoginPage;
import automationPractice.setup.Utilities;
import automationPractice.tests.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static automationPractice.setup.WebDriverSettings.getDriver;

public class LoginTest extends BaseTest {
  protected WebDriver driver = getDriver();

  static Utilities utilities = new Utilities();
  public static Logger log = LogManager.getLogger();
  LoginPage loginPage = new LoginPage(driver);

  @BeforeTest
  public void before() throws IOException {
    log.info("Navigate to URL " + utilities.getProperty("url"));
    loginPage.navigateTo(utilities.getProperty("url"));
//    loginPage.getEmailField(); // for try lombok
    HomePage homePage = new HomePage(driver);
    log.info("Navigate to Login Page");
    homePage.clickOnSignInButtonOnHomePage();
  }

  @Test(priority = 1)
  public void verifySuccessfulLogin() throws IOException {
    String firstName = utilities.getProperty("first.name");
    String lastName = utilities.getProperty("last.name");
    log.info("Type Email address =>" + utilities.getProperty("correct.email"));
    loginPage.setEmail(utilities.getProperty("correct.email"));
    log.info("Type Password =>" + utilities.getProperty("correct.password"));
    loginPage.setPassword(utilities.getProperty("correct.password"));
    log.info("Click on 'Sign in' button");
    loginPage.clickOnSubmitButton();

    Assert.assertTrue(
        loginPage.getAccountName().equals(firstName + " " + lastName),
        "Expected Account name to be "
            + firstName
            + " "
            + lastName
            + " ,but instead was "
            + loginPage.getAccountName());
  }
}
