package automationPractice.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    final public static String TITLE = "Login - My Store";
    public LoginPage(){
        Assert.assertTrue("Expected Title to be "+TITLE+", but instead was "
                + getTitle(), getTitle().equals(TITLE));
    }
    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By submitButton = By.id("SubmitLogin");
    By errorMessage = By.xpath("//*[@id='center_column']//li");
    By accountName = By.className("account");

    public void setEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public void clearEmailField(){
        driver.findElement(emailField).clear();
    }

    public void clearPasswordField(){
        driver.findElement(passwordField).clear();
    }

    public String getAccountName(){
        return driver.findElement(accountName).getText();
    }
}
