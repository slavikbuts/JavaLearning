package auto.driverSetup.drivers;

import auto.driverSetup.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }
}
