package automationPractice.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  public static final String TITLE = "My Store";

  public HomePage() {
    Assert.assertTrue(
        "Expected Title to be " + TITLE + ", but instead was " + getTitle(),
        getTitle().equals(TITLE));
  }

  By contactLink = By.id("contact-link");
  By signInButton = By.className("login");
  //    public HomePage(WebDriver driver) {
  //        super(driver);
  //    }
  // WebDriverSettings ddd = new WebDriverSettings();
  public void clickOnContactLinkOnHomePage() {
    clickOn(contactLink);
    //        getDriver().findElement(By.id("contact-link")).click();
  }

  public void clickOnSignInButtonOnHomePage() {
    clickOn(signInButton);
    //        getDriver().findElement(By.id("contact-link")).click();
  }
}
