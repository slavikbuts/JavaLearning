package automationPractice;

public class BasePage extends WebDriverSettings{
    public void navigateTo(String url){
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
