package automationPractice.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
  public static WebDriver driver;

  public static void setUpChromeDriver() {
    System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public static void closeChromeDriver() {
    if (null != driver) {
      driver.close();
      driver.quit();
    }
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      setUpChromeDriver();
    }
    return driver;
  }
}
