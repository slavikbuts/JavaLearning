package automationPractice.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data //for try lombok
public class LoginPage extends BasePage {
  //    final public static String TITLE = "Login - My Store";
  //    public LoginPage(){
  //        Assert.assertTrue(getTitle().equals(TITLE), "Expected Title to be "+TITLE+", but instead
  // was "
  //                        + getTitle());
  //    }

  //    By emailField = By.id("email");

  //    By passwordField = By.id("passwd");
  //    By submitButton = By.id("SubmitLogin");
  //    By errorMessage = By.xpath("//*[@id='center_column']//li");
  //    By accountName = By.className("account");

  protected WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "email")
  WebElement emailField;

  @FindBy(id = "passwd")
  WebElement passwordField;

  @FindBy(id = "SubmitLogin")
  WebElement submitButton;

  @FindBy(xpath = "//*[@id='center_column']//li")
  WebElement errorMessage;

  @FindBy(className = "account")
  WebElement accountName;

  public void setEmail(String email) {
    //        emailField.clear();
    emailField.sendKeys(email);
  }

  public void setPassword(String password) {
    passwordField.clear();
    passwordField.sendKeys(password);
  }

  public void clickOnSubmitButton() {
    submitButton.click();
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }

  public void clearEmailField() {
    emailField.clear();
  }

  public void clearPasswordField() {
    passwordField.clear();
  }

  public String getAccountName() {
    return accountName.getText();
  }
}
