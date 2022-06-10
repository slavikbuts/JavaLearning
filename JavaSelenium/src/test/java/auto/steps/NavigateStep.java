package auto.steps;

import auto.driverSetup.DriverManager;
import auto.driverSetup.DriverManagerFactory;
import auto.driverSetup.DriverType;
import auto.pages.NavigatePage;
import org.openqa.selenium.WebDriver;

public class NavigateStep {
    DriverManager driverManager;
    WebDriver driver;
    NavigatePage navigatePage;

    public void navigateTo(DriverType browser, String url) {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.get(url);
    }

    public String getTitle() {
        driver = driverManager.getWebDriver();
        return driver.getTitle();
    }

    public void clickOnContactLink(){
        navigatePage.clickContactLink();
    }


}
