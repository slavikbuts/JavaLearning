package automationPractice.tests;

import org.testng.annotations.AfterClass;

import static automationPractice.setup.WebDriverSettings.closeChromeDriver;

public class BaseTest {
  @AfterClass
  public static void after() {
    closeChromeDriver();
  }
}
