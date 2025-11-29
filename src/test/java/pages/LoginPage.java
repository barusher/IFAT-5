package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Selectors for https://www.saucedemo.com/
 **/

public class LoginPage extends BasePage {

    By correctUsernameField = By.cssSelector("[placeholder='Username']");
    By correctPasswordField = By.id("password");
    By correctLoginButtonField = By.id("login-button");
    By errorMessage = By.xpath("//h3");

    public LoginPage(WebDriver chromeBrowser) {
        super(chromeBrowser);
    }

    public void openPage() {
        chromeBrowser.get(BASE_URL);
    }

    public void login(String loginField, String passwordField) {
        chromeBrowser.findElement(correctUsernameField).sendKeys(loginField);
        chromeBrowser.findElement(correctPasswordField).sendKeys(passwordField);
        chromeBrowser.findElement(correctLoginButtonField).click();
    }

    public boolean isErrorMessageAppear() {
        return chromeBrowser.findElement(errorMessage).isDisplayed();
    }

    public String errorMessageText() {
        return chromeBrowser.findElement(errorMessage).getText();
    }
}
