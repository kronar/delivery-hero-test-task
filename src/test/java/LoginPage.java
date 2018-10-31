import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    //TODO better selector with class names
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public LoginPromise clickLogin() {
        loginBtn.click();
        return new LoginPromise(driver);
    }



    public void clearLoginInput(){
        loginInput.clear();
    }


    public void enableKeepMeLoggedIn() {
    }

    public void disableKeepMeLoggedIn() {
    }



}
