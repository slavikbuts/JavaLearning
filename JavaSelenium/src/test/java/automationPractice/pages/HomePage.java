package automationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
  //  public static final String TITLE = "My Store";
  //  public HomePage() {
  //    Assert.assertTrue(
  //            getTitle().equals(TITLE),
  //            "Expected Title to be " + TITLE + ", but instead was " + getTitle());
  //  }
  protected WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "contact-link")
  WebElement contactLink;

  @FindBy(className = "login")
  WebElement signInButton;

  //  By contactLink = By.id("contact-link");
  //  By signInButton = By.className("login");
  public void clickOnContactLinkOnHomePage() {
    contactLink.click();
  }

  public void clickOnSignInButtonOnHomePage() {
    signInButton.click();
  }
}
