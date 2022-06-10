package auto.driverSetup.drivers;

import auto.driverSetup.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/drivers/geckodriver.exe");
        this.driver = new FirefoxDriver();
    }
}
