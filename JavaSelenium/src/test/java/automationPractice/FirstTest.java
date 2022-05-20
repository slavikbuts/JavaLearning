package automationPractice;

import org.junit.Assert;
import org.junit.Test;

public class FirstTest extends WebDriverSettings{
    final public String URL = "http://automationpractice.com/";
    BasePage basePage;

    @Test
    public void firstTest() {
        driver.get("http://automationpractice.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("My Store"));
    }

    @Test
    public void firstTest2() {
        basePage.navigateTo(URL);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
//                .executeScript("return document.readyState")));
        Assert.assertTrue(basePage.getTitle().equals("Contact us - My Store"));
    }


}
