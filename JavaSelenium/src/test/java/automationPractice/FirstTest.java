package automationPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FirstTest extends WebDriverSettings{

    @Test
    public void firstTest() {
        driver.get("http://automationpractice.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("My Store"));
    }

    @Test
    public void firstTest2() {
        driver.get("http://automationpractice.com/");
        driver.findElement(By.id("contact-link")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
//                .executeScript("return document.readyState")));
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Contact us - My Store"));
    }
}
