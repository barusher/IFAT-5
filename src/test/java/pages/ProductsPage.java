package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Selectors for https://www.saucedemo.com/inventory.html
 **/

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_BUTTON_PATTER =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    By backButton = By.cssSelector("[id='back-to-products']");
    By cartCounter = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver chromeBrowser) {
        super(chromeBrowser);
    }

    public boolean isPageLoaded(String pageTitle) {
        return chromeBrowser.findElement(By.xpath(TEXT_LOCATOR_PATTERN.formatted(pageTitle))).isDisplayed();
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

    public void addToCartClick(String itemName) {
        By addItemToCart = By.xpath(ADD_TO_CART_BUTTON_PATTER.formatted(itemName));
        chromeBrowser.findElement(addItemToCart).click();
    }

    public void addToCartClick(int itemOrder) {
        chromeBrowser.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(itemOrder).click();
    }

    public int checkCartCounter() {
        return Integer.parseInt(chromeBrowser.findElement(cartCounter).getText());
    }
}
