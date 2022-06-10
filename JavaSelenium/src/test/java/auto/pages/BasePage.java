package auto.pages;

import auto.driverSetup.DriverManager;
import auto.driverSetup.DriverManagerFactory;
import auto.driverSetup.DriverType;
import auto.steps.NavigateStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BasePage extends NavigateStep {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }
}
