package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;


public class BasePage {

    public final static String BASE_URL = PropertyReader.getProperty("saucedemo.url");
    public final static String TEXT_LOCATOR_PATTERN = "//*[text()='%s']";

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        this.webDriver = webDriver;
    }

    @Step("Сhecks that page is loaded")
    public boolean isPageLoaded(String pageTitle) {
        return webDriver.findElement(By.xpath(TEXT_LOCATOR_PATTERN.formatted(pageTitle))).isDisplayed();
    }
}
