package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

/**
 * Selectors for https://www.saucedemo.com/
 **/

public class LoginPage extends BasePage {

    By UsernamePlaceHolder = By.cssSelector("[placeholder='Username']");
    By PasswordPlaceHolder = By.id("password");
    By LoginButtonPlaceHolder = By.id("login-button");
    By errorMessagePlaceHolder = By.xpath("//*[@data-test='error']");

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
        webDriver.findElement(PasswordPlaceHolder).sendKeys(user.getPassword());
        webDriver.findElement(LoginButtonPlaceHolder).click();
    }

    public void login(String loginFieldValue, String passwordFieldValue) {
        webDriver.findElement(UsernamePlaceHolder).sendKeys(loginFieldValue);
        webDriver.findElement(PasswordPlaceHolder).sendKeys(passwordFieldValue);
        webDriver.findElement(LoginButtonPlaceHolder).click();
    }

    public void enterLogin(String userField) {
        webDriver.findElement(UsernamePlaceHolder).sendKeys(userField);
    }

    public boolean isErrorMessageAppear() {
        return webDriver.findElement(errorMessagePlaceHolder).isDisplayed();
    }

    public String errorMessageText() {
        return webDriver.findElement(errorMessagePlaceHolder).getText();
    }
}
