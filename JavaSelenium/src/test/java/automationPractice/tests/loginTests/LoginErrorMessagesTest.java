package automationPractice.tests.loginTests;

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

public class LoginErrorMessagesTest extends BaseTest {
  protected WebDriver driver = getDriver();
  static Utilities utilities = new Utilities();
  LoginPage loginPage = new LoginPage(driver);

  @BeforeClass
  public void before() throws IOException {
    loginPage.navigateTo(utilities.getProperty("url"));
    HomePage homePage = new HomePage(driver);
    homePage.clickOnSignInButtonOnHomePage();
  }

  @Test
  public void verifyLoginWithoutPassword() throws IOException {
    loginPage.setEmail(utilities.getProperty("correct.email"));
    loginPage.clearPasswordField();
    loginPage.clickOnSubmitButton();

    String expectedErrorMessage = "Password is required.";

    Assert.assertTrue(
        loginPage.getErrorMessage().equals(expectedErrorMessage),
        "Expected error message be "
            + expectedErrorMessage
            + ", but instead was "
            + loginPage.getErrorMessage());
  }

  @Test
  public void verifyLoginWithoutEmail() throws IOException {
    loginPage.clearEmailField();
    loginPage.setPassword(utilities.getProperty("correct.password"));
    loginPage.clickOnSubmitButton();

    String expectedErrorMessage = "An email address required.";

    Assert.assertTrue(
        loginPage.getErrorMessage().equals(expectedErrorMessage),
        "Expected error message be "
            + expectedErrorMessage
            + ", but instead was "
            + loginPage.getErrorMessage());
  }

  @Test
  public void verifyLoginWitIncorrectPassword() throws IOException {
    loginPage.setEmail(utilities.getProperty("correct.email"));
    loginPage.setPassword(utilities.getProperty("incorrect.password"));
    loginPage.clickOnSubmitButton();

    String expectedErrorMessage = "Authentication failed.";

    Assert.assertTrue(
        loginPage.getErrorMessage().equals(expectedErrorMessage),
        "Expected error message be "
            + expectedErrorMessage
            + ", but instead was "
            + loginPage.getErrorMessage());
  }

  @Test
  public void verifyLoginWithIncorrectEmail() throws IOException {
    loginPage.setEmail(utilities.getProperty("incorrect.email"));
    loginPage.setPassword(utilities.getProperty("correct.password"));
    loginPage.clickOnSubmitButton();

    String expectedErrorMessage = "Invalid email address.";

    Assert.assertTrue(
        loginPage.getErrorMessage().equals(expectedErrorMessage),
        "Expected error message be "
            + expectedErrorMessage
            + ", but instead was "
            + loginPage.getErrorMessage());
  }
}
