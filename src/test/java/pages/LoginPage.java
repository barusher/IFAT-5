package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

/**
 * Selectors for https://www.saucedemo.com/
 **/

public class LoginPage extends BasePage {

    By correctUsernameField = By.cssSelector("[placeholder='Username']");
    By correctPasswordField = By.id("password");
    By correctLoginButtonField = By.id("login-button");
    By errorMessage = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver chromeBrowser) {
        super(chromeBrowser);
    }

    public void openPage() {
        webDriver.get(BASE_URL);
    }

    public void openPage(String url) {
        webDriver.get(BASE_URL + url);
    }

    public void login(User user) {
        enterLogin(user.getEmail());
        webDriver.findElement(correctPasswordField).sendKeys(user.getPassword());
        webDriver.findElement(correctLoginButtonField).click();
    }

    public void login(String loginFieldValue, String passwordFieldValue) {
        webDriver.findElement(correctUsernameField).sendKeys(loginFieldValue);
        webDriver.findElement(correctPasswordField).sendKeys(passwordFieldValue);
        webDriver.findElement(correctLoginButtonField).click();
    }

    public void enterLogin(String userField) {
        webDriver.findElement(correctUsernameField).sendKeys(userField);
    }

    public boolean isErrorMessageAppear() {
        return webDriver.findElement(errorMessage).isDisplayed();
    }

    public String errorMessageText() {
        return webDriver.findElement(errorMessage).getText();
    }
}
