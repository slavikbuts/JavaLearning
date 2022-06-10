package automationPractice.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage{
    final public static String TITLE = "Contact us - My Store";
    public ContactUsPage(){
        Assert.assertTrue("Expected Title to be "+TITLE+", but instead was "
                + getTitle(), getTitle().equals(TITLE));
    }
By subjectSelect = By.id("id_contact");
//By messageField = By.id("message");
WebElement messageField = driver.findElement(By.id("message"));
By sendButton  = By.id("submitMessage");
By alertMessage  = By.xpath("//*[@id='center_column']/p");
By chooseFileButton  = By.cssSelector("#uniform-fileUpload > span.action");
By chooseFileButton2  = By.cssSelector("#uniform-fileUpload > span.filename");

    Select dropdown = new Select(driver.findElement(subjectSelect));

    public void selectSubject(String text){
        dropdown.selectByVisibleText(text);
    }

    public void typeMessage(String text){
        messageField.sendKeys(text);
    }

    public void clickSendButton(){
        driver.findElement(sendButton).click();
    }

    public String getAlertMessage(){
        return driver.findElement(alertMessage).getText();
    }
}
