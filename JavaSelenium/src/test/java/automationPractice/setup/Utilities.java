package automationPractice.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities extends WebDriverSettings{
    public String getProperty(String key) throws IOException {
        FileReader fr = new FileReader("src\\test\\java\\test.properties");
        Properties p = new Properties();
        p.load(fr);
        return p.getProperty(key);
    }

    public void clickElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }
}
