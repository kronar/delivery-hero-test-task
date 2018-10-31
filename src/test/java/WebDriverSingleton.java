import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {


    private static WebDriver INSTANCE = createWebDriver();

    private static WebDriver createWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriverSingleton() {
    }


    public static WebDriver getInstance() {
        return INSTANCE;
    }
}
