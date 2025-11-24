import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class ChromeSetup {

    WebDriver chromeBrowser;

    LoginPage loginPage;

    ProductsPage productsPage;

    @BeforeMethod
    public void setOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--guest");

        chromeBrowser = new ChromeDriver(options);
        chromeBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(chromeBrowser);
        productsPage = new ProductsPage(chromeBrowser);
    }

    @AfterMethod
    public void close() {
        chromeBrowser.manage().deleteAllCookies();
        chromeBrowser.quit();
    }
}
