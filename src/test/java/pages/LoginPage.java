package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver chromeBrowser;

    // Selectors for https://www.saucedemo.com
    By correctUsernameField = By.cssSelector("[placeholder='Username']");
    By correctPasswordField = By.id("password");
    By correctLoginButtonField = By.id("login-button");
    By errorMessage = By.xpath("//h3");

    public void openPage() {
        chromeBrowser.get("https://www.saucedemo.com/");
    }

    public void login(String loginField, String passwordField) {
        chromeBrowser.findElement(correctUsernameField).sendKeys(loginField);
        chromeBrowser.findElement(correctPasswordField).sendKeys(passwordField);
        chromeBrowser.findElement(correctLoginButtonField).click();
    }

    public LoginPage(WebDriver chromeBrowser) {
        this.chromeBrowser = chromeBrowser;
    }

    public boolean isErrorMessageAppear() {
        return chromeBrowser.findElement(errorMessage).isDisplayed();
    }

    public String errorMessageText() {
        return chromeBrowser.findElement(errorMessage).getText();
    }
}
