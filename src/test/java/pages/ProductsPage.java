package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver chromeBrowser;

    // Selectors for https://www.saucedemo.com/inventory.html
    By sauceLabsBackpackItem = By.xpath("//div[@class='inventory_item_name'][contains(text(), 'Sauce Labs Backpack')]");
    By pageTitle = By.xpath("//*[@data-test='title']");
    By backButton = By.cssSelector("[id='back-to-products'");

    public boolean isPageLoaded() {
        return chromeBrowser.findElement(pageTitle).isDisplayed();
    }

    public ProductsPage(WebDriver chromeBrowser) {
        this.chromeBrowser = chromeBrowser;
    }

    public void showProductItem(By itemNameSelector) {
        chromeBrowser.findElement(itemNameSelector).click();
    }

    public void backToProductButton() {
        chromeBrowser.findElement(backButton).click();
    }

    public boolean isBackToProductButtonAppear() {
        return chromeBrowser.findElement(backButton).isDisplayed();
    }
}
