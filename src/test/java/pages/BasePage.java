package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public final static String TEXT_LOCATOR_PATTERN = "//*[text()='%s']";

    WebDriver chromeBrowser;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver chromeBrowser) {
        this.webDriverWait = new WebDriverWait(chromeBrowser, Duration.ofSeconds(5));
        this.chromeBrowser = chromeBrowser;
    }

}
