package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

/**
 * Селекторы для https://www.saucedemo.com/
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
    public void openPage() {
        webDriver.get(BASE_URL);
    }

    @Step("Авторизация с данными из User.class: логин = {user.email}, пароль = ******")
    public void login(User user) {
        enterLogin(user.getEmail());
        webDriver.findElement(passwordPlaceHolder).sendKeys(user.getPassword());
        webDriver.findElement(loginButtonPlaceHolder).click();
    }

    @Step("Авторизация с данными (строковые значения)")
    public void login(String loginFieldValue, String passwordFieldValue) {
        webDriver.findElement(usernamePlaceHolder).sendKeys(loginFieldValue);
        webDriver.findElement(passwordPlaceHolder).sendKeys(passwordFieldValue);
        webDriver.findElement(loginButtonPlaceHolder).click();
    }

    @Step("Ввод логина")
    public void enterLogin(String userField) {
        webDriver.findElement(usernamePlaceHolder).sendKeys(userField);
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