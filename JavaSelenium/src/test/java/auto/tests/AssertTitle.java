package auto.tests;

import auto.driverSetup.DriverManager;
import auto.driverSetup.DriverManagerFactory;
import auto.driverSetup.DriverType;
import auto.steps.NavigateStep;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AssertTitle {
    NavigateStep navigateStep = new NavigateStep();

    final public String URL = "http://automationpractice.com/";

    @Test
    public void checkTitleOfHomePage() {
        navigateStep.navigateTo(DriverType.CHROME, URL);
        navigateStep.clickOnContactLink();
        Assert.assertTrue(navigateStep.getTitle().equals("My Store"));

    }

    @Test
    public void checkTitleOfContactPage() {
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
//        driver = driverManager.getWebDriver();
//        driver.get("https://www.google.com");

        navigateStep.navigateTo(DriverType.CHROME, URL);
//        navigateStep.navigateTo(URL);
//        Assert.assertEquals("My Store", driver.getTitle());
//        String ddd = driverManager.getWebDriver().getTitle();
        navigateStep.clickOnContactLink();
        Assert.assertTrue(navigateStep.getTitle().equals("My Store"));

    }
}
