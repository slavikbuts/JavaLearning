package automationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {
  protected WebDriver driver;

  public ContactUsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  //    final public static String TITLE = "Contact us - My Store";
  //    public ContactUsPage(){
  //        Assert.assertTrue(getTitle().equals(TITLE), "Expected Title to be "+TITLE+", but instead
  // was "
  //                        + getTitle());
  //    }

  //    By subjectSelect = By.id("id_contact");
  //    By messageField = By.id("message");
  //    By sendButton = By.id("submitMessage");
  //    By alertMessage = By.xpath("//*[@id='center_column']/p");
  //    By chooseFileButton = By.cssSelector("#uniform-fileUpload > span.action");
  //    Select dropdown = new Select(driver.findElement(subjectSelect));
  @FindBy(id = "id_contact")
  WebElement subjectSelect1;

  @FindBy(id = "message")
  WebElement messageField;

  @FindBy(id = "submitMessage")
  WebElement sendButton;

  @FindBy(xpath = "//*[@id='center_column']/p")
  WebElement alertMessage;

  public void selectSubject(String text) {
    Select dropdown = new Select(subjectSelect1);
    dropdown.selectByVisibleText(text);
  }

  public void typeMessage(String text) {
    messageField.sendKeys(text);
  }

  public void clickSendButton() {
    sendButton.click();
  }

  public String getAlertMessage() {
    return alertMessage.getText();
  }
}
