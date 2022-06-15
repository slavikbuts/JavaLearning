package automationPractice.pages;

import automationPractice.setup.WebDriverSettings;
import org.openqa.selenium.WebDriver;

public class BasePage {
  protected WebDriver driver = WebDriverSettings.getDriver();

  public void navigateTo(String url) {
    driver.get(url);
  }

  public String getTitle() {
    return driver.getTitle();
  }
}
