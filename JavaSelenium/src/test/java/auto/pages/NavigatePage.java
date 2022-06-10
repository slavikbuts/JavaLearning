package auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatePage extends BasePage{
    public NavigatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "contact-link")
    WebElement contactLink;

    public void clickContactLink(){
        contactLink.click();
    }


}
