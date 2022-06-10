package automationPractice.pages;

import automationPractice.setup.WebDriverSettings;
import org.openqa.selenium.By;

public class BasePage extends WebDriverSettings{
    public static void navigateTo(String url){
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickOn(By locator){
        driver.findElement(locator).click();
    }
}
