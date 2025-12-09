package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

/**
 * Селекторы для <a href="https://www.saucedemo.com/">...</a>
 **/

public class LoginPage extends BasePage {

    By usernamePlaceHolder = By.cssSelector("[placeholder='Username']");
    By passwordPlaceHolder = By.id("password");
    By loginButtonPlaceHolder = By.id("login-button");
    By errorMessagePlaceHolder = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver chromeBrowser) {
        super(chromeBrowser);
    }

    @Step("Открытие страницы по URL")
    public LoginPage openPage() {
        webDriver.get(BASE_URL);
        return this;
    }

    @Step("Авторизация с данными из User.class: логин = {user.email}, пароль = ******")
    public LoginPage login(User user) {
        enterLogin(user.getEmail());
        webDriver.findElement(passwordPlaceHolder).sendKeys(user.getPassword());
        webDriver.findElement(loginButtonPlaceHolder).click();
        return this;
    }

    @Step("Авторизация с данными (строковые значения)")
    public void login(String loginFieldValue, String passwordFieldValue) {
        webDriver.findElement(usernamePlaceHolder).sendKeys(loginFieldValue);
        webDriver.findElement(passwordPlaceHolder).sendKeys(passwordFieldValue);
        webDriver.findElement(loginButtonPlaceHolder).click();
    }

    @Step("Ввод логина")
    public LoginPage enterLogin(String userField) {
        webDriver.findElement(usernamePlaceHolder).sendKeys(userField);
        return this;
    }

    @Step("Проверка отображения сообщения об ошибке")
    public boolean isErrorMessageAppear() {
        return webDriver.findElement(errorMessagePlaceHolder).isDisplayed();
    }

    @Step("Получение текста сообщения об ошибке")
    public String errorMessageText() {
        return webDriver.findElement(errorMessagePlaceHolder).getText();
    }
}