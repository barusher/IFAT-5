import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTests extends ChromeSetup {

    @Test
    public void checkItemsInCart() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageLoaded("Products");
        productsPage.addToCartClick("Sauce Labs Fleece Jacket");
        productsPage.addToCartClick("Sauce Labs Backpack");
        productsPage.switchToCart();
        assertEquals(cartPage.getProductsNames().size(), 2);
    }
}
