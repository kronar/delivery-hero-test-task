import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPromise {


    private static final By SUCCESS_ALERT = By.xpath("//div[@class='alert alert-success']");
    private static final By FAILED_ALERT = By.xpath("//div[@class='alert alert-danger']");
    private WebDriver driver;

    public LoginPromise(WebDriver driver) {
        this.driver = driver;
    }


    public void andLoginSucceed(int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        WebElement until = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_ALERT));
    }


    public void andLoginFailed(int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        WebElement until = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FAILED_ALERT));
    }
}
