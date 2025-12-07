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

    public void showProductItem(By itemNameSelector) {
        webDriver.findElement(itemNameSelector).click();
    }

    public boolean isBackToProductButtonAppear() {
        return webDriver.findElement(backButton).isDisplayed();
    }

    public void addToCartClick(String itemName) {
        By addItemToCart = By.xpath(ADD_TO_CART_BUTTON_PATTER.formatted(itemName));
        webDriver.findElement(addItemToCart).click();
    }

    public void addToCartClick(int numberOfItems) {
        webDriver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(numberOfItems).click();
    }

    public void switchToCart() {
        webDriver.findElement(cartCounter).click();
    }

    public int checkCartCounter() {
        return Integer.parseInt(webDriver.findElement(cartCounter).getText());
    }
}
