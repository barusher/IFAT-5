package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Селекторы для <a href="https://www.saucedemo.com/inventory.html">...</a>
 **/

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_BUTTON_PATTER =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    By backButton = By.cssSelector("[id='back-to-products']");
    By cartCounter = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver chromeBrowser) {
        super(chromeBrowser);
    }

    @Step("Открытие карточки товара")
    public void showProductItem(By itemNameSelector) {
        webDriver.findElement(itemNameSelector).click();
    }

    @Step("Проверка отображения кнопки 'Back to products'")
    public boolean isBackToProductButtonAppear() {
        return webDriver.findElement(backButton).isDisplayed();
    }

    @Step("Добавление товара '{itemName}' в корзину")
    public void addToCartClick(String itemName) {
        By addItemToCart = By.xpath(ADD_TO_CART_BUTTON_PATTER.formatted(itemName));
        webDriver.findElement(addItemToCart).click();
    }

    @Step("Добавление товара по индексу {numberOfItems} в корзину")
    public void addToCartClick(int numberOfItems) {
        webDriver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(numberOfItems).click();
    }

    @Step("Переход в корзину")
    public void switchToCart() {
        webDriver.findElement(cartCounter).click();
    }

    @Step("Проверка счетчика товаров в корзине")
    public int checkCartCounter() {
        return Integer.parseInt(webDriver.findElement(cartCounter).getText());
    }
}