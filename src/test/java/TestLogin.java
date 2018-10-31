import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestLogin {


    private static WebDriver driver;


    @BeforeClass
    public static void prepareContext() {
        driver = WebDriverSingleton.getInstance();
        driver.get(TestData.PATH_TO_TARGET_PAGE);
    }



    @Before
    public void reset(){
        driver.get(TestData.PATH_TO_TARGET_PAGE);
    }

    @Test
    public void testLoginIsInvalid() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("Alpha");
        loginPage.setPassword("Password");
        loginPage.clickLogin().andLoginFailed(TestData.TIMEOUT_FOR_ALERT);
    }

    @Test
    public void testLoginIsSucceed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin(TestData.CORRECT_LOGIN);
        loginPage.setPassword(TestData.CORRECT_PASSWORD);
        loginPage.clickLogin().andLoginSucceed(TestData.TIMEOUT_FOR_ALERT);
    }


    @Test
    public void testEmptyCredentials() {
        // all creds are empty
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin().andLoginFailed(TestData.TIMEOUT_FOR_ALERT);

        //empty pass
        loginPage.setLogin("Alpha");
        loginPage.clickLogin().andLoginFailed(TestData.TIMEOUT_FOR_ALERT);

        // empty login
        loginPage.clearLoginInput();
        loginPage.setPassword(TestData.CORRECT_PASSWORD);
        loginPage.clickLogin().andLoginFailed(TestData.TIMEOUT_FOR_ALERT);


    }

    @AfterClass
    public static void stopBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
