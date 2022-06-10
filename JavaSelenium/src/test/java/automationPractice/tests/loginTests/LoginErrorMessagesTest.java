package automationPractice.tests.loginTests;

import automationPractice.pages.HomePage;
import automationPractice.pages.LoginPage;
import automationPractice.setup.Utilities;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class LoginErrorMessagesTest extends LoginPage {
    final public static String TITLE = "Login - My Store";
    public LoginErrorMessagesTest(){
        Assert.assertTrue("Expected Title to be "+TITLE+", but instead was "
                + getTitle(), getTitle().equals(TITLE));
    }
    static Utilities utilities = new Utilities();


    @BeforeClass
    public static void before() throws IOException {
        navigateTo(utilities.getProperty("url"));
        HomePage homePage = new HomePage();
        homePage.clickOnSignInButtonOnHomePage();
    }

    @AfterClass
    public static void after(){
        closeChromeDriver();
    }

    @Test
    public void verifyLoginWithoutPassword() throws IOException {
        setEmail(utilities.getProperty("correct.email"));
        clearPasswordField();
        clickOnSubmitButton();

        Assert.assertTrue("Expected error message be 'Password is required.', but instead was "
                + getErrorMessage(), getErrorMessage().equals("Password is required."));
    }

    @Test
    public void verifyLoginWithoutEmail() throws IOException {
        clearEmailField();
        setPassword(utilities.getProperty("correct.password"));
        clickOnSubmitButton();

        Assert.assertTrue("Expected error message be 'An email address required.', but instead was "
                + getErrorMessage(), getErrorMessage().equals("An email address required."));
    }

    @Test
    public void verifyLoginWitIncorrectPassword() throws IOException {
        setEmail(utilities.getProperty("correct.email"));
        setPassword(utilities.getProperty("incorrect.password"));
        clickOnSubmitButton();

        Assert.assertTrue("Expected error message be 'Authentication failed.', but instead was "
                + getErrorMessage(), getErrorMessage().equals("Authentication failed."));
    }



    @Test
    public void verifyLoginWithIncorrectEmail() throws IOException {
        setEmail(utilities.getProperty("incorrect.email"));
        setPassword(utilities.getProperty("correct.password"));
        clickOnSubmitButton();

        Assert.assertTrue("Expected error message be 'Invalid email address.', but instead was "
                + getErrorMessage(), getErrorMessage().equals("Invalid email address."));
    }
}
