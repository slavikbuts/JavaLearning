package automationPractice.tests.loginTests;

import automationPractice.pages.LoginPage;
import automationPractice.pages.HomePage;
import automationPractice.setup.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

import java.io.*;

public class LoginTest extends LoginPage {

    static Utilities utilities = new Utilities();
    public static Logger log = LogManager.getLogger();


    @BeforeClass
    public static void before() throws IOException {
        log.info("Navigate to URL " + utilities.getProperty("url"));
        navigateTo(utilities.getProperty("url"));
        HomePage homePage = new HomePage();
        log.info("Navigate to Login Page");
        homePage.clickOnSignInButtonOnHomePage();
    }

    @AfterClass
    public static void after(){
        closeChromeDriver();
    }

    @Test
    public void verifySuccessfulLogin() throws IOException {
        String firstName = utilities.getProperty("first.name");
        String lastName = utilities.getProperty("last.name");
        log.info("Type Email address =>" + utilities.getProperty("correct.email"));
        setEmail(utilities.getProperty("correct.email"));
        log.info("Type Password =>" + utilities.getProperty("correct.password"));
        setPassword(utilities.getProperty("correct.password"));
        log.info("Click on 'Sign in' button");
        clickOnSubmitButton();

        Assert.assertTrue("Expected Account name to be " + firstName + " " + lastName +" ,but instead was "
                + getAccountName(), getAccountName().equals(firstName + " " + lastName));
    }




}
