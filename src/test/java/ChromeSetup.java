import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

public class ChromeSetup {

    WebDriver chromeBrowser;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    BasePage basePage;

    @BeforeMethod
    public void setOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--guest");
        chromeBrowser = new ChromeDriver(options);
        chromeBrowser.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        loginPage = new LoginPage(chromeBrowser);
        productsPage = new ProductsPage(chromeBrowser);
        cartPage = new CartPage(chromeBrowser);
        basePage = new BasePage(chromeBrowser);

    }

    @AfterMethod
    public void close() {
        chromeBrowser.manage().deleteAllCookies();
        chromeBrowser.quit();
    }
}
